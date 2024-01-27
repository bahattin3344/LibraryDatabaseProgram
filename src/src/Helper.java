package src;

import java.util.Scanner;

public class Helper {
    static Scanner scan = new Scanner(System.in);

    private static String loggedInUsername;
    private static UserRole loggedInUserRole;

    private static void login() {
        if (loggedInUserRole == null)
            while (true) {
                System.out.println("User name: ");
                String username = scan.nextLine();
                System.out.println("Password: ");
                String password = scan.nextLine();

                if (username.equals("admin") && password.equals("Admin123")) {
                    loggedInUserRole = UserRole.ADMIN;
                    System.out.println("Logged in as admin!");
                    return;
                } else if (username.equals("user") && password.equals("User123")) {
                    loggedInUserRole = UserRole.USER;
                    System.out.println("Logged in as standard user!");
                    return;
                } else {
                    loggedInUserRole = null;
                    System.out.println("Invalid username or password!");
                }
            }
    }

    public static void mainMenu() throws InterruptedException {

        login();
        if (loggedInUserRole == UserRole.ADMIN) {
            showAdminMenu();
        } else if (loggedInUserRole == UserRole.USER) {
            showUserMenu();
        }

        String vote = "";
        do {
            System.out.println(
                    "\n=========== TECHNO STUDY CONFLUENCE =============\\n\" +\n" +
                            "\"=================== MAIN MENU =====================\\n\" +\n" +
                            "\"\\n\" +\n" +
                            "\"\\t 1- View Library Information\\n\" +\n" +
                            "\"\\t 2- Members Menu\\n\" +\n" +
                            "\"\\t 3- Books Menu\\n\" +\n" +
                            "\"\\t Q- EXIT\\n");
            System.out.print("Please make your choice from the menu:");

            vote = scan.nextLine().toLowerCase();

            switch (vote) {
                case "1":
                    printLibraryInformation();
                    break;
                case "2":
                    loginAndShowUserMenu(UserRole.ADMIN);
                    break;
                case "3":
                    loginAndShowUserMenu(UserRole.ADMIN);
                    break;
                case "q":
                    break;
                default:
                    System.out.print("Please enter a valid preference:");
            }

        } while (!vote.equalsIgnoreCase("q"));

        exit();
    }

    public static void printLibraryInformation() throws InterruptedException {

        System.out.print("Printing library information...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }

        System.out.println("\n" +
                "\n============= TECHNO STUDY CONFLUENCE =============\n" +
                "\t\t Library : " + Library.libraryName +
                "\n\t\t Address : " + Library.address +
                "\n\t\t Phone : " + Library.phone);

    }

    private static void loginAndShowUserMenu(UserRole requiredRole) throws InterruptedException {
        System.out.print("User name: ");
        String username = scan.nextLine();
        System.out.print("Password: ");
        String password = scan.nextLine();

        UserRole role = authenticateUser(username, password);

        if (role == null) {
            System.out.println("Invalid username or password.");
        } else if (role == requiredRole || role == UserRole.ADMIN) {
            if (requiredRole == UserRole.ADMIN) {
                showAdminMenu();
            } else {
                showUserMenu();
            }
        } else {
            System.out.println("You do not have permission to access this page.");
        }
    }

    private static UserRole authenticateUser(String username, String password) {
        if ("admin".equalsIgnoreCase(username) && "Admin123".equals(password)) {
            return UserRole.ADMIN;
        } else if ("uye".equalsIgnoreCase(username) && "Uye123".equals(password)) {
            return UserRole.USER;
        }
        return null;
    }

    private static void showAdminMenu() throws InterruptedException {
        System.out.println(
                "\n=========== TECHNO STUDY CONFLUENCE ==========\\n\" +\n" +
                        "\"================== ADMIN MENU ================\\n\" +\n" +
                        "\"\\n\" +\n" +
                        "\"\\t 1- Members Menu\\n\" +\n" +
                        "\"\\t 2- Books Menu\\n\" +\n" +
                        "\"\\t A- ANAMENU\\n\" +\n" +
                        "\"\\t Q- EXIT");
        String vote = scan.nextLine().toLowerCase();
        switch (vote) {
            case "1":
                UyeManager.uyeMenu();
                break;
            case "2":
                BookManager.bookMenu();
                break;
            case "a":
                mainMenu();
                break;
            case "q":
                exit();
                break;
            default:
                System.out.println("Please enter a valid preference");
        }
    }

    private static void showUserMenu() throws InterruptedException {
        String vote = "";
        do {
            System.out.println(
                          "\n========== TECHNO STUDY CONFLUENCE ===========\\n\" +\n" +
                                  "\"================== USER MENU =================\\n\" +\n" +
                                  "\"\\n\" +\n" +
                                  "\"\\t 1- List Members\\n\" +\n" +
                                  "\"\\t 2- Finding a Member by Surname\\n\" +\n" +
                                  "\"\\t 3- Finding Members by City\\n\" +\n" +
                                  "\"\\t 4- List Books\\n\" +\n" +
                                  "\"\\t 5- Finding a Book by the Author\\n\" +\n" +
                                  "\"\\t 6- Finding a Book by Book Tour or Publication Date\\n\" +\n" +
                                  "\"\\t 7- Buy Book Wood\\n\" +\n" +
                                  "\"\\t 8- Return the Book\\n\" +\n" +
                                  "\"\\t A- MAIN MENU\\n\" +\n" +
                                  "\"\\t Q- EXIT");
            vote = scan.nextLine().toLowerCase();

            switch (vote) {
                case "1":
                    UyeManager.memberListPrint();
                    break;
                case "2":
                    UyeManager.findingMemberBySurname();
                    break;
                case "3":
                    UyeManager.FindMemberByCity();
                    break;
                case "4":
                    BookManager.printBookList();
                    break;
                case "5":
                    BookManager.findingBookFromAuthor();
                    break;
                case "6":
                    BookManager.findingByTypeOrHistory();
                    break;
                case "7":
                    BookManager.borrowBook();
                    break;
                case "8":
                    BookManager.bookReturn();
                    break;
                case "a":
                    mainMenu();
                    break;
                case "q":
                    exit();
                    break;
                default:
                    System.out.println("Please enter a valid preference");
            }
        } while (!vote.equalsIgnoreCase("Q"));
    }

    public static void exit() {
        System.out.println("You left the library project");
        System.exit(0);
    }
}


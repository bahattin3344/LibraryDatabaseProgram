package src;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class BookManager extends Database {

    static Scanner scan = new Scanner(System.in);

    public static void bookMenu() throws InterruptedException {
        String vote = "";
        do {
            System.out.println(
                          "\n============ TECHNO STUDY BOOTCAMP ============\n" +
                                  "================== BOOK MENU =================\n" +
                                  "\t 1- Print Book List\n" +
                                  "\t 2- Finding a Book by the Author\n" +
                                  "\t 3- Finding a Book by Book Tour or Publication Date\n" +
                                  "\t 4- Adding a Book by Entering Information\n" +
                                  "\t 5- Deleting a Record with a Book Name \t\n" +
                                  "\t 6- Buy Book Wood \t\n" +
                                  "\t 7- Return the Book \t\n" +
                                  "\t A- MAIN MENU\n" +
                                  "\t Q- EXIT");
            vote = scan.nextLine().toLowerCase();
            switch (vote) {
                case "1":
                    printBookList();
                    break;
                case "2":
                    findingBookFromAuthor();
                    break;
                case "3":
                    turVeyaYayinTarihiIleKitapBulma();
                    break;
                case "4":
                    addBook();
                    break;
                case "5":
                    deleteByName();
                    break;
                case "6":
                    borrowBook();
                    break;
                case "7":
                    bookReturn();
                    break;
                case "a":
                    Helper.mainMenu();
                    break;
                case "q":
                    Helper.exit();
                    break;
                default:
                    System.out.println("Please enter a valid preference");
            }


        } while (!vote.equalsIgnoreCase("q"));
        Helper.exit();

    }

    public static void borrowBook() {
        System.out.println("Enter the name of the book you want to borrow: ");
        String bookName = scan.nextLine();

        if (booksMap.containsKey(bookName)) {
            String kitapBilgisi = booksMap.get(bookName);
            borrowedKitaplarMap.put(bookName, kitapBilgisi);
            booksMap.remove(bookName);
            System.out.println(bookName + " The book named was taken from the loan.");
        } else {
            System.out.println("No book with the specified name was found.");
        }
    }


    public static void bookReturn() {
        System.out.println("Enter the name of the book you want to return: ");
        String nameBook = scan.nextLine();

        if (borrowedKitaplarMap.containsKey(nameBook)) {
            String informationBook = borrowedKitaplarMap.get(nameBook);
            booksMap.put(nameBook, informationBook);
            borrowedKitaplarMap.remove(nameBook);
            System.out.println(nameBook + " The forensic book was returned.");
        } else {
            System.out.println("No borrowed book with the specified name was found.");
        }
    }


    private static void deleteByName() throws InterruptedException {
        System.out.println("Enter the name of the book to be deleted");
        String deletedBook = scan.nextLine();

        String deletedValue = booksMap.get(deletedBook);
        String conclusionValue = booksMap.remove(deletedBook);

        System.out.print(deletedBook + " Deleting...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }


        try {
            boolean conclusion = conclusionValue.equals(deletedValue);
        } catch (Exception e) {
            System.out.println("The book name you requested could not be found.");
        }

    }

    private static void addBook() {
        System.out.println("Enter Book Name: ");
        String bookName = scan.nextLine();
        System.out.println("Enter Author Name: ");
        String writerName = scan.nextLine();
        BooksType booksType = null;
        while (true) {
            try {
                System.out.print("Book Type: ");
                booksType = BooksType.valueOf(scan.nextLine().toUpperCase());
                break;
            } catch (Exception e) {
                System.out.println("Incorrect entry! Please re-enter the book tour: ");
            }
        }

        System.out.println("Release date: ");
        String yayinTarihi = scan.nextLine();

        String key = bookName;
        String value = writerName + ", " + booksType.name() + ", " + yayinTarihi;
        booksMap.put(key, value);
    }

    public static void findingByTypeOrHistory() throws InterruptedException {
        Set<Map.Entry<String, String>> myEntrySet = booksMap.entrySet();

        System.out.println("Write the type of the book you want: ");
        System.out.println("(History, Detective, Fiction, Novel, Epic)");
        String desiredBookTour = scan.nextLine();
        System.out.println("Write your desired publication date:");
        String desiredPublicationDate = scan.nextLine();

        System.out.print(desiredBookTour + "," + desiredPublicationDate + " Scanning...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }
        System.out.println(
                      "\n============ TECHNO STUDY CONFLUENCE ==========\n" +
                              "================= BOOK LIST ===============\n" +
                              "Book Title: Author Name, Book Tour, Year of Publication");

        for (Map.Entry<String, String> each : myEntrySet)
        {
            String eachKey = each.getKey();
            String eachValue = each.getValue();
            String[] eachValueArr = eachValue.split(", ");
            if (desiredBookTour.equalsIgnoreCase(eachValueArr[1]) || desiredPublicationDate.equalsIgnoreCase(eachValueArr[2]))
                System.out.println(eachKey + " : " + eachValue + " | ");
        }
    }


    public static void findingBookFromAuthor() throws InterruptedException {
        Set<Map.Entry<String, String>> myEntrySet = booksMap.entrySet();

        System.out.println("Type the author name you want: ");
        String desiredAuthorName = scan.nextLine();

        System.out.print(desiredAuthorName + " Searching...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }

        System.out.println(
                      "\n============ TECHNO STUDY CONFLUENCE ==========\\n\" +\n" +
                              "\"================= BOOK LIST ===============\\n\" +\n" +
                              "\"Book Name: Author Name, Book Tour, Year of Publication");

        for (Map.Entry<String, String> each : myEntrySet) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();
            String[] eachValueArr = eachValue.split(", ");

            if ((eachValueArr[0].toLowerCase()).contains(desiredAuthorName.toLowerCase())) {
                System.out.println(eachKey + "  : " + eachValue);
            }
        }
    }

    public static void printBookList() throws InterruptedException {

        Set<Map.Entry<String, String>> myEntrySet = booksMap.entrySet();

        System.out.print("Registered books are being printed...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }

        System.out.println(
                "\n============ TECHNO STUDY CONFLUENCE ==========\\n\" +\n" +
                        " \"================= BOOK LIST ===============\\n\" +\n" +
                        "\"Book Name: Author Name, Book Tour, Year of Publication");

        for (Map.Entry<String, String> each : myEntrySet) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();

            System.out.println(eachKey + " : " + eachValue + " | ");
        }
    }
}

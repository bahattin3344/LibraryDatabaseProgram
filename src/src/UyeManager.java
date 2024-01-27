package src;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class UyeManager extends Database {
    static Scanner scan = new Scanner(System.in);

    public static void uyeMenu() throws InterruptedException {
        String vote = "";
        do {

            System.out.println(
                    "\n========== TECHNO STUDY CONFLUENCE =========\\n\" +\n" +
                            "\"================= USER MENU =================\\n\" +\n" +
                            "\"\\n\" +\n" +
                            "\"\\t 1- Print Member List\\t\\n\" +\n" +
                            "\"\\t 2- Finding a Member by Surname\\n\" +\n" +
                            " \"\\t 3- Finding Members by City\\n\" +\n" +
                            " \"\\t 4- Adding a Member by Entering Their Information\\n\" +\n" +
                            "  \"\\t 5- Deleting Registration with ID Number \\t\\n\" +\n" +
                            "  \"\\t A- MAIN MENU\\n\" +\n" +
                            " \"\\t Q- EXIT\\n");
            vote = scan.nextLine();

            switch (vote) {

                case "1": //
                    memberListPrint();
                    break;
                case "2": //
                    findingMemberBySurname();
                    break;
                case "3": //
                    FindMemberByCity();
                    break;
                case "4": //
                    addMember();
                    break;
                case "5": //
                    deleteByTcNo();
                    break;
                case "a":
                case "A":
                    Helper.mainMenu();
                    break;
                case "q":
                case "Q":
                    break;
                default:
                    System.out.println("Please make valid choices: ");
            }

        } while (!vote.equalsIgnoreCase("q"));
        Helper.exit();
    }

    public static void deleteByTcNo() throws InterruptedException {
        System.out.println("Enter the ID number of the member to be deleted: ");
        String deletedMember = scan.nextLine();

        String deletedValue = membersMap.get(deletedMember);
        String conclusionValue = membersMap.remove(deletedMember);

        System.out.print(deletedMember + " Deleting...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }

        try {
            boolean conclusion = conclusionValue.equals(deletedValue);
        } catch (Exception e) {
            System.out.println("No member was found with the TR number you requested.");
        }
    }

    public static void addMember() {
        System.out.println("Tc no: ");
        String tcNo = scan.nextLine();
        System.out.println("Name:");
        String name = scan.nextLine();
        System.out.println("Surname:");
        String surname = scan.nextLine();
        System.out.println("City: ");
        String city = scan.nextLine();
        System.out.println("Birthyear: ");
        String birthYear = scan.nextLine();

        String addValue = name + ", " + surname + ", " + city + ", " + birthYear;
        membersMap.put(tcNo, addValue);
    }

    public static void FindMemberByCity() throws InterruptedException {
        System.out.println("Enter the City of the Member You Are Looking for:");
        String desiredCity = scan.nextLine();

        System.out.print(desiredCity + " Listing Members...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }

        Set<Map.Entry<String, String>> uyelerEntrySet = membersMap.entrySet();
        System.out.println(
                      "\n============= TECHNO STUDY CONFLUENCE =============\\n\" +\n" +
                              "\"=============== MEMBER SEARCH WITH CITY ===============\\n\" +\n" +
                              "\"TcNo: Name, Surname, City, Date of Birth");


        for (Map.Entry<String, String> each : uyelerEntrySet) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();

            String[] eachValuarr = eachValue.split(", ");
            if (eachValuarr[2].toLowerCase().contains(desiredCity.toLowerCase())) {
                System.out.println(eachKey + " : " + eachValue + " | ");
            }
        }
    }

    public static void findingMemberBySurname() throws InterruptedException {
        System.out.println("Enter all or part of the surname of the member you are looking for:");
        String desiredsurname = scan.nextLine();

        Set<Map.Entry<String, String>> uyelerEntrySet = membersMap.entrySet();

        System.out.print(desiredsurname + " Searching...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }

        System.out.println(
                      "\n========== TECHNO STUDY BOOTCAMP ===========\\n\" +\n" +
                              "\"=========== MEMBER SEARCH BY SURNAME ==========\\n\" +\n" +
                              "\"TcNo: Name, Surname, City, Date of Birth");


        for (Map.Entry<String, String> each : uyelerEntrySet) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();
            String[] eachValuarr = eachValue.split(", ");


            if (eachValuarr[1].toLowerCase().contains(desiredsurname.toLowerCase())) {
                System.out.println(eachKey + " : " + eachValue + " | ");
            }
        }
    }

    public static void memberListPrint() throws InterruptedException {

        Set<Map.Entry<String, String>> uyelerEntrySet = membersMap.entrySet();

        System.out.print("Member List is printing...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }

        System.out.println(
                      "\n========== TECHNO STUDY CONFLUENCE =========\\n\" +\n" +
                              "\"=============== MEMBER LIST ================\\n\" +\n" +
                              "\"TcNo: Name, Surname, City, Date of Birth");

        for (Map.Entry<String, String> each : uyelerEntrySet) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();

            System.out.println(eachKey + " : " + eachValue + " | ");
        }
    }


}

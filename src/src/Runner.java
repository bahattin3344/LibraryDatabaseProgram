package src;

public class Runner {

    public static void main(String[] args) throws InterruptedException {

        Database.HomeMembersCreateDatabase();
        Database.HomeBooksCreateDatabase();
        Helper.mainMenu();
    }
}
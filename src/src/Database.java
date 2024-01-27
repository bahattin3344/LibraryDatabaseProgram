package src;

import java.util.HashMap;
import java.util.Map;

public class Database {

    static Map<String, String> membersMap = new HashMap<>();
    public static void HomeMembersCreateDatabase() {
        membersMap.put("469922399405", "Ali, Can, Izmir, 2008");
        membersMap.put("165776787406", "Hikmet, Ran, Ankara, 2000");
        membersMap.put("143244487408", "Ayse, Can, Mersin, 1995");
        membersMap.put("648643787403", "Ahmet, Yesil, Adana, 2003");
        membersMap.put("123245967407", "Zehra, Kara, Izmir, 1979");
        membersMap.put("124366976453", "Betul, Usluer, Istanbul, 2005");
        membersMap.put("125422676778", "Oktay, Sari, Istanbul, 1999");
        membersMap.put("129390405664", "Bahtiyar, Gul, Siirt, 1983");
        membersMap.put("654322503029", "Ali hikmet, Yasar, Izmir, 1983");
        membersMap.put("212454369848", "Nermin, Ali, Ankara, 1983");
    }

    static Map<String, String> booksMap = new HashMap<>();
    public static void HomeBooksCreateDatabase() {
        booksMap.put("A Tale of Two Cities", "Charles Dickens, TARIH, 1859");
        booksMap.put("Ten Little Niggers", "Agatha Christie, POLISIYE, 1939");
        booksMap.put("Le Petit Prince", "Antoine de Saint-Exupery, KURGU, 1943");
        booksMap.put("The Hobbit", "J. R. R. Tolkien, KURGU, 1937");
        booksMap.put("The Lord of the Rings", "J. R. R. Tolkien, KURGU, 1954-1955");
        booksMap.put("Hong lou meng", "Cao Xueqin, DESTAN, 1759-1791");
        booksMap.put("Simyaci", "Paulo Coelho, ROMAN, 1988");
        booksMap.put("Hayvan Ciftligi", "George Orwell, ROMAN, 1945");
        booksMap.put("Bindokuzyuzseksendort", "George Orwell, ROMAN, 1949");
        booksMap.put("Harry Potter", "J.K. Rowling, KURGU, 1997");
    }

    static Map<String, String> borrowedKitaplarMap = new HashMap<>();

}

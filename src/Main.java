import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    private static final String PASSWORD = "249";
    private static final int MAX_ATTEMPTS = 3;
    private static final int MAX_TOTAL_ATTEMPTS = 12;
    private static int failedAttemtps = 0;
    private static boolean ACCESS_GRANTED = false;


    public static void main(String[] args) {



        System.out.println("Hello and Welcome.");
        System.out.println("Book Max");
        int maxBook = scanner.nextInt();
        boolean quit = false;
        Book[] inventory = new Book[maxBook];

        while(!quit) {
            switch (displayMenu()) {
                case 1:
                    security();
                    if(ACCESS_GRANTED) {
                        addBook(inventory);
                    }
                break;
                case 2:
                    security();
                    if(ACCESS_GRANTED) {

                    }
                break;
                case 3:

                break;
                case 4:

                break;
                case 5:
                    quit = true;
                break;
                default:
                    System.out.println("Invalid choice");
                break;

            }
        }

    }



    private static int displayMenu(){
        System.out.println("What do you want to do?\n" +
                "1. Enter new books (password required)\n" +
                "2. Change information of a book (password required)\n" +
                "3. Display all books by a specific author\n" +
                "4. Display all books under a certain a price.\n" +
                "5. Quit\n" +
                "Please enter your choice > \n");
        return scanner.nextInt();
    }

    private static void security(){
        int failedTriesInOneGo = 0;
        if(failedAttemtps != MAX_TOTAL_ATTEMPTS) {

            while (failedTriesInOneGo < MAX_ATTEMPTS) {
                System.out.println("Please enter your password");
                String password = scanner.next();
                if (password.equals(PASSWORD)) {
                    ACCESS_GRANTED = true;
                    break;
                }else {
                    System.out.println("Invalid password");
                    failedTriesInOneGo++;
                    failedAttemtps++;
                }
            }

        }
        if(failedAttemtps == MAX_TOTAL_ATTEMPTS){
            System.out.println("Program detected suspicious activities and will terminate immediately.");
            System.exit(0);
        }
    }

    private static void addBook(Book[] inventory) {
        System.out.println("How many books do you want to add.");
        int numberOfBooksToAdd = scanner.nextInt();
        int unusedSpace = 0;
        for (int i = 0; i < inventory.length; i++) {
            if(inventory[i] == null) {
                unusedSpace++;
            }
        }

        if(unusedSpace >= numberOfBooksToAdd) {
            for (int i = 0; i < inventory.length; i++) {
                if(inventory[i] == null) {
                    System.out.println("Title - Author - ISBN - Price");
                    inventory[i] = new Book(scanner.next(), scanner.next() , scanner.nextLong() , scanner.nextDouble());
                }
            }
        }else{
            System.out.println("Sorry no more Space available.");
        }
        ACCESS_GRANTED = false;
    }

    private static void modifyBook(Book[] inventory){
        System.out.println("Which book would you like to modify? (Input the Index)");
        int bookIndex = scanner.nextInt();

        if( bookIndex < inventory.length && inventory[bookIndex] != null) {
            System.out.println("What information would you like to change?\n" +
                    "1. author\n" +
                    "2. title\n" +
                    "3. ISBN\n" +
                    "4. price\n" +
                    "5. Quit\n" +
                    "Enter your choice >");
            byte attribute = scanner.nextByte();

            switch (attribute) {
                case 1:

            }


        }
    }
}

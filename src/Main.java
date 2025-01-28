import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    private static final String PASSWORD = "249";
    private static final int MAX_ATTEMPTS = 3;
    private static final int MAX_TOTAL_ATTEMPTS = 12;
    private static int failedAttempts = 0;
    private static boolean accessGranted = false;


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
                    if(accessGranted) {
                        addBook(inventory);
                    }
                break;
                case 2:
                    security();
                    if(accessGranted) {
                        modifyBook(inventory);
                    }
                break;
                case 3:
                    searchByAuthor(inventory);
                break;
                case 4:
                    searchUnderPrice(inventory);
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
        if(failedAttempts != MAX_TOTAL_ATTEMPTS) {

            while (failedTriesInOneGo < MAX_ATTEMPTS) {
                System.out.println("Please enter your password");
                String password = scanner.next();
                if (password.equals(PASSWORD)) {
                    accessGranted = true;
                    break;
                }else {
                    System.out.println("Invalid password");
                    failedTriesInOneGo++;
                    failedAttempts++;
                }
            }

        }
        if(failedAttempts == MAX_TOTAL_ATTEMPTS){
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
        accessGranted = false;
    }

    private static void modifyBook(Book[] inventory){
        System.out.println("Which book would you like to modify? (Input the Index)");
        int bookIndex = scanner.nextInt();

        if( bookIndex < inventory.length && inventory[bookIndex] != null) {
            System.out.println(inventory[bookIndex]);
            boolean quit = false;

            while(!quit) {
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
                        System.out.println("New author : ");
                        inventory[bookIndex].setAuthor(scanner.next());
                        System.out.println(inventory[bookIndex]);
                        break;
                    case 2:
                        System.out.println("New Title : ");
                        inventory[bookIndex].setTitle(scanner.next());
                        System.out.println(inventory[bookIndex]);
                        break;
                    case 3:
                        System.out.println("New ISBN : ");
                        inventory[bookIndex].setISBN(scanner.nextLong());
                        System.out.println(inventory[bookIndex]);
                        break;
                    case 4:
                        System.out.println("New Price : ");
                        inventory[bookIndex].setPrice(scanner.nextDouble());
                        System.out.println(inventory[bookIndex]);
                        break;
                    case 5:
                        quit = true;
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
            }
        }else{
            System.out.println("Sorry no more Space available.");
        }

        accessGranted = false;
    }

    private static void searchByAuthor(Book[] inventory) {
        System.out.println("Enter the Author");
        String author = scanner.next();
        Book[] allBooksBySameAuthor = new Book[inventory.length];
        int i = 0;
        for(Book book : inventory) {
            if(  book!= null && book.getAuthor().equals(author)) {
                allBooksBySameAuthor[i++] = book;
            }
        }

        for(Book book : allBooksBySameAuthor) {
            System.out.println(book);
        }
    }

    private static void searchUnderPrice(Book[] inventory) {
        System.out.println("Enter the Price");
        double price = scanner.nextDouble();
        Book[] allBookUnderPrice = new Book[inventory.length];
        int i = 0;
        for(Book book : inventory) {
            if(  book!= null && book.getPrice() == price) {
                allBookUnderPrice[i++] = book;
            }
        }

        for(Book book : allBookUnderPrice) {
            System.out.println(book);
        }
    }
}

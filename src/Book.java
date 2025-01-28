public class Book {

    private String title;
    private String author;
    private long ISBN;
    private double price;
    private static int bookCount = 0 ;

    public Book(String title, String author, long ISBN, double price) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.price = price;
        bookCount++;
    }

    public Book() {
        this.title = "";
        this.author = "";
        this.ISBN = 0;
        this.price = 0.0;
        bookCount++;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setISBN(long ISBN) {
        this.ISBN = ISBN;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public long getISBN() {
        return ISBN;
    }

    public double getPrice() {
        return price;
    }

    public int findNumberOfCreatedBooks(){
        if(bookCount == 0){
            return 0;
        }else return bookCount;
    }

    public boolean equals(Book book) {
        if(book == null) {
            return false;
        } else return this.ISBN == book.getISBN() && this.price == book.getPrice();
    }

    @Override
    public String toString() {
        return "Title : " + this.title + "\n" + "Author : " + this.author + "\n" +"ISBN : " + this.ISBN +"#"+ "\n"+"Price : $" + this.price;
    }


}

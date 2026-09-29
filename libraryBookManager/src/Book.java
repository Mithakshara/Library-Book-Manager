public class Book {
    private int bookId;
    private String title;
    private double price;
    private boolean isAvailable;

    public Book(int bookId, String title, double price, boolean isAvailable) {
        this.bookId = bookId;
        this.title = title;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void displayBook(){
        System.out.println(" ");
        System.out.println("===== Display Book Details =====");
        System.out.println("The Name of the book is : "+title);
        System.out.println("Book ID is : " + bookId);
        System.out.println("Price of book is : "+ price );
        System.out.println("Is it available : " + isAvailable);
        System.out.println("===================================");
        System.out.println(" ");
    }
}

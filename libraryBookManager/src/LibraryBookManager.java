import java.util.ArrayList;
import java.util.Scanner;

public class LibraryBookManager {

    static Book findBook(ArrayList<Book> B , int id){
        for (Book book : B) {
            if (book.getBookId() == id) {
                return book;
            }
        }
        return null;
    }

    static Book addBook(ArrayList<Book> B,Scanner input){

        System.out.println("Enter Book Id : ");
        int Id = input.nextInt();

        if (findBook(B,Id) != null ){
            System.out.println("A book with this ID already exists.");
            return null;
        }
        input.nextLine();



        System.out.println("Enter the title of Book: ");
        String name = input.nextLine();

        double price;

        while (true){
            System.out.println("Enter the Price of Book : ");
             price = input.nextDouble();

             if (price > 0){
                 break;
             }
            System.out.println("Price must be greater than 0.");
        }
        return new Book(Id,name,price,true);
    }
    static Book borrowBook(ArrayList<Book> B, int id){

        for (Book book : B) {
            if (book.getBookId() == id) {
                return book;

            }
        }
        return null;
    }


    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        Book book1 = new Book(101, "Clean Code", 23.34, true);
        Book book2 = new Book(102, "Effective Java", 39.50, true);
        Book book3 = new Book(103, "Head First Java", 34.75, false);
        Book book4 = new Book(104, "The Pragmatic Programmer", 42.00, true);
        Book book5 = new Book(105, "Java: The Complete Reference", 55.25, true);
        Book book6 = new Book(106, "Introduction to Algorithms", 79.99, false);
        Book book7 = new Book(107, "Design Patterns", 45.00, true);
        Book book8 = new Book(108, "Refactoring", 49.95, true);
        Book book9 = new Book(109, "Cracking the Coding Interview", 32.50, false);

        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
        books.add(book6);
        books.add(book7);
        books.add(book8);
        books.add(book9);


        while (true){
            System.out.println("""
                    ===== Library Menu =====
                    1. Add Book
                    2. Display All Books
                    3. Search Book
                    4. Borrow Book
                    5. Return Book
                    6. Exit
                    
                    """);
            System.out.print("Enter your choice: ");
            int menuInput = input.nextInt();

            if (menuInput == 1){

                Book addbook = addBook(books,input);
                if (addbook != null){
                    books.add(addbook);
                    System.out.println("Book added successfully.");
                }

            } else if (menuInput == 2) {

                System.out.println("==== Display All Books =====");
                for (int i = 0; i < books.size(); i++) {
                    System.out.println((i+1)+" "+books.get(i).getBookId()+" "+books.get(i).getTitle());
                }


            }else if (menuInput == 3) {
                System.out.print("Enter  the book ID " );
                int id = input.nextInt();

                Book findbook = findBook(books,id);
                if (findbook != null){
                     findbook.displayBook();
                }else {
                    System.out.println("No book or book Id  ");
                }

            }else if (menuInput == 4) {
                System.out.print("Enter the Book ID : ");
                int id = input.nextInt();
                Book Values = borrowBook(books,id);

                if (Values != null && !Values.isAvailable()){
                    System.out.println("Sorry, this book is already borrowed.");
                }
                else if (Values != null && Values.isAvailable()){
                    Values.setAvailable(false) ;
                    System.out.println("Book borrowed successfully.");
                }else {
                    System.out.println("Book not found ...");
                }
            }else if (menuInput == 5) {
                System.out.print("Enter the Book ID : ");
                int id = input.nextInt();
                Book Values = borrowBook(books,id);

                if (Values != null && Values.isAvailable()){
                    System.out.println("Sorry, already available.");
                }
                else if (Values != null && !Values.isAvailable()){
                    Values.setAvailable(true) ;
                    System.out.println("Book return successfully.");
                }else {
                    System.out.println("No Book like this ...");
                }
            }else if (menuInput == 6) {
                break;
            }else {
                System.out.println("Invalid input");
                System.out.println("Try a again");
            }
        }

        System.out.println("You exit from the programme");
        input.close();

    }
}

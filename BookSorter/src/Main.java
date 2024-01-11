import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Set<Book> booksByName = new TreeSet<>();
        booksByName.add(new Book("Nutuk", 600, "Mustafa Kemal Atatürk", "1927"));
        booksByName.add(new Book("Great Gatsby", 180, "F. Scott Fitzgerald", "April 10, 1925"));
        booksByName.add(new Book("Trial", 160, "Franz Kafka", "1925"));
        booksByName.add(new Book("Ince Memed", 400, "Yaşar Kemal", "1955"));
        booksByName.add(new Book("It", 1138, "Stephen King", "September 15, 1986"));

        System.out.println("Books sorted by name : ");
        for (Book book : booksByName){
            System.out.println(book);
        }
        Set <Book> booksByPageCount = new TreeSet<>(Comparator.comparing(Book::getPageCount));
        booksByPageCount.addAll(booksByName);
        System.out.println("Books sorted by page count : ");
        for (Book book : booksByPageCount){
            System.out.println(book);
        }
    }
}
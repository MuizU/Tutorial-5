import java.math.BigDecimal;
import java.util.*;

public class Book implements Comparable<Book> {
    private String title;
    private BigDecimal price;
    private int yearPublished;
    private String authorName;

    public Book(String title, int yearPublished, String authorName) {
        this.title = title;
        this.yearPublished = yearPublished;
        this.authorName = authorName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public String toString() {
        return "Book[" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", yearPublished=" + yearPublished +
                ", authorName='" + authorName + '\'' +
                ']';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Book> list = new ArrayList<>();
        char exit;
        do {
            System.out.print("To exit press x after this ,or press any other key to continue");
            exit = scanner.next().charAt(0);
            System.out.print("Enter book title: ");
            scanner.next();
            String title = scanner.nextLine();
            System.out.print("Enter year published: ");
            int yearPublished;
            yearPublished = scanner.nextInt();
            System.out.print("Enter authors name: ");
            scanner.next();
            String author = scanner.nextLine();
            list.add(new Book(title, yearPublished, author));
        } while (exit != 'x');
        Collections.sort(list);
        for (Book book : list) {
            System.out.println(book);
        }
        Map<Integer, Book> hashMap = new HashMap<Integer, Book>();
        for (int i = 0; i < list.size(); i++) {

            System.out.print("Please, enter the number of the shelf where is placed the book" + list.get(i).getTitle());
            int numShelf = scanner.nextInt();
            /*Adding elements to HashMap*/
            hashMap.put(numShelf, list.get(i));
        }
    }

    @Override
    public int compareTo(Book o) {
        return this.yearPublished - o.yearPublished;
    }
}

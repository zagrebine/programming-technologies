package Iterator;

public class IMain {
    public static void main(String[] args) {
        var library = new Library<Book>();

        library.add(new Book("Евгений Онегин"));
        library.add(new Book("Герой нашего времени"));
        library.add(new Book("Чистый код"));

        Iterator<Book> iterator = library.createIterator();

        while (iterator.hasNext()) {
            Book book = iterator.next();
            System.out.println(book);
        }
    }
}

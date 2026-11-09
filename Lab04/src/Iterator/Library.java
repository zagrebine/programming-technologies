package Iterator;

import java.util.ArrayList;
import java.util.List;

public class Library<T>{
    private List<T> items = new ArrayList<>();

    public void add(T item) {
        items.add(item);
    }

    public Iterator<T> createIterator() {
        return new LibraryIterator<>(items);
    }
}

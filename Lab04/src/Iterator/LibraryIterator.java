package Iterator;

import java.util.List;

public class LibraryIterator<T> implements Iterator<T>{
    private List<T> items;
    private int position = 0;

    public LibraryIterator(List<T> items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        return position < items.size();
    }

    @Override
    public T next() {
        return items.get(position++);
    }
}

package Array_Iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator<T> implements Iterator<T> {

    private int index = 0;
    private T[] array = null;

    public ArrayIterator(T[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return index < array.length;
    }

    @Override
    public T next() {
        if (hasNext()) {
            return array[index++];
        }
        throw new NoSuchElementException();
    }

    @Override
    public void remove() {
        if (!hasNext()) {
            throw new UnsupportedOperationException();
        }
        int i = index - 1;
        array[i] = null;
    }
}


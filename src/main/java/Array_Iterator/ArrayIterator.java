package Array_Iterator;

import java.util.Iterator;

public class ArrayIterator<T> implements Iterator<T> {

    private int index = 0;
    private T[] array = null;

    public ArrayIterator(T[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return array.length > index;
    }

    @Override
    public T next() {
        return array[index++];
    }

    @Override
    public void remove() {
        int i = index - 1;
        array[index] = null;
    }
}


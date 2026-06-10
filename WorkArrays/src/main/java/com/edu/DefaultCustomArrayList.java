package com.edu;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ConcurrentModificationException;


public class DefaultCustomArrayList<E> implements CustomArrayList<E> {
    private static final int DEFAULT_CAPACITY = 10;

    private Object[] elements;
    private int size;
    private int modCount;

    public DefaultCustomArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.size = 0;
        this.modCount = 0;
    }

    @Override
    public boolean add(E element) {
        ensureCapacity(size + 1);
        elements[size++] = element;
        modCount++;
        return true;
    }

    @Override
    public boolean remove(E element) {
        int index = indexOf(element);
        if (index == -1) return false;
        fastRemove(index);
        modCount++;
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E get(int index) {
        rangeCheck(index);
        return (E) elements[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        // help GC
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
        modCount++;
    }

    @Override
    public boolean contains(E element) {
        return indexOf(element) != -1;
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }


    private void ensureCapacity(int minCapacity) {
        if (minCapacity <= elements.length) return;
        int newCapacity = elements.length * 2;
        if (newCapacity < minCapacity) newCapacity = minCapacity;
        Object[] newArr = new Object[newCapacity];
        System.arraycopy(elements, 0, newArr, 0, size);
        elements = newArr;
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private int indexOf(E element) {
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) return i;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(elements[i])) return i;
            }
        }
        return -1;
    }

    private void fastRemove(int index) {
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null;
    }

    /**
     * Итератор с поддержкой remove() и fail-fast поведением.
     */
    private class Itr implements Iterator<E> {
        private int cursor = 0;
        private int lastRet = -1;
        private int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @SuppressWarnings("unchecked")
        @Override
        public E next() {
            checkForComodification();
            int i = cursor;
            if (i >= size) throw new NoSuchElementException();
            Object[] elementData = DefaultCustomArrayList.this.elements;
            cursor = i + 1;
            lastRet = i;
            return (E) elementData[i];
        }

        @Override
        public void remove() {
            if (lastRet < 0) throw new IllegalStateException();
            checkForComodification();

            try {
                DefaultCustomArrayList.this.fastRemove(lastRet);
                cursor = lastRet;
                lastRet = -1;
                expectedModCount = ++modCount;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }

        final void checkForComodification() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
        }
    }
}

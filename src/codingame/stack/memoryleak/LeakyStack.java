package codingame.stack.memoryleak;

import java.util.EmptyStackException;

class LeakyStack {
    private Object[] elements;
    private int size = 0;

    public LeakyStack(int initialCapacity) { elements = new Object[initialCapacity]; }

    public void push(Object o) {
        ensureCapacity();
        elements[size++] = o;
    }

    public Object pop() {
        if (size == 0) throw new EmptyStackException();
        return elements[--size];          // <- leaves elements[size] holding reference
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            Object[] old = elements;
            elements = new Object[2 * size + 1];
            System.arraycopy(old, 0, elements, 0, size);
        }
    }
}

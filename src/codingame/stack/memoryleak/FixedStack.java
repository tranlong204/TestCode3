package codingame.stack.memoryleak;

import java.util.EmptyStackException;

class FixedStack {
    private Object[] elements;
    private int size = 0;

    public FixedStack(int initialCapacity) { elements = new Object[initialCapacity]; }

    public void push(Object o) {
        ensureCapacity();
        elements[size++] = o;
    }

    public Object pop() {
        if (size == 0) throw new EmptyStackException();
        Object result = elements[--size];
        elements[size] = null;            // <- clear obsolete reference
        return result;
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            Object[] old = elements;
            elements = new Object[2 * size + 1];
            System.arraycopy(old, 0, elements, 0, size);
        }
    }
}

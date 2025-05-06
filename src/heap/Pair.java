package heap;

public class Pair<K, T> {
    K left;
    T right;

    public Pair(K left, T right) {
        this.left = left;
        this.right = right;
    }

    public K getLeft() {
        return left;
    }

    public void setLeft(K left) {
        this.left = left;
    }

    public T getRight() {
        return right;
    }

    public void setRight(T right) {
        this.right = right;
    }
}

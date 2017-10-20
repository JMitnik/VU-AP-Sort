import java.util.ArrayList;
import java.util.Iterator;

public class BinarySearchTree<E extends Comparable<E>> implements BinarySearchTreeInterface<E> {
    private BSTNodeInterface<E> root;

    public BinarySearchTree() {
        init();
    }

    private boolean isEmpty() {
        return this.root == null;
    }

    public boolean contains(E el) {
        return !isEmpty() && this.root.contains(el);
    }

    public void add(E el) {
        if (isEmpty()) {
            this.root = new BSTNode<>(el);
        } else {
            this.root = this.root.add(el);
        }
    }

    @Override
    public E remove(E el) {
        this.root.remove(el);
        return null;
    }

    @Override
    public BinarySearchTreeInterface<E> init() {
        this.root = null;
        return this;
    }

    @Override
    public Iterator<E> ascendingIterator() {
        ArrayList<E> result = new ArrayList<>();

        if (!isEmpty()) {
            this.root.visitInOrder(result);
        }

        return result.iterator();
    }

    @Override
    public Iterator<E> descendingIterator() {
        ArrayList<E> result = new ArrayList<>();

        if (!isEmpty()) {
            this.root.visitInOrderReversed(result);
        }

        return result.iterator();
    }
}

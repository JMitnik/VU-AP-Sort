import java.util.ArrayList;

interface BSTNodeInterface<E extends Comparable<E>> {

    BSTNodeInterface<E> add(E e);

    BSTNodeInterface<E> remove(E e);

    int numberOfNodes();

    boolean contains(E e);

    int depth(E e);

    BSTNodeInterface<E> copy();

    void visitInOrder(ArrayList<E> nodes); //hmm

    void visitInOrderReversed(ArrayList<E> nodes);
}

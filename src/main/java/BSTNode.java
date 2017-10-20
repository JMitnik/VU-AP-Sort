import java.util.ArrayList;
import java.util.Iterator;

public class BSTNode<E extends Comparable<E>> implements BSTNodeInterface<E> {
    private E data;
    private BSTNode<E> left, right;

    BSTNode(E data) {
        this(data, null, null);
    }

    BSTNode(E data, BSTNode<E> left, BSTNode<E> right) {
        this.data = data;
        this.right = right;
        this.left = left;
    }

    @Override
    public BSTNodeInterface<E> add(E e) {
        if (this.data.equals(e)) {
            return this;
        } else if (e.compareTo(data) < 0){
            this.left = this.addToChild(this.left, e);
        } else {
            this.right = this.addToChild(this.right, e);
        }

        return this;
    }

    private BSTNode<E> addToChild(BSTNode<E> childNode, E e) {
        if (childNode == null) {
            return new BSTNode<>(e);
        } else {
            return (BSTNode<E>) childNode.add(e);
        }
    }

    @Override
    public void visitInOrderReversed(ArrayList<E> nodes) {
        if (this.right != null) {
            this.right.visitInOrderReversed(nodes);
        }

        nodes.add(this.data);

        if (this.left != null) {
            this.left.visitInOrderReversed(nodes);
        }

    }

    @Override
    public void visitInOrder(ArrayList<E> nodes) {
        if (this.left != null) {
            this.left.visitInOrder(nodes);
        }

        nodes.add(this.data);

        if (this.right != null) {
            this.right.visitInOrder(nodes);
        }
    }

    @Override
    public BSTNodeInterface<E> remove(E e) {
        if (this.data.equals(e)) {
           return removeCurrentNode();
        } else if (e.compareTo(this.data) < 0) {
            this.left = removeInChild(this.left, e);
        } else {
            this.right = removeInChild(this.right, e);
        }

        return this;
    }

    private BSTNodeInterface<E> removeCurrentNode() {
        if (hasNoChildren()) {
            return null;
        } else if (hasOneChild()) {
            return this.left == null ? this.right : this.left;
        } else {
            E smallest = this.right.smallest();
            this.data = smallest;
            this.right = (BSTNode<E>) this.right.remove(smallest);
            return this;
        }
    }

    private E smallest() {
        while (this.left != null) {
            return this.left.smallest();
        }

        return this.data;
    }

    private boolean hasNoChildren() {
        return this.left == null && this.right == null;
    }

    private boolean hasOneChild() {
        return (this.left == null && this.right != null) ||
                (this.left != null && this.right == null);
    }

    private BSTNode<E> removeInChild(BSTNode<E> childNode, E e) {
        if (childNode == null) {
            throw new RuntimeException("Can't find element!");
        } else {
            return (BSTNode<E>) childNode.remove(e);
        }
    }

    @Override
    public boolean contains(E el) {
        if (this.data.equals(el)) {
            return true;
        } else if (el.compareTo(data) < 0) {
            return checkChild(this.left, el);
        } else {
            return checkChild(this.right, el);
        }
    }

    private boolean checkChild(BSTNodeInterface<E> childNode, E el) {
        return childNode != null && childNode.contains(el);
    }
}

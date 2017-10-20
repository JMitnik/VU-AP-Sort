import java.util.Iterator;

/**
 * @elements - objects of type E
 * @structure - linear
 * @domain - The elements in the tree are non-sorted, but satisfy the
 *           the BST-property.
 * @constructors:
 *   - BinarySearchTree()
 *   <dl>
 *		    <dt><b>PRE-conditie</b><dd>		-
 *		    <dt><b>POST-conditie</b><dd> 	- An empty BinarySearchTree has been created.
 *   </dl>
 */

interface BinarySearchTreeInterface<E extends Comparable<E>> {

    /**
     * Adds an element to the Binary Search Tree
     * @pre -
     * @post - The element 'el' has been added to the Binary Search Tree
     * at the proper index according to the BST property.
     * @param el
     */
    void add(E el);

    /**
     * Removes an element from the Binary Search Tree
     * @pre - The tree should not be empty
     * @post - The element 'el' has been removed from the Binary Search Tree,
     * and the Binary Search Tree still maintains its property.
     */
    void remove(E el);

    /**
     * @pre -
     * @post - Initiates an empty Binary Search Tree
     */
    BinarySearchTreeInterface<E> init();

    /**
     * Checks the tree whether an element 'el' exists.
     * @pre -
     * @post - Returns True - If the tree contains element 'el'
     *         Returns False - If the tree does not contain element 'el'
     */
    boolean contains(E el);

    /**
     * Returns an Iterator of the entire binary search tree in ascending order.
     * @pre -
     * @post - An Iterator of the entire tree has been returned in ascending order.
     */
    Iterator<E> ascendingIterator();

    /**
     * Returns an Iterator of the entire binary search tree in descending order.
     * @pre -
     * @post - An Iterator of the entire tree has been returned in descending order.
     */
    Iterator<E> descendingIterator();

}

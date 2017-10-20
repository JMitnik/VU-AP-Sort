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
 *		    <dt><b>POST-conditie</b><dd> 	- An empty BinarySearchTree has been created
 *		                                      with a default traversal of non-increasing
 *		                                      and case-sensitive.
 *   </dl>
 */

interface BinarySearchTreeInterface<E extends Comparable<E>> {

    void add(E el);

    /**
     * @pre - The tree should not be empty
     * @post - An element has been removed from the tree and its value
     * has been returned.
     */
    E remove(E el);

    /**
     * @pre -
     * @post - Initiates an empty Binary Search Tree
     */
    BinarySearchTreeInterface<E> init();

    boolean contains(E el);

    Iterator<E> ascendingIterator();

    Iterator<E> descendingIterator();

}

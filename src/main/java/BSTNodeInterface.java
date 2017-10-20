import java.util.ArrayList;

/**
 * @elements - objects of type E
 * @structure - linear
 * @domain - The elements in the next and previous node are non-sorted, but satisfy the
 *           the BST-property.
 * @constructors:
 *   - BSTNode()
 *   <dl>
 *		    <dt><b>PRE-conditie</b><dd>		-
 *		    <dt><b>POST-conditie</b><dd> 	- An empty Binary Search Tree Node has been created.
 *   </dl>
 *   - BSTNode(E data, BSTNode left, BSTNode right)
 *   <dl>
 *		    <dt><b>PRE-conditie</b><dd>		- left and right are not empty
 *		    <dt><b>POST-conditie</b><dd> 	- A BST Node containing E has been created
 *		                                      with references to 'left' and 'right'.
 *   </dl>
 */

interface BSTNodeInterface<E extends Comparable<E>> {

    /**
     * Recursive method to add nodes to the proper node
     * to maintain the BST-property.
     * @pre - The current node is not null
     * @post - A new node with value 'e' has been created in the proper
     * position, where the current node is the root.
     */
    BSTNodeInterface<E> add(E e);

    /**
     * Recursive method to remove nodes whilst maintaining
     * the BST-property.
     * @pre - A node with value 'e' exists as one of the descendants,
     * and the current node is not null.
     * @post - A node with value 'e' has been removed whilst
     * the tree stemming from this node maintains its BST-property.
     */
    BSTNodeInterface<E> remove(E e);

    /**
     * @pre - A node with value 'e' exists as one of the descendants,
     * and the current node is not null.
     * @post - A node with value 'e' has been removed whilst
     * the tree stemming from this node maintains its BST-property.
     */
    boolean contains(E e);

    /**
     * Visits the tree stemming from this node as root 'in-order',
     * whilst saving the visited nodes in the 'nodes' variable.
     * @param nodes - The variable to store the visited nodes in.
     * @pre - The current node is not null.
     * @post - The tree stemming from this node has been visited
     * in-order, and put in 'nodes'.
     */
    void visitInOrder(ArrayList<E> nodes);

    /**
     * Visits the tree stemming from this node as root 'in-order',
     * and reversed (right first, then left),whilst saving the
     * visited nodes in the 'nodes' variable.
     * @param nodes - The variable to store the visited nodes in.
     * @pre - The current node is not null.
     * @post - The tree stemming from this node has been visited
     * in-order reversed, and put in 'nodes'.
     */
    void visitInOrderReversed(ArrayList<E> nodes);
}

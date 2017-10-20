public class Main {

    private void start() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.add(8);
        bst.add(3);
        bst.add(1);
        bst.add(9);
        bst.descendingIterator();
    }

    public static void main(String[] argv) {
        new Main().start();
    }
}

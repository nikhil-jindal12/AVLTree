/**
 * Class that contains some tests for the AVLTree class
 */
public class AVLTreeTest {
    private static int arr[] = { 3, 2, 1, 4, 5, 6, 7, 16, 15, 14, 13, 12, 11, 10, 8, 9 };

    /**
     * Main method that tests AVLTree class
     * @param args  no args should be passed
     */
    public static void main(String[] args) {
        int i;
        int j;

        // instantiate the AVLTree
        AVLTree<Integer> tree = new AVLTree<Integer>();

        // insert the nodes in the order they are given
        System.out.printf("== Add in sequence: ");
        for (i = 0; i < arr.length; i++) {
            System.out.printf("%d ", arr[i]);
            tree.insert(arr[i]);
        }

        // print the preorder traversals
        System.out.printf("\n== PreOrder Traversal: ");
        tree.preOrder();

        // print the inorder traversals
        System.out.printf("\n== InOrder Traversal: ");
        tree.inOrder();

        // print the postordertraversals
        System.out.printf("\n== PostOrder Traversal: ");
        tree.postOrder();
        System.out.printf("\n");

        // print the height of the tree
        System.out.printf("== height: %d\n", tree.height());

        // print the minimum and maximum
        System.out.printf("== Min: %d\n", tree.minimum());
        System.out.printf("== Max: %d\n", tree.maximum());

        // print the details of the tree
        System.out.printf("== Details of the tree: \n");
        tree.print();

        // remove a node
        i = 8;
        System.out.printf("\n== Delete the root node: %d", i);
        tree.remove(i);

        // print the new height of the tree after the deletion
        System.out.printf("\n== height: %d", tree.height());

        // print the inorder traversal
        System.out.printf("\n== InOrder Traversal: ");
        tree.inOrder();

        // print the updated details of the tree
        System.out.printf("\n== Details of the tree: \n");
        tree.print();

        // insert a node
        j = 18;
        System.out.printf("\n== Insert the element: %d", j);
        tree.insert(j);

        // print the updated preorder traversal
        System.out.printf("\n== PreOrder Traversal: ");
        tree.preOrder();

        // Destroy tree
        tree.destroy();
    }
}

/*******************************************************
 * Assignment 3
 * Name: Jindal_Nikhil
 * UID: nxj224
 * Implementation of an AVLTree that allows for searches, 
 *   traversal, inserts, deletions, and other various functions
 * @author Nikhil Jindal
 ********************************************************/

public class AVLTree<T extends Comparable<T>> {
    private AVLTreeNode<T> mRoot; // root node
    
    // nodes of AVL Tree (internal)
    class AVLTreeNode<T extends Comparable<T>> {
        T key; // key
        int height; // height
        AVLTreeNode<T> left; // left children
        AVLTreeNode<T> right; // right children

         /**
          * Node class for AVL Tree
          * @param key  Node's key for searching and insertion
          * @param left  left child of the Node
          * @param right  right child of the Node
          */
        public AVLTreeNode(T key, AVLTreeNode<T> left, AVLTreeNode<T> right) {
            this.key = key;
            this.left = left;
            this.right = right;
            this.height = 0;
        }
    }

    /**
     * AVLTree Constructor
     */
    public AVLTree() {
        mRoot = null;
    }

    /**
     * Returns the height of the tree using "tree" as the root
     * @param tree  using the parameter as the root of the tree
     * @return  the height of the tree
     */
    private int height(AVLTreeNode<T> tree) {
        if (tree != null)
            return tree.height;

        return 0;
    }

    /**
     * Returns the height of the tree
     * @return  the height of the tree
     */ 
    public int height() {
        return height(mRoot);
    }

    /**
     * Find the max value among the given numbers.
     * @param a First number
     * @param b Second number
     * @return Maximum value
     */
    private int max(int a, int b) {
        return a > b ? a : b;
    }

    /**
     * Question: a-1
     * Preorder traversal "AVL tree", print the result
     * @param tree  using the parameter as the root of the tree
     */
    private void preOrder(AVLTreeNode<T> tree) {
        if (tree != null) {
            // print the node of the tree
            System.out.print(tree.key + " ");

            // traverses the left subtree of a node
            preOrder(tree.left);

            // traverses the right subtree of a node
            preOrder(tree.right);
        } else {
            return;
        }
    }

    /**
     * Public call for the preOrder method
     */
    public void preOrder() {
        preOrder(mRoot);
    }

    /**
     * Question: a-2
     * In-order traversal "AVL tree", print the result
     * @param tree  using the parameter as the root of the tree
     */
    private void inOrder(AVLTreeNode<T> tree) {
        if (tree != null) {
            // traverses the left subtree of a node
            inOrder(tree.left);
            
            // print the node of the tree
            System.out.print(tree.key + " ");

            // traverses the right subtree of a node
            inOrder(tree.right);
        } else {
            return;
        }
    }

    /**
     * Public call for the inOrder traversal
     */
    public void inOrder() {
        inOrder(mRoot);
    }

    /**
     * Question: a-3
     * Post-order traversal "AVL tree", print the result
     * @param tree  using the parameter as the root of the tree
     */
    private void postOrder(AVLTreeNode<T> tree) {
        if (tree != null) {
            // traverses the left subtree of a node
            postOrder(tree.left);
            
            // traverses the right subtree of a node
            postOrder(tree.right);
            
            // print the node of the tree
            System.out.print(tree.key + " ");
        } else {
            return;
        }
    }

    /**
     * Public call for the postOrder traversal
     */
    public void postOrder() {
        postOrder(mRoot);
    }

    /**
     * (Recursion) Search the node whose key-value is key in "AVL tree x"
     * @param x  using the parameter as the root of the tree
     * @param key  key value of the node
     * @return  the node of the tree with the desired key value
     */
    private AVLTreeNode<T> search(AVLTreeNode<T> x, T key) {
        if (x == null)
            return x;

        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            return search(x.left, key);
        else if (cmp > 0)
            return search(x.right, key);
        else
            return x;
    }

    /**
     * Public call for the recursive search call
     * @param key  the key to search for
     * @return  the node with the desired key
     */
    public AVLTreeNode<T> search(T key) {
        return search(mRoot, key);
    }

    /**
     * (Non-Recursion) Search the node whose key-value is key in "AVL tree x"
     * @param x  using the parameter as the root of the tree
     * @param key  key value of the node
     * @return  the node of the tree with the desired key value
     */
    private AVLTreeNode<T> iterativeSearch(AVLTreeNode<T> x, T key) {
        while (x != null) {
            int cmp = key.compareTo(x.key);

            if (cmp < 0)
                x = x.left;
            else if (cmp > 0)
                x = x.right;
            else
                return x;
        }

        return x;
    }

    /**
     * Public call for the iterative search call
     * @param key  the key to search for
     * @return  the node with the desired key
     */ 
    public AVLTreeNode<T> iterativeSearch(T key) {
        return iterativeSearch(mRoot, key);
    }

    /**
     * Question: a-4
     * Find min node：return the smallest node of the AVL tree when "tree" is the root
     * @param tree  using the parameter as the root of the tree
     * @return  the smallest node of the AVL tree
     */
    private AVLTreeNode<T> minimum(AVLTreeNode<T> tree) {

        if (tree != null) {
            while (tree.left != null)
                tree = tree.left;
        }

        return tree;
    }

    /**
     * Public call for the minimum method
     * @return  the smallest node of the AVL tree
     */ 
    public T minimum() {
        AVLTreeNode<T> p = minimum(mRoot);
        if (p != null)
            return p.key;

        return null;
    }

    /**
     * Question: a-5
     * Finds max node: return the largest node of the AVL tree with "tree" as the root
     * @param tree  use the "tree" as the root to find the largest node
     * @return  the largest node in the AVLTree
     */
    private AVLTreeNode<T> maximum(AVLTreeNode<T> tree) {
        
        if (tree != null) {
            while (tree.right != null)
                tree = tree.right;
        }

        return tree;
    }

    /**
     * Public call for the maximum method
     * @return  the largest node in the AVLTree
     */
    public T maximum() {
        AVLTreeNode<T> p = maximum(mRoot);
        if (p != null)
            return p.key;

        return null;
    }

    /**
     * LL：(a left rotation)
     * @param k2  the root node which requires rotation
     * @return  the root node after rotation
     */
    private AVLTreeNode<T> leftLeftRotation(AVLTreeNode<T> k2) {
        AVLTreeNode<T> k1 = k2.right;

        k2.right = k1.left;
        k1.left = k2;

        // k1 = k2.left;
        // k2.left = k1.right;
        // k1.right = k2;

        k2.height = max(height(k2.left), height(k2.right)) + 1;
        k1.height = max(height(k1.left), height(k1.right)) + 1;

        return k1;
    }

    /**
     * RR: (right rotation)
     * @param k1  the root node which requires rotation
     * @return  the root node after rotation
     */
    private AVLTreeNode<T> rightRightRotation(AVLTreeNode<T> k1) {
        AVLTreeNode<T> k2 = k1.left;

        k1.left = k2.right;
        k2.right = k1;
        // k2 = k1.right;
        // k1.right = k2.left;
        // k2.left = k1;

        k1.height = max(height(k1.left), height(k1.right)) + 1;
        k2.height = max(height(k2.right), height(k2.left)) + 1;

        return k2;
    }

    /**
     * LR: (left double rotation)
     * @param k3  the root node which requires rotation
     * @return  the root node after rotation
     */
    private AVLTreeNode<T> leftRightRotation(AVLTreeNode<T> k3) {
        k3.left = leftLeftRotation(k3.left);

        return rightRightRotation(k3);
    }

    /**
     * RL: (right double rotation)
     * @param k1  the root node which requires rotation
     * @return  the root node after rotation
     */
    private AVLTreeNode<T> rightLeftRotation(AVLTreeNode<T> k1) {
        k1.right = rightRightRotation(k1.right);

        return leftLeftRotation(k1);
    }

    /**
     * Returns the balance factor of a node
     * @param node  the node to check
     * @return  the balance factor of the node
     */
    private int balance(AVLTreeNode<T> node) {
        if (node == null)
            return 0;

        return height(node.left) - height(node.right);
    }

    /**
     * Balances the tree
     * @param tree  the root of the tree which should be rotated and checked for balance
     * @param key  the key of the node that was just inserted/deleted
     */
    private void balanceTree(AVLTreeNode<T> tree, T key) {
        if (balance(tree) > 1) {
            if (key.compareTo(tree.left.key) < 0)
                tree = rightRightRotation(tree);
            else
                tree = leftRightRotation(tree);
        }
    
        if (balance(tree) < -1) {
            if (key.compareTo(tree.right.key) > 0)
                tree = leftLeftRotation(tree);
            else
                tree = rightLeftRotation(tree);
        }
    }

    /**
     * Question a-6
     * insert an element into the tree, return the root node
     * @param tree  the root node of the AVL tree
     * @param key  the key value of the node to be inserted
     * @return  tree root node
     */
    private AVLTreeNode<T> insert(AVLTreeNode<T> tree, T key) {
        if (tree == null) {
            tree = new AVLTreeNode<T>(key, null, null);
            if (tree == null) {
                System.out.println("ERROR: Create AVLTreeNode failed!");
                return null;
            }
        } else {
            int cmp = key.compareTo(tree.key);

            if (cmp < 0) { // Case: The key should be inserted into the "left subtree of the tree"
                tree.left = insert(tree.left, key);

            } else if (cmp > 0) { // Case: The key should be inserted into the "right subtree of the tree"
                tree.right = insert(tree.right, key);
            
            } else { // cmp==0
                System.out.println("Insert Fail: Cannot insert the same element!");
            }
        }
        
        balanceTree(tree, key);

        tree.height = max(height(tree.left), height(tree.right)) + 1;
        
        return tree;
    }

    /**
     * Public call for the insert method
     * @param key  key for the node to be inserted
     */
    public void insert(T key) {
        mRoot = insert(mRoot, key);
    }

    /**
     * Question: a-7
     * Delete the node (z), then return the root node
     * @param tree  the root node of AVL tree
     * @param z  the node to be deleted
     * @return tree  root node
     */
    private AVLTreeNode<T> remove(AVLTreeNode<T> tree, AVLTreeNode<T> z) {
        // if the root is empty or there are no nodes to delete, return "null"
        if (tree == null || z == null)
            return null;

        int cmp = z.key.compareTo(tree.key);
        if (cmp < 0) { // The node to be deleted is in the "left subtree of tree"

            tree.left = remove(tree.left, z);

        } else if (cmp > 0) { // The node to be deleted is in the "right subtree of tree"

            tree.right = remove(tree.right, z);

        } else {
            // If both the left and right children of "tree" are not empty
            if ((tree.left != null) && (tree.right != null)) {
                if (height(tree.left) > height(tree.right)) {
                    /*
                     * Write your code here
                     */

                } else {
                    /*
                     * Write your code here
                     */
                }
            } else {
                AVLTreeNode<T> tmp = tree;
                tree = (tree.left != null) ? tree.left : tree.right;
                tmp = null;
            }
        }

        balanceTree(tree, null);

        return tree;
    }

    public void remove(T key) {
        AVLTreeNode<T> z;

        if ((z = search(mRoot, key)) != null)
            mRoot = remove(mRoot, z);
    }

    /**
     * Destroy the tree
     * @param tree  root of the tree to be destroyed
     */
    private void destroy(AVLTreeNode<T> tree) {
        if (tree == null)
            return;

        if (tree.left != null)
            destroy(tree.left);
        if (tree.right != null)
            destroy(tree.right);

        tree = null;
    }

    /**
     * Public call for destroy
     */
    public void destroy() {
        destroy(mRoot);
    }

    /**
     * Print Tree
     * @param key: key-value
     * @param direction:0 : means the node this the root node.
     * @param direction:-1 : means the node is the left child of its parent;
     * @param direction:1 : means the node is the right child of its parent;
     */
    private void print(AVLTreeNode<T> tree, T key, int direction) {
        if (tree != null) {
            if (direction == 0)
                System.out.printf("%2d is root\n", tree.key, key);
            else
                System.out.printf("%2d is %2d's %6s child\n", tree.key, key, direction == 1 ? "right" : "left");

            print(tree.left, tree.key, -1);
            print(tree.right, tree.key, 1);
        }
    }

    /**
     * Public call for print
     */
    public void print() {
        if (mRoot != null)
            print(mRoot, mRoot.key, 0);
    }
}

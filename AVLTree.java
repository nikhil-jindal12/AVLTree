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
        // do nothing if the key is null
        if (x == null)
            return x;

        // use the comparable implementation of the key to find whether it is in the left or right subtree
        int cmp = key.compareTo(x.key);

        if (cmp < 0) {
            // left subtree
            return search(x.left, key);
        } else if (cmp > 0) {
            // right subtree
            return search(x.right, key);
        } else {
            // equals the node
            return x;
        }
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
        // do nothing if the key is null
        while (x != null) {
            // use the comparable implementation of the key to find whether it is in the left or right subtree
            int cmp = key.compareTo(x.key);

            if (cmp < 0) {
                // left subtree
                x = x.left;
            } else if (cmp > 0) {
                // right subtree
                x = x.right;
            } else {
                // equals the node
                return x;
            }
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

        // do nothing if the tree is null
        if (tree != null) {
            // find the smallest node in the left subtree
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
        // find the minimum of the entire AVL tree
        AVLTreeNode<T> p = minimum(mRoot);

        // do nothing if the root of the tree is null
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
        
        // do nothing if the tree is null
        if (tree != null) {
            // find the largest node in the right subtree
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
        // find the maximum of the entire AVL tree
        AVLTreeNode<T> p = maximum(mRoot);

        // do nothing if the root of the tree is null
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
        // perform the rotation
        AVLTreeNode<T> k1 = k2.right;
        k2.right = k1.left;
        k1.left = k2;

        // readjust the heights
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
        // perform the rotations
        AVLTreeNode<T> k2 = k1.left;
        k1.left = k2.right;
        k2.right = k1;

        // readjust the heights
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
        // first perform a LL rotation
        k3.left = leftLeftRotation(k3.left);

        // perform a RR rotation after the initial
        return rightRightRotation(k3);
    }

    /**
     * RL: (right double rotation)
     * @param k1  the root node which requires rotation
     * @return  the root node after rotation
     */
    private AVLTreeNode<T> rightLeftRotation(AVLTreeNode<T> k1) {
        // first perform a RR rotation
        k1.right = rightRightRotation(k1.right);

        // perform a LL rotation after the initial
        return leftLeftRotation(k1);
    }

    /**
     * Returns the balance factor of a node
     * @param node  the node to check
     * @return  the balance factor of the node
     */
    private int balance(AVLTreeNode<T> node) {
        // do nothing if the node is null
        if (node == null)
            return 0;

        // return the height of the entire tree from the node given
        return height(node.left) - height(node.right);
    }

    /**
     * Question a-6
     * insert an element into the tree, return the root node
     * @param tree  the root node of the AVL tree
     * @param key  the key value of the node to be inserted
     * @return  tree root node
     */
    private AVLTreeNode<T> insert(AVLTreeNode<T> tree, T key) {
        // run if there is no node at the point
        if (tree == null) {
            // create a new node at the current position
            tree = new AVLTreeNode<T>(key, null, null);
        } else {
            // use the comparable implementation of the key to find whether it is in the left or right subtree
            int cmp = key.compareTo(tree.key);

            if (cmp < 0) { 
                // the key should be inserted into the "left subtree of the tree"
                tree.left = insert(tree.left, key);

            } else if (cmp > 0) { 
                // the key should be inserted into the "right subtree of the tree"
                tree.right = insert(tree.right, key);
            
            } else { 
                // do nothing if the key is already in the tree
                System.out.println("Insert Fail: Cannot insert the same element!");

            }
        }
        
        // rebalance the tree if it is heavier on the left or right side
        if (balance(tree) > 1) {
            // perform the correct rotation depending on where the node is in the tree
            if (key.compareTo(tree.left.key) < 0)
                tree = rightRightRotation(tree);
            else
                tree = leftRightRotation(tree);
        } else if (balance(tree) < -1) {
            // perform the correct rotation depending on where the node is in the tree
            if (key.compareTo(tree.right.key) > 0)
                tree = leftLeftRotation(tree);
            else
                tree = rightLeftRotation(tree);
        }

        // readjust the height of the tree after insertion of a node
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

        // use the comparable implementation of the key to find whether it is in the left or right subtree
        int cmp = z.key.compareTo(tree.key);
        if (cmp < 0) { 
            // The node to be deleted is in the "left subtree of tree"
            tree.left = remove(tree.left, z);

        } else if (cmp > 0) { 
            // The node to be deleted is in the "right subtree of tree"
            tree.right = remove(tree.right, z);

        } else {
            // If both the left and right children of "tree" are not empty
            if ((tree.left != null) && (tree.right != null)) {

                if (height(tree.left) > height(tree.right)) {
                    // find the largest node in the left subtree to rebalance
                    AVLTreeNode<T> max = maximum(tree.left);
                    tree.key = max.key;
                    tree.left = remove(tree.left, max);
                } else {
                    // find the smallest node in the right subtree to rebalance
                    AVLTreeNode<T> min = minimum(tree.right);
                    tree.key = min.key;
                    tree.right = remove(tree.right, min);
                }

            } else {
                AVLTreeNode<T> tmp = tree;
                tree = (tree.left != null) ? tree.left : tree.right;
                tmp = null;
            }
        }

        // rebalance the tree if it is heavier on the left or right side
        if (balance(tree) > 1) {
            // perform the correct rotation depending on where the node is in the tree
            if (z.key.compareTo(tree.left.key) < 0)
                tree = rightRightRotation(tree);
            else
                tree = leftRightRotation(tree);
        } else if (balance(tree) < -1) {
            // perform the correct rotation depending on where the node is in the tree
            if (z.key.compareTo(tree.right.key) > 0)
                tree = leftLeftRotation(tree);
            else
                tree = rightLeftRotation(tree);
        }
        
        return tree;
    }

    /**
     * Public call for the remove method
     * @param key  the key of the element to be removed
     */
    public void remove(T key) {
        // create a temporary node to hold the node to be deleted
        AVLTreeNode<T> z;

        // search for the node to be deleted and delete if it exists
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

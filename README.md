# AVLTree

There are two classes in the repository, the `AVLTree.java` & `AVLTreeTest.java` classes. `AVLTree.java` contains the implementation for an AVL tree that uses a generic type for the key. The `AVLTreeTest.java` is a testing class which tests the various methods in the `AVLTree.java` file and prints out the results to the terminal.

---


The following methods are in the `AVLTree.java` class:
- `void preOrder(AVLTreeNode<T> tree)` - prints a preorder traversal of the tree to the terminal from the specified node
- `void inOrder(AVLTreeNode<T> tree)` - prints an in-order traversal of the tree to the terminal from the specified node
- `void postOrder(AVLTreeeNode<T> tree)` - prints a post-order traversal of the tree to the terminal from the specified node
- `AVLTreeNode<T> minimum(AVLTreeNode<T> tree)` - finds the smallest node of the AVL tree from the specified root
- `AVLTreeNode<T> maximum(AVLTreeNode<T> tree)` - finds the largest node of the AVL tree from the specified root
- `AVLTreeNode<T> insert(AVLTreeNode<T> tree, T key)` - inserts an element into the tree with given key and returns the root node
- `AVLTreeNode<T> remove(AVLTreeNode<T> tree, AVLTreeNode<T> z)` - deletes the node (z), and then returns the root node

----

The `AVLTreeTest.java` prints the following operations to the terminal in this order:
1. Input the sequence
2. Print out preOrder traversal
3. Print out inOrder traversal
4. Print out postOrder traversal
5. Print out the height of the tree
6. Print the smallest node of the tree
7. Print the largest node of the tree
8. Print the details of the tree
---
9. Delete one node
10. Print the height of the tree after the deletion
11. Print out inOrder traversal after the deletion
12. Print the details of the tree again
---
13. Add one node
14. Print out preOrder traversal after the addition
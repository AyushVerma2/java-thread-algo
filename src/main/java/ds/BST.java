package ds;

// Data structure to store a Binary Search Tree node
class TreeNode {
    int data;
    TreeNode left, right;

    // Function to create a new binary tree node having given key
    TreeNode(int key) {
        data = key;
        left = right = null;
    }
};

public class BST {
    // Function to perform inorder traversal of the tree
    public static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Recursive function to insert a key into BST
    public static TreeNode insert(TreeNode root, int key) {
        // if the root is null, create a new node and return it
        if (root == null) {
            return new TreeNode(key);
        }

        // if given key is less than the root node,
        // recur for left subtree
        if (key < root.data) {
            root.left = insert(root.left, key);
        }

        // else recur for right subtree
        else {
            // key >= root.data
            root.right = insert(root.right, key);
        }

        return root;
    }

    // main function
    public static void main(String[] args) {
        TreeNode root = null;
        int[] keys = {15, 10, 20, 8, 12, 16, 25};

        for (int key : keys) {
            root = insert(root, key);
        }

        inorder(root);
    }
}

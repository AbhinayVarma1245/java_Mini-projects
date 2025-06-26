class TreeNode {
    int value;
    TreeNode left, right;

    public TreeNode(int value) {
        this.value = value;
        left = null;
        right = null;
    }
}
public class BinaryTree1 {
    public void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);  // Visit left subtree
        System.out.print(root.value + " ");  // Visit root
        inorderTraversal(root.right);  // Visit right subtree
    }
    public void postorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        postorderTraversal(root.left);  // Visit left subtree
        postorderTraversal(root.right);  // Visit right subtree
        System.out.print(root.value + " ");  // Visit root
    }
    public static void main(String[] args) {
        // Create a simple binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        BinaryTree1 tree = new BinaryTree1();
        
        // Inorder Traversal
        System.out.print("Inorder Traversal: ");
        tree.inorderTraversal(root);  // Output: 4 2 5 1 3
        System.out.println();  // For newline
        
        // Postorder Traversal
        System.out.print("Postorder Traversal: ");
        tree.postorderTraversal(root);  // Output: 4 5 2 3 1
    }
}

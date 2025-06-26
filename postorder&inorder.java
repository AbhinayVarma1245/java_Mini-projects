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
        inorderTraversal(root.left);  
        System.out.print(root.value + " ");  
        inorderTraversal(root.right);
    }
}
public class BinaryTree1 {
    public void postorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        postorderTraversal(root.left); 
        postorderTraversal(root.right); 
        System.out.print(root.value + " ");
    }
}
public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5)
        BinaryTree1 tree = new BinaryTree1();
        System.out.print("Inorder Traversal: ");
        tree.inorderTraversal(root);
        System.out.println(); 
        System.out.print("Postorder Traversal: ");
        tree.postorderTraversal(root);
    }
}

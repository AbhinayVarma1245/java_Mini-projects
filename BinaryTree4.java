class TreeNode {
    int value;
    TreeNode left, right;

    public TreeNode(int value) {
        this.value = value;
        left = null;
        right = null;
    }
}

public class BinaryTree4{

    public int sumNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.value + sumNodes(root.left) + sumNodes(root.right);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        BinaryTree4 tree = new BinaryTree4();
        int sum = tree.sumNodes(root);
        System.out.println("Sum of all nodes: " + sum);
    }
}

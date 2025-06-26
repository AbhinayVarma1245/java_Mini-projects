class TreeNode {
    int value;
    TreeNode left, right;
    public TreeNode(int value) {
        this.value = value;
        left = null;
        right = null;
    }
}

public class BinaryTree2 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        BinaryTree2 tree = new BinaryTree2();
        int nodeCount = tree.countNodes(root);
        System.out.println("Total number of nodes in the tree: " + nodeCount);
    }
}

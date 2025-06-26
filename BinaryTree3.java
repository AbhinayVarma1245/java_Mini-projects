class TreeNode {
    int value;
    TreeNode left, right;
    public TreeNode(int value) {
        this.value = value;
        left = null;
        right = null;
    }
}
public class BinaryTree3 {
    public int countLeafNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return countLeafNodes(root.left) + countLeafNodes(root.right);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        BinaryTree3 tree = new BinaryTree3();
        int leafNodeCount = tree.countLeafNodes(root);
        System.out.println("Total number of leaf nodes in the tree: " + leafNodeCount);
    }
}

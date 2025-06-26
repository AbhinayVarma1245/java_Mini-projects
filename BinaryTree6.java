class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BinaryTree6 {
    Node root;

    boolean search(Node node, int value) {
        if (node == null)
            return false;
        if (node.data == value)
            return true;
        return search(node.left, value) || search(node.right, value);
    }

    public static void main(String[] args) {
        BinaryTree6 tree = new BinaryTree6();
        tree.root = new Node(10);
        tree.root.left = new Node(20);
        tree.root.right = new Node(30);
        tree.root.left.left = new Node(40);
        tree.root.left.right = new Node(50);

        int valueToSearch = 70;
        System.out.println(tree.search(tree.root, valueToSearch));
    }
}

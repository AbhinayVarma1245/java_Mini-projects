class Node {
    int data;
    Node left;
    Node right;

    Node(int value) {
        data = value;
        left = right = null;
    }
}

class BinaryTree {
    Node root;

    BinaryTree() {
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
    }

    public void printPreorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }

    public int findHeight(Node node) {
        if (node == null) {
            return -1;
        }
        int leftHeight = findHeight(node.left);
        int rightHeight = findHeight(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        System.out.println("Preorder Traversal:");
        tree.printPreorder(tree.root);
        System.out.println();
        int height = tree.findHeight(tree.root);
        System.out.println("Height of Tree: " + height);
    }
}

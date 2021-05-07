public class Node {
    char value;
    Node left;
    Node right;

    Node() {
        this.left = null;
        this.right = null;
    }

    Node(char value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
    Node(char value, Node node) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

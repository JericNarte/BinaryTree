public class Node {
    int value;
    Node left;
    Node right;
    Node next;

    Node() {
        this.left = null;
        this.right = null;
    }

    Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
    Node(int value, Node node) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

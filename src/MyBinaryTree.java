public class MyBinaryTree {
    public class Node {
        char data;
        Node left;
        Node right;

        Node(char data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    Node root;
    int nodeCount;
    int treeHeight;

    public MyBinaryTree() {
        root = null;
    }

    public void insert(char[] values) {
        for (char v : values) {
            root = insertNode(v, root);
        }
    }

    private Node insertNode(char value, Node root) {
        if (root == null) {
            return new Node(value);
        }
        MyQueue<Node> queue = new MyQueue<>();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            Node current = queue.peek();
            if (current.left != null) {
                queue.enqueue(current.left);
            } else {
                current.left = new Node(value);
                return root;
            }
            if (current.right != null) {
                queue.enqueue(current.right);
            } else {
                current.right = new Node(value);
                return root;
            }
            queue.dequeue();
        }
        return root;
    }

    public int CountNodes() {
        nodeCount = 0;
        countNodesRecursion(root);
        return nodeCount;
    }

    private void countNodesRecursion(Node current) {
        if (current == null) {
            return;
        } else {
            countNodesRecursion(current.left);
            countNodesRecursion(current.right);
        }
        nodeCount++;
    }

    public int treeHeight() {
        treeHeight = 0;
        treeHeightRecursion(root, 0);
        return treeHeight;
    }

    public void treeHeightRecursion(Node current, int height) {
        if (current == null) {
            if (height > treeHeight) {
                treeHeight = height;
            }
        } else {
            height++;
            treeHeightRecursion(current.left, height);
            treeHeightRecursion(current.right, height);
        }
    }

    public void postOrder() {
        System.out.print("Post-Order: ");
        printPostOrder(root);
        System.out.println("end");
    }

    public void preOrder() {
        System.out.print("Pre-Order: ");
        printPreOrder(root);
        System.out.println("end");
    }

    public void inOrder() {
        System.out.print("In-Order: ");
        printInOrder(root);
        System.out.println("end");
    }

    public void printPostOrder(Node current) {
        if (current == null) {
            return;
        }
        printPostOrder(current.left);
        printPostOrder(current.right);
        System.out.print(current.data + " -> ");
    }

    public void printPreOrder(Node current) {
        if (current == null) {
            return;
        }
        System.out.print(current.data + " -> ");
        printPreOrder(current.left);
        printPreOrder(current.right);
    }

    public void printInOrder(Node current) {
        if (current == null) {
            return;
        }
        printInOrder(current.left);
        System.out.print(current.data + " -> ");
        printInOrder(current.right);
    }

    public void PrintTree() {
        treeHeight = treeHeight();
        MyLinkedList list = new MyLinkedList();
        list = levelTraversal(list);
        printTree(list);
    }

    public MyLinkedList levelTraversal(MyLinkedList list) {
        MyQueue<Node> queue = new MyQueue<>();
        Node current;
        if (root == null) {
            return null;
        }
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            current = queue.peek();
            list.add(current.data);
            if (current.left != null) {
                queue.enqueue(current.left);
            }
            if (current.right != null) {
                queue.enqueue(current.right);
            }
            queue.dequeue();
        }
        return list;
    }

    public void printTree(MyLinkedList list) {
        int flag;
        int counter = 0;
        int space = 0;
        treeHeight = treeHeight();
        for (int i = 0; i < treeHeight; i++) {
            space = (int) Math.pow(2, (treeHeight - i)) / 2;
            printSpace(space);
            for (int j = 0; j < Math.pow(2, i); j++) {
                if (list.length() <= counter) {
                    break;
                }
                printValues(list, counter++);
                if (j != Math.pow(2, i) - 1) {
                    printSpace(((space * 2) - 1));
                }
            }

            for (int tempSpace = space - 1; tempSpace >= space / 2; tempSpace--) {
                System.out.println();
                printSpace(tempSpace);
                flag = 0;
                for (int j = 0; j < Math.pow(2, i + 1); j++) {
                    if (i == treeHeight - 1) {
                        break;
                    }
                    if (list.length() <= counter) {
                        break;
                    }
                    printLines(list, counter);
                    if (counter % 2 == 1) {
                        printSpace(((space - tempSpace) * 2) - 1);
                    } else {
                        printSpace(((tempSpace) * 2) - 1);
                    }
                    counter++;
                    flag++;
                }
                counter -= flag;
                tempSpace -= Math.floor((float) space * 0.1);
            }
            System.out.println();
        }
    }

    public void printValues(MyLinkedList list, int counter) {
        char num = list.get(counter);
        if (num != ' ') {
            System.out.print(" " + num + " ");
        } else {
            System.out.print("   ");
        }
    }

    public void printLines(MyLinkedList list, int counter) {
        char num = list.get(counter);
        if (num != ' ') {
            System.out.print(" . ");
        } else {
            System.out.print("   ");
        }
    }

    public void printSpace(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print("   ");
        }
    }
}

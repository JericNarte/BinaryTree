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

    public MyBinaryTree() {
        root = null;
    }

    public void insert(char data) {
        root = insertNode(data, root);
    }

    public void insert(char[] data) {
        for (char v : data) {
            root = insertNode(v, root);
        }
    }

    private Node insertNode(char data, Node root) {
        if (root == null) {
            return new Node(data);
        }
        MyQueue<Node> queue = new MyQueue<>();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            Node current = queue.peek();
            if (current.left != null) {
                queue.enqueue(current.left);
            } else {
                current.left = new Node(data);
                return root;
            }
            if (current.right != null) {
                queue.enqueue(current.right);
            } else {
                current.right = new Node(data);
                return root;
            }
            queue.dequeue();
        }
        return root;
    }

    public int CountNodes() {
        int nodeCount = 0;
        MyQueue<Node> queue = new MyQueue<Node>();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            Node current = queue.peek();
            nodeCount++;
            if (current.left != null) {
                queue.enqueue(current.left);
            }
            if (current.right != null) {
                queue.enqueue(current.right);
            }
            queue.dequeue();
        }
        return nodeCount;
    }

    public boolean emptyTree() {
        root = null;
        return true;
    }

    public int treeHeight() {
        return treeHeightRecursion(root);
    }

    public int treeHeightRecursion(Node current) {
        if (current == null) {
            return 0;
        } else {
            int left = treeHeightRecursion(current.left);
            int right = treeHeightRecursion(current.right);
            if (left > right) {
                return left + 1;
            } else {
                return right + 1;
            }
        }
    }

    public boolean postOrder() {
        if (CountNodes() == 0) {
            return false;
        }
        System.out.print("Post-Order: ");
        printPostOrder(root);
        System.out.println();
        return true;
    }

    public boolean preOrder() {
        if (CountNodes() == 0) {
            return false;
        }
        System.out.print("Pre-Order: ");
        printPreOrder(root);
        System.out.println();
        return true;
    }

    public boolean inOrder() {
        if (CountNodes() == 0) {
            return false;
        }
        System.out.print("In-Order: ");
        printInOrder(root);
        System.out.println();
        return true;
    }

    private void printPostOrder(Node current) {
        if (current == null) {
            return;
        }
        printPostOrder(current.left);
        printPostOrder(current.right);
        System.out.print(current.data + "  ");
    }

    private void printPreOrder(Node current) {
        if (current == null) {
            return;
        }
        System.out.print(current.data + "  ");
        printPreOrder(current.left);
        printPreOrder(current.right);
    }

    private void printInOrder(Node current) {
        if (current == null) {
            return;
        }
        printInOrder(current.left);
        System.out.print(current.data + "  ");
        printInOrder(current.right);
    }

    public boolean PrintTree() {
        if (CountNodes() == 0) {
            return false;
        }
        int treeHeight = treeHeight();
        MyLinkedList list = new MyLinkedList();
        list = levelTraversal(list);
        print(list, treeHeight);
        return true;
    }

    private MyLinkedList levelTraversal(MyLinkedList list) {
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

    private void print(MyLinkedList list, int treeHeight) {
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
                printVal(list, counter++);
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
                    printLine(list, counter);
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

    private void printVal(MyLinkedList list, int counter) {
        char num = list.get(counter);
        if (num != ' ') {
            System.out.print(" " + num + " ");
        } else {
            System.out.print("   ");
        }
    }

    private void printLine(MyLinkedList list, int counter) {
        char num = list.get(counter);
        if (num != ' ') {
            System.out.print(" . ");
        } else {
            System.out.print("   ");
        }
    }

    private void printSpace(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print("   ");
        }
    }
}

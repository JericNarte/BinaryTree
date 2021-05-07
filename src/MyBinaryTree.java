public class MyBinaryTree {
    Node root;
    int nodeCount;
    int treeHeight;

    public MyBinaryTree() {
        root = null;
    }

    public void insert(char[] values) {
        for (char v : values) {
            root = insertRecursion(root, v);
        }
    }

    private Node insertRecursion(Node current, char value) {
        if (current == null) {
            return new Node(value);
        } else {
            if (value < current.value) {
                current.left = insertRecursion(current.left, value);
            } else {
                current.right = insertRecursion(current.right, value);
            }
        }
        return current;
    }

    public int CountNodes() {
        nodeCount = 0;
        countRecursion(root);
        return nodeCount;
    }

    private void countRecursion(Node current) {
        if (current == null) {
            return;
        } else {
            countRecursion(current.left);
            countRecursion(current.right);
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
        System.out.print(current.value + " -> ");
    }

    public void printPreOrder(Node current) {
        if (current == null) {
            return;
        }
        System.out.print(current.value + " -> ");
        printPreOrder(current.left);
        printPreOrder(current.right);
    }

    public void printInOrder(Node current) {
        if (current == null) {
            return;
        }
        printInOrder(current.left);
        System.out.print(current.value + " -> ");
        printInOrder(current.right);
    }

    public void PrintTree() {
        treeHeight = treeHeight();
        int maxNode = (int) Math.pow(2, treeHeight);
        MyQueue queue = new MyQueue();
        MyLinkedList list = new MyLinkedList();
        list = levelTraversal(queue, list, maxNode);
        printTree(list);
    }

    // 50 25 13 34 7 34 3 2 70 60 65 55 88 89 90
    public MyLinkedList levelTraversal(MyQueue queue, MyLinkedList list, int maxNode) {
        if (root == null) {
            return null;
        }
        queue.enqueue(root.value, root);
        for (int i = 0; i < maxNode; i++) {
            try {
                list.add(queue.front.node.value);
            } catch (NullPointerException e) {
                list.add(' ');
            }
            Node temp = queue.front.node;
            if (temp == null) {
                temp = new Node();
            }
            queue.enqueue(i, temp.left);
            queue.enqueue(i, temp.right);
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
                printValues(list, counter);
                counter++;
                if (j != Math.pow(2, i) - 1) {
                    printSpace(((space * 2) - 1));
                }
            }

            for (int flagSpace = space - 1; flagSpace >= space / 2; flagSpace--) {
                System.out.println();
                flag = 0;
                printSpace(flagSpace);
                for (int j = 0; j < Math.pow(2, i + 1); j++) {
                    if (i == treeHeight - 1) {
                        break;
                    }
                    printLines(list, counter);
                    counter++;
                    flag++;
                }
                counter -= flag;
                if (space > 4) {
                    flagSpace -= Math.floor((float) space * 0.1);
                }

            }
            System.out.println();
        }
    }

    public void printValues(MyLinkedList list, int counter) {
        char num = list.get(counter);
        if (num != ' ') {
            System.out.print(num);
        } else {
            System.out.print(" ");
        }
    }

    public void printLines(MyLinkedList list, int counter) {
        char num = list.get(counter);
        if (num != ' ') {
            System.out.print(".");
        } else {
            System.out.print(" ");
        }
    }

    public void printSpace(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }
}

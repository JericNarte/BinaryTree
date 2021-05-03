public class MyBinaryTree {
    Node root;
    int[] list;
    int nodeCount;
    int treeHeight;
    int maxDigit = 2;

    public MyBinaryTree() {
        root = null;
    }

    public void add(int value) {
        root = addRecursion(root, value);
    }

    private Node addRecursion(Node current, int value) {
        if (current == null) {
            return new Node(value);
        } else {
            if (value < current.value) {
                current.left = addRecursion(current.left, value);
            } else {
                current.right = addRecursion(current.right, value);
            }
        }
        return current;
    }

    public int nodeCount() {
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

    public void print() {
        treeHeight = treeHeight();
        int maxNode = (int) Math.pow(2, treeHeight);
        MyQueue queue = new MyQueue();
        MyLinkedList list = new MyLinkedList();
        list = levelTraversal(queue, list, maxNode);
        printTree(list);
    }

    public MyLinkedList levelTraversal(MyQueue queue, MyLinkedList list, int maxNode) {
        queue.enqueue(root.value, root);
        for (int i = 0; i < maxNode; i++) {
            try {
                list.add(queue.front.node.value);
            } catch (NullPointerException e) {
                list.add(null);
            }
            Node temp = queue.front.node;
            if (temp == null) {
                temp = new Node();
            }
            try {
                queue.enqueue(i, temp.left);
            } catch (NullPointerException e) {
                temp.left = new Node();
            }
            try {
                queue.enqueue(i, temp.right);
            } catch (NullPointerException e) {
                temp.right = new Node();
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

            printSpace(space * maxDigit);
            for (int j = 0; j < Math.pow(2, i); j++) {
                printValues(list, counter);
                counter++;
                if (j != Math.pow(2, i) - 1) {
                    printSpace(((space * 2) - 1) * maxDigit);
                }
            }

            for (int flagSpace = space - 1; flagSpace >= space / 2; flagSpace--) {
                System.out.println();
                flag = 0;
                printSpace(flagSpace * maxDigit);
                for (int j = 0; j < Math.pow(2, i + 1); j++) {
                    if (i == treeHeight - 1) {
                        break;
                    }
                    printLines(list, counter);
                    counter++;
                    flag++;
                    if (j != Math.pow(2, i + 1) - 1) {
                        int skipA = 2 * (space - flagSpace) - 1;
                        int skipB = ((space * 2) - 1) - skipA - 1;
                        if (j % 2 == 0) {
                            printSpace(skipA * maxDigit);
                        } else {
                            printSpace(skipB * maxDigit);
                        }
                    }
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
        Integer num = list.get(counter);
        int space = 0;
        if (num != null) {
            int temp = num;
            while (temp > 0) {
                temp = (int) Math.floor(temp / 10);
                space++;
            }
            int pre = (int) Math.ceil((float) (maxDigit - space) / 2);
            int post = maxDigit - space - pre;

            if (counter % 2 == 0) {
                printSpace(pre);
                System.out.print(num);
                printSpace(post);
            } else {
                printSpace(post);
                System.out.print(num);
                printSpace(pre);
            }

        } else {
            for (int i = 0; i < maxDigit; i++) {
                System.out.print(" ");
            }
        }
    }

    public void printLines(MyLinkedList list, int counter) {
        Integer num = list.get(counter);
        if (num != null) {
            if (counter % 2 == 0) {
                System.out.print(".");
                printSpace(maxDigit - 1);
            } else {
                printSpace(maxDigit - 1);
                System.out.print(".");
            }
        } else {
            for (int i = 0; i < maxDigit; i++) {
                System.out.print(" ");
            }
        }
    }

    public void printSpace(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }
}

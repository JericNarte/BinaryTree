public class MyBinaryTree {
    private class BTNode {
        char data;
        BTNode left;
        BTNode right;

        public BTNode(char data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private final MyLinkedList<Character> arr;
    private BTNode root;
    private int nodeCount;

    public MyBinaryTree() {
        arr = new MyLinkedList<>();
        root = null;
        nodeCount = 0;
    }

    public void insert(char data) {
        arr.add(data);
        nodeCount++;
        root = insertNode(arr, root, 0);

    }

    public void insert(char[] data) {
        for (char v : data) {
            arr.add(v);
            nodeCount++;
        }
        root = insertNode(arr, root, 0);
    }

    private BTNode insertNode(MyLinkedList<Character> arr, BTNode root, int i) {
        if (i < arr.length()) {
            root = new BTNode(arr.get(i));
            root.left = insertNode(arr, root.left, (2 * i) + 1);
            root.right = insertNode(arr, root.right, (2 * i) + 2);
        }
        return root;
    }

    public int countNodes() {
        return nodeCount;
    }

    public void emptyTree() {
        root = null;
        System.out.println("> The Binary Tree is deleted");
    }

    public int treeHeight() {
        return treeHeightRecursion(root);
    }

    public int treeHeightRecursion(BTNode current) {
        if (current == null) {
            return 0;
        }
        int left = treeHeightRecursion(current.left);
        return ++left;
    }

    public void postOrder() {
        if (nodeCount == 0) {
            System.out.println("> The Binary Tree is Empty.");
            return;
        }
        System.out.print("Post-Order: ");
        printPostOrder(root);
        System.out.println();
    }

    public void preOrder() {
        if (nodeCount == 0) {
            System.out.println("> The Binary Tree is Empty.");
            return;
        }
        System.out.print("Pre-Order: ");
        printPreOrder(root);
        System.out.println();
    }

    public void inOrder() {
        if (nodeCount == 0) {
            System.out.println("> The Binary Tree is Empty.");
            return;
        }
        System.out.print("In-Order: ");
        printInOrder(root);
        System.out.println();
    }

    private void printPostOrder(BTNode current) {
        if (current != null) {
            printPostOrder(current.left);
            printPostOrder(current.right);
            System.out.print(current.data + "  ");
        }
    }

    private void printPreOrder(BTNode current) {
        if (current != null) {
            System.out.print(current.data + "  ");
            printPreOrder(current.left);
            printPreOrder(current.right);
        }

    }

    private void printInOrder(BTNode current) {
        if (current != null) {
            printInOrder(current.left);
            System.out.print(current.data + "  ");
            printInOrder(current.right);
        }
    }

    public void PrintTree() {
        if (nodeCount == 0) {
            System.out.println("> The Binary Tree is Empty.");
            return;
        }
        print(arr);
    }

    private void print(MyLinkedList<Character> list) {
        int counter = 0;
        int treeHeight = treeHeight();

        for (int i = 0; i < treeHeight; i++) {
            int space = (int) Math.pow(2, (treeHeight - i)) / 2;
            int gap = (int) Math.pow(2, (treeHeight - i)) - 1;
            int slots = (int) Math.pow(2, i);

            for (int j = 0; j < slots; j++) {
                printSpace((j == 0) ? space : gap);
                System.out.print(" " + list.get(counter++) + " ");
                if (counter >= list.length()) {
                    break;
                }
            }
            if (i == treeHeight - 1) { break; }

            for (int tempSpace = space - 1; tempSpace >= space / 2; tempSpace--) {
                System.out.println();
                printSpace(tempSpace);
                int flag = 0;
                for (int j = 0; j < Math.pow(2, i + 1); j++) {
                    System.out.print(" . ");
                    int gapIN = ((space - tempSpace) * 2) - 1;
                    int gapOUT = ((tempSpace) * 2) - 1;
                    printSpace((counter % 2 == 1) ? gapIN : gapOUT);
                    counter++;
                    flag++;
                    if (list.length() <= counter) {
                        break;
                    }
                }
                counter -= flag;
                tempSpace -= Math.floor((float) space * 0.1);
            }
            System.out.println();
        }
    }


    private void printSpace(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print("   ");
        }
    }
}

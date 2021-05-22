public class MyBinaryTree {
    // Binary Tree Node
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

    private MyLinkedList<Character> arr;
    private BTNode root;
    private int nodeCount;

    public MyBinaryTree() {
        arr = new MyLinkedList<>();
        root = null;
        nodeCount = 0;
    }

    // Insert a values into the Binary Tree in order level
    public void insert(char data) {
        arr.add(data);
        nodeCount++;
        root = insertNode(arr, root, 0);
    }

    // Insert an array of values into the Binary Tree in order level
    public void insert(char[] data) {
        for (char v : data) {
            arr.add(v);
            nodeCount++;
        }
        root = insertNode(arr, root, 0);
    }

    // Create a Binary Tree base on the values of the array
    private BTNode insertNode(MyLinkedList<Character> arr, BTNode root, int i) {
        if (i < arr.length()) {
            root = new BTNode(arr.get(i));
            root.left = insertNode(arr, root.left, (2 * i) + 1);
            root.right = insertNode(arr, root.right, (2 * i) + 2);
        }
        return root;
    }

    // Delete the existing Binary Tree
    public void emptyTree() {
        arr = new MyLinkedList<>();
        root = null;
        nodeCount = 0;
        System.out.println("> The Binary Tree is deleted");
    }

    // Get the number of Nodes or size of the Binary Tree
    public int countNodes() {
        return nodeCount;
    }

    // Get the height of the Binary Tree
    public int treeHeight() {
        return treeHeightRecursion(root);
    }

    // Recursive function to get the height of the Binary Tree
    public int treeHeightRecursion(BTNode current) {
        if (current == null) {
            return 0;
        }
        int left = treeHeightRecursion(current.left);
        return ++left;
    }

    // Print the elements inside the Binary Tree in Post-Order
    public void postOrder() {
        if (nodeCount == 0) {
            System.out.println("> The Binary Tree is Empty.");
            return;
        }
        System.out.print("Post-Order: ");
        printPostOrder(root);
        System.out.println();
    }

    private void printPostOrder(BTNode current) {
        if (current != null) {
            printPostOrder(current.left);
            printPostOrder(current.right);
            System.out.print(current.data + "  ");
        }
    }

    // Print the elements inside the Binary Tree in Pre-Order
    public void preOrder() {
        if (nodeCount == 0) {
            System.out.println("> The Binary Tree is Empty.");
            return;
        }
        System.out.print("Pre-Order: ");
        printPreOrder(root);
        System.out.println();
    }

    private void printPreOrder(BTNode current) {
        if (current != null) {
            System.out.print(current.data + "  ");
            printPreOrder(current.left);
            printPreOrder(current.right);
        }

    }

    // Print the elements inside the Binary Tree in In-Order
    public void inOrder() {
        if (nodeCount == 0) {
            System.out.println("> The Binary Tree is Empty.");
            return;
        }
        System.out.print("In-Order: ");
        printInOrder(root);
        System.out.println();
    }

    private void printInOrder(BTNode current) {
        if (current != null) {
            printInOrder(current.left);
            System.out.print(current.data + "  ");
            printInOrder(current.right);
        }
    }

    // Print the Binary Tree Model
    public void PrintTree() {
        if (nodeCount == 0) {
            System.out.println("> The Binary Tree is Empty.");
            return;
        }

        int counter = 0;
        int treeHeight = treeHeight();

        // Each loop prints a level of the Binary Tree
        for (int i = 0; i < treeHeight; i++) {
            int space = (int) Math.pow(2, (treeHeight - i)) / 2;
            int gap = (int) Math.pow(2, (treeHeight - i)) - 1;

            // Print values of the (i)th level of the Binary Tree
            for (int j = 0; j < Math.pow(2, i); j++) {
                printSpace((j == 0) ? space : gap);
                System.out.print(" " + arr.get(counter++) + " ");
                if (counter >= arr.length()) break;
            }

            // No need to print connecting lines for Leaf Nodes
            if (i == treeHeight - 1) break;

            // Print a series of connecting dots to each child of a node in the (i)th level of the Binary Tree
            for (int tempSpace = space - 1; tempSpace >= space / 2; tempSpace--) {
                int flag = 0;
                int gapIN = ((space - tempSpace) * 2) - 1;
                int gapOUT = ((tempSpace) * 2) - 1;

                // Print a dot toward each children nodes
                System.out.println();
                for (int j = 0; j < Math.pow(2, i + 1); j++) {
                    printSpace((j == 0) ? tempSpace : (counter % 2 == 0) ? gapIN : gapOUT);
                    System.out.print(" . ");
                    counter++;
                    flag++;
                    if (arr.length() <= counter) break;
                }

                // Control the height between parent and child nodes
                tempSpace -= Math.floor((float) space * 0.1);
                counter -= flag;
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

import java.util.Scanner;

public class MyBinaryTreeDemo {
    MyBinaryTree<Character> tree = new MyBinaryTree<>();
    Scanner scanner = new Scanner(System.in);

    //Binary Tree's max number of nodes
    final int SIZE = 30;

    public static void main(String[] args) {
        System.out.println("> Program Started\n");
        MyBinaryTreeDemo demo = new MyBinaryTreeDemo();
        demo.initializeMenu();
        System.out.println("\n> Thank you for using the program.");
    }

    public void initializeMenu() {
        boolean run;
        String userInput;
        System.out.println("[Binary Tree]");
        System.out.println("> Data Type: Char");
        System.out.println("> Max Nodes: " + SIZE);

        do {
            // Print a Menu containing all options
            System.out.println("\n\t1. Input contents");
            System.out.println("\t2. Count content of tree");
            System.out.println("\t3. Print Tree");
            System.out.println("\t4. Print post-order");
            System.out.println("\t5. Print pre-order");
            System.out.println("\t6. Print in-order");
            System.out.println("\t7. Delete Tree\n");

            // Ask the user to choose an option
            // will repeat until a valid input is accepted
            do {
                System.out.print("Choose an option: ");
                userInput = scanner.nextLine();
                userInput = inputProcess(userInput, "menu");
                if (userInput.equals("-1")) {
                    System.out.println("[Invalid Input]");
                }
            } while (userInput.equals("-1"));
            System.out.println();

            // Run the designated task for each input
            switch (userInput) {
                case "1" -> inputContent();
                case "2" -> countNodes();
                case "3" -> tree.PrintTree();
                case "4" -> tree.postOrder();
                case "5" -> tree.preOrder();
                case "6" -> tree.inOrder();
                case "7" -> tree.emptyTree();
                default -> {
                    System.out.println("ERROR: INVALID INPUT PASSED");
                    return;
                }
            }
            System.out.println();

            // Ask the user to continue or end the program
            // will repeat until a valid input is accepted
            do {
                System.out.print("Do you want to continue? Y or N : ");
                userInput = scanner.nextLine();
                userInput = inputProcess(userInput, "end");
                if (userInput.equals("-1")) {
                    System.out.println("[Invalid Input]");
                }
            } while (userInput.equals("-1"));

            //Repeat the process until the users ask the program to stop
            run = userInput.equalsIgnoreCase("Y");
        } while (run);
    }


    public void inputContent() {
        char[] inputList;
        Character[] finalList;
        String userInput;

        // Only Allow upto SIZE nodes or elements
        if (tree.countNodes() >= SIZE) {
            System.out.printf("> The Binary Tree is Full (Max Capacity: %d)\n", SIZE);
            return;
        }

        // Ask the user to input a character or a series of characters
        // will repeat until a valid input is accepted
        do {
            System.out.print("Input element(s): ");
            userInput = scanner.nextLine();
            userInput = inputProcess(userInput, "input");
            if (userInput.equals("-1")) {
                System.out.println("[Invalid Input]");
            }
        } while (userInput.equals("-1"));

        // Convert the primitive data type char to object Character
        inputList = userInput.trim().toCharArray();
        finalList = new Character[inputList.length];
        for (int i = 0; i < inputList.length; i++) {
            finalList[i] = inputList[i];
        }

        // If the input wont exceed the binary tree's capacity
        // The program will then send the inputs to the binary tree
        // Else will ask the user for another input
        if (inputList.length + tree.countNodes() > SIZE) {
            System.out.println("> Input exceeded Binary Tree's capacity");
            System.out.printf("> Max Capacity: %d, Current: %d\n\n", SIZE, tree.countNodes());
            inputContent();
            return;
        }
        tree.insert(finalList);
        System.out.printf("> %d new Elements added to the Binary Tree\n", inputList.length);
    }

    public void countNodes() {
        // Show the total number of nodes/elements inside the Binary Tree
        System.out.printf("> There are %d elements in the Binary Tree\n", tree.countNodes());
    }


    public String inputProcess(String userInput, String method) {
        // Every user input will undergo checking
        switch (method) {
            // Input for menu will only accept integers from 1 to 7 inclusive
            case "menu" -> {
                userInput = userInput.replaceAll("\\s", "");
                if (userInput.length() == 1 && Character.isDigit(userInput.charAt(0))) {
                    int i = Character.getNumericValue(userInput.charAt(0));
                    if (i < 8 && i > 0) {
                        return userInput;
                    }
                }
                return "-1";
            }
            // Input for program termination will only accept a single character {y,Y,n,N}
            case "end" -> {
                userInput = userInput.replaceAll("\\s", "");
                if (userInput.length() == 1) {
                    if (userInput.equalsIgnoreCase("Y") || userInput.equalsIgnoreCase("N")) {
                        return userInput;
                    }
                }
                return "-1";
            }
            // Input for the Binary Tree will only accept alphabets
            case "input" -> {
                String[] list;
                while (userInput.contains("  ")) {
                    userInput = userInput.replaceAll(" {2}", " ");
                }
                list = userInput.trim().split("( )");
                for (String s : list) {
                    if (s.length() != 1 || !Character.isAlphabetic(s.charAt(0))) {
                        return "-1";
                    }
                }
                userInput = "";
                for (String s : list) {
                    userInput = userInput.concat(s);
                }
                return userInput;
            }
            default -> {
                return "-1";
            }
        }
    }
}

import java.util.Scanner;

public class MyBinaryTreeDemo {
    MyBinaryTree tree = new MyBinaryTree();
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("> Program Started");
        MyBinaryTreeDemo demo = new MyBinaryTreeDemo();
        demo.initializeMenu();
        System.out.println("\n> Thank you for using the program.");
    }

    public void initializeMenu() {
//        tree.insert(new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'b', 'c', 'd', 'e', 'f', 'g', 'h'});
        boolean run;
        String userInput;
        System.out.println("Binary Tree (Data type: char)");
        do {
            System.out.println("\n\t1. Input contents");
            System.out.println("\t2. Count content of tree");
            System.out.println("\t3. Print Tree");
            System.out.println("\t4. Print post-order");
            System.out.println("\t5. Print pre-order");
            System.out.println("\t6. Print in-order");
            System.out.println("\t7. Delete Tree\n");
            do {
                System.out.print("Choose an option: ");
                userInput = scanner.nextLine();
                userInput = inputProcess(userInput, "menu");
                if(userInput.equals("-1")){
                    System.out.println("[Invalid Input]");
                }
            } while (userInput.equals("-1"));
            System.out.println();
            switch (userInput) {
                case "1" -> inputContent();
                case "2" -> countNodes();
                case "3" -> printBinaryTree();
                case "4" -> {
                    if (!tree.postOrder()) {
                        System.out.println("> The Binary Tree is Empty.");
                    }
                }
                case "5" -> {
                    if (!tree.preOrder()) {
                        System.out.println("> The Binary Tree is Empty.");
                    }
                }
                case "6" -> {
                    if (!tree.inOrder()) {
                        System.out.println("> The Binary Tree is Empty.");
                    }
                }
                case "7" -> {
                    if (tree.emptyTree()) {
                        System.out.println("> The Binary Tree is deleted");
                    }
                }
                default -> {
                    System.out.println("ERROR: INVALID INPUT PASSED");
                    return;
                }
            }
            System.out.println();
            do {
                System.out.print("Do you want to continue? Y or N : ");
                userInput = scanner.nextLine();
                userInput = inputProcess(userInput, "end");
                if(userInput.equals("-1")){
                    System.out.println("[Invalid Input]");
                }
            } while (userInput.equals("-1"));
            run = userInput.equalsIgnoreCase("Y");
        } while (run);
    }

    public void inputContent() {
        char[] inputList;
        String userInput;
        do {
            System.out.print("Input element(s): ");
            userInput = scanner.nextLine();
            userInput = inputProcess(userInput, "input");
            if (userInput.equals("-1")) {
                System.out.println("[Invalid Input]");
            }
        } while (userInput.equals("-1"));
        inputList = userInput.trim().toCharArray();
        tree.insert(inputList);
        System.out.printf("> %d new Elements added to the Binary Tree\n", inputList.length);
    }

    public void printBinaryTree() {
        if (!tree.PrintTree()) {
            System.out.println("> The Binary Tree is Empty.");
        }
    }

    public void countNodes() {
        System.out.printf("> There are %d elements in the Binary Tree\n", tree.CountNodes());
    }

    public String inputProcess(String userInput, String method) {
        switch (method) {
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
            case "end" -> {
                userInput = userInput.replaceAll("\\s", "");
                if (userInput.length() == 1) {
                    if (userInput.equalsIgnoreCase("Y") || userInput.equalsIgnoreCase("N")) {
                        return userInput;
                    }
                }
                return "-1";
            }
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
                for (int i = 0; i < list.length; i++) {
                    userInput = userInput.concat(list[i]);
                }
                return userInput;
            }
            default -> {
                return "-1";
            }
        }
    }
}

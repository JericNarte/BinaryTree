import java.util.Scanner;

public class MyBinaryTreeDemo {
    MyBinaryTree tree = new MyBinaryTree();
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("> Program Started");
        MyBinaryTreeDemo demo = new MyBinaryTreeDemo();
        demo.initializeMenu();

        System.out.println("> Program Ended");
    }

    public void initializeMenu() {
//        tree.insert(new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'b', 'c', 'd', 'e', 'f', 'g', 'h'});
        boolean run;
        String userInput;
        do {
            System.out.println("1. Input contents");
            System.out.println("2. Count content of tree");
            System.out.println("3. Print Tree");
            System.out.println("4. Print post-order");
            System.out.println("5. Print pre-order");
            System.out.println("6. Print in-order");
            do {
                System.out.print("Input: ");
                userInput = scanner.nextLine();
                userInput = inputProcess(userInput, "menu");
            } while (userInput.equals("-1"));

            switch (userInput) {
                case "1" -> inputContent();
                case "2" -> countNodes();
                case "3" -> printBinaryTree();
                case "4" -> tree.postOrder();
                case "5" -> tree.preOrder();
                case "6" -> tree.inOrder();
                default -> {
                    System.out.println("ERROR: 102");
                    return;
                }
            }
            do {
                System.out.print("Do you want to continue: Y or N? : ");
                userInput = scanner.nextLine();
                userInput = inputProcess(userInput, "end");
            } while (userInput.equals("-1"));
            run = userInput.equalsIgnoreCase("Y");
        } while (run);
    }

    public void inputContent() {
        char[] inputList;
        String userInput;
        System.out.println("[Input Content Selected]");
        do {
            System.out.print("Input element(s): ");
            userInput = scanner.nextLine();
            userInput = inputProcess(userInput, "input");
            if (userInput.equals("-1")) {
                System.out.println("Input Error");
            }
        } while (userInput.equals("-1"));
        inputList = userInput.trim().toCharArray();
        tree.insert(inputList);
        System.out.printf("%d Elements added to the Binary Tree\n", inputList.length);
    }

    public void printBinaryTree() {
        if (tree.CountNodes() == 0) {
            System.out.println("The Binary Tree is Empty.");
        } else {
            tree.PrintTree();
        }
    }

    public void countNodes() {
        System.out.printf("There are %d elements in the Binary Tree\n", tree.CountNodes());
    }

    public String inputProcess(String userInput, String method) {
        switch (method) {
            case "menu" -> {
                userInput = userInput.replaceAll("\\s", "");
                if (userInput.length() == 1 && Character.isDigit(userInput.charAt(0))) {
                    if (Character.getNumericValue(userInput.charAt(0)) < 7) {
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

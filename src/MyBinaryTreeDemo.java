public class MyBinaryTreeDemo {
    public static void main(String[] args){
        System.out.println("> Program Started");
        MyBinaryTree tree = new MyBinaryTree();
        tree.add(50);
        tree.add(25);
        tree.add(75);
        tree.add(18);
        tree.add(23);
        tree.add(63);
        tree.add(83);
        tree.add(4);
        tree.add(12);
        tree.add(19);
        tree.add(27);
        tree.add(58);
        tree.add(67);
        tree.add(79);
        tree.add(87);
        tree.add(26);
        tree.add(30);
        tree.add(2);
        tree.add(28);
        tree.add(39);
        tree.add(80);
        tree.add(78);
        tree.add(24);
        tree.add(85);
        tree.add(90);
        tree.add(84);
        tree.add(86);
        tree.add(89);
        tree.add(98);
        tree.add(1);
        tree.add(3);
        tree.add(8);
        tree.add(13);
//        tree.add(99);
        tree.print();
        System.out.println(tree.nodeCount());
        System.out.println(tree.treeHeight());
        System.out.println("> Program Ended");
    }
}

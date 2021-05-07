public class MyLinkedList {
    class LNode {
        char value;
        LNode next;

        LNode(char value) {
            this.value = value;
            this.next = null;
        }
    }

    LNode head;
    LNode tail;

    MyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void add(char value) {
        LNode temp = new LNode(value);
        if (head == null) {
            head = temp;
            tail = temp;
            return;
        }
        tail.next = temp;
        tail = temp;
    }

    public char get(int index){
        LNode itr = head;
        for (int i = 0; i < index; i++) {
            itr = itr.next;
        }
        return itr.value;
    }
}

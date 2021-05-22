public class MyLinkedList<T> {
    private class LNode {
        T data;
        LNode next;
        
        LNode(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private LNode head;
    private LNode tail;
    private int length;

    MyLinkedList() {
        length = 0;
        head = null;
        tail = null;
    }

    public void add(T data) {
        LNode temp = new LNode(data);
        if (head == null) {
            head = temp;
            tail = temp;
            length++;
            return;
        }
        tail.next = temp;
        tail = temp;
        length++;
    }

    public T get(int index) {
        LNode itr = head;
        for (int i = 0; i < index; i++) {
            itr = itr.next;
        }
        return itr.data;
    }

    public int length() {
        return length;
    }
}

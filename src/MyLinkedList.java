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
    private int size;

    MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(T data) {
        LNode temp = new LNode(data);
        size++;
        if (head == null) {
            head = temp;
            tail = temp;
            return;
        }
        tail.next = temp;
        tail = temp;
    }

    public T get(int index) {
        LNode itr = head;
        for (int i = 0; i < index; i++) {
            itr = itr.next;
        }
        return itr.data;
    }

    public int size() {
        return size;
    }
}

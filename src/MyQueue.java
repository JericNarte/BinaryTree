public class MyQueue {
    class QNode {
        int value;
        QNode next;
        Node node;

        QNode(int value, Node node) {
            this.value = value;
            this.node = node;
            this.next = null;

        }
    }

    QNode front;
    QNode rear;

    MyQueue() {
        this.front = null;
        this.rear = null;
    }

    public void enqueue(int value, Node node) {
        QNode temp = new QNode(value, node);
        if (this.front == null) {
            this.rear = temp;
            this.front = temp;
            return;
        }
        this.rear.next = temp;
        this.rear = temp;
    }

    public void dequeue() {
        if (this.front == null) {
            return;
        }
        QNode temp = this.front;
        this.front = this.front.next;
        temp = null;
        if (this.front == null) {
            this.rear = null;
        }
    }

    public void print() {
        QNode itr = this.front;
        while (itr != null) {
            System.out.print(" -> " + itr.value);
            itr = itr.next;
        }
    }
}

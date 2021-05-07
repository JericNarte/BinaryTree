public class MyQueue<T> {
    private class QNode {
        QNode next;
        T node;

        QNode(T node) {
            this.node = node;
            this.next = null;
        }
    }

    private QNode front;
    private QNode rear;

    MyQueue() {
        this.front = null;
        this.rear = null;
    }

    public void enqueue(T node) {
        QNode temp = new QNode(node);
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

    public T peek() {
        return front.node;
    }

    public boolean isEmpty() {
        return front == null;
    }
}

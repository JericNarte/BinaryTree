public class MyQueue<T> {
    private class QNode {
        QNode next;
        T node;

        QNode(T node) {
            this.node = node;
            this.next = null;
        }
        public T getNode(){
            return node;
        }
    }

    private QNode front;
    private QNode rear;

    MyQueue() {
        this.front = null;
        this.rear = null;
    }

    public void enqueue(T node) {
        if(node == null){
            return;
        }
        QNode temp = new QNode(node);
        if (front == null) {
            rear = temp;
            front = temp;
            return;
        }
        rear.next = temp;
        rear = temp;
    }

    public void dequeue() {
        if (front == null) {
            return;
        }
        QNode temp = this.front;
        front = this.front.next;
        temp = null;
        if (front == null) {
            rear = null;
        }
    }

    public T peek() {
        return front.getNode();
    }

    public boolean isEmpty() {
        return front == null;
    }
}

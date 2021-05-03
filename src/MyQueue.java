public class MyQueue {
    class QNode {
        int value;
        int index;
        QNode next;
        Node node;
        Node parent;

        QNode(int value){
            this.value = value;
            this.next = null;
        }

        QNode(int value, Node node) {
            this.value = value;
            this.node = node;
            this.parent = parent;
            this.next = null;

        }
    }

    QNode front;
    QNode rear;

    MyQueue() {
        this.front = null;
        this.rear = null;
    }

    public void enqueue(int value) {
        QNode temp = new QNode(value);
        enqueue(temp);
    }
    public void enqueue(int value, Node node) {
        QNode temp = new QNode(value, node);
        enqueue(temp);
    }

    public void enqueue(QNode temp){
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
            System.out.print(" -> "+itr.value);
            itr = itr.next;
        }
    }
}

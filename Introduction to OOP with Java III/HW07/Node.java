public class Node<T> {
    private T data;
    private Node<T> next;

    // Constructor with data and next node
    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    // Constructor with only data
    public Node(T data) {
        this(data, null); // Constructor chaining
    }

    // Getters and setters
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}

import java.util.NoSuchElementException;

public class LinkedList<T> implements List<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    // No-args constructor
    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // Adds data at the specified index
    public void addAtIndex(T data, int index) {
        if (data == null) throw new IllegalArgumentException("You cannot add null data to the list");
        if (index < 0 || index > size) throw new IllegalArgumentException("Your index is out of the list bounds");

        Node<T> newNode = new Node<>(data);
        if (index == 0) {
            newNode.setNext(head);
            head = newNode;
            if (size == 0) tail = head;
        } else {
            Node<T> previous = head;
            for (int i = 0; i < index - 1; i++) {
                previous = previous.getNext();
            }
            newNode.setNext(previous.getNext());
            previous.setNext(newNode);
            if (index == size) tail = newNode;
        }
        size++;
    }

    // Retrieves data at a specified index
    public T getAtIndex(int index) {
        if (index < 0 || index >= size) throw new IllegalArgumentException("Your index is out of the list bounds");

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getData();
    }

    // Removes data at the specified index and returns the data
    public T removeAtIndex(int index) {
        if (index < 0 || index >= size) throw new IllegalArgumentException("Your index is out of bounds");

        T data;
        if (index == 0) {
            data = head.getData();
            head = head.getNext();
            if (size == 1) tail = null;
        } else {
            Node<T> previous = head;
            for (int i = 0; i < index - 1; i++) {
                previous = previous.getNext();
            }
            Node<T> toRemove = previous.getNext();
            data = toRemove.getData();
            previous.setNext(toRemove.getNext());
            if (index == size - 1) tail = previous;
        }
        size--;
        return data;
    }

    // Removes the first occurrence of the specified data
    public T remove(T data) {
        if (data == null) throw new IllegalArgumentException("You cannot remove null data from the list");
        if (isEmpty()) throw new NoSuchElementException("The data is not present in the list.");

        Node<T> current = head;
        Node<T> previous = null;
        while (current != null && !current.getData().equals(data)) {
            previous = current;
            current = current.getNext();
        }

        if (current == null) throw new NoSuchElementException("The data is not present in the list.");

        if (previous == null) {
            head = head.getNext();
            if (size == 1) tail = null;
        } else {
            previous.setNext(current.getNext());
            if (current == tail) tail = previous;
        }
        size--;
        return current.getData();
    }

    // Clears the list
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    // Checks if the list is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Returns the size of the list
    public int size() {
        return size;
    }

    // Getters for head and tail
    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }
}

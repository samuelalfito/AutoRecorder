package system;

public class SinglyLinkedList<T> {
    private Node<T> head;
    private int n = 0;

    public class Node<Type> {
        public T item;
        public Node<T> next;
    }

    private Node<T> node_at(int index) {
        Node<T> iter = head;
        for (int i = 0; i < index; i++) {
            iter = iter.next;
        }
        return iter;
    }

    private Node<T> create_item(T item) {
        Node<T> newNode = new Node<>();
        newNode.item = item;
        newNode.next = null;
        n++;
        return newNode;
    }

    private void create_list(T item) {
        head = create_item(item);
    }

    private void insert_before(T item) {
        Node<T> newNode = create_item(item);
        newNode.next = head;
        head = newNode;
    }

    private void insert_after(T item, Node<T> node) {
        Node<T> newNode = create_item(item);
        newNode.next = node.next;
        node.next = newNode;
    }

    public Node<T> addItem(T Item) {
        return addItem(Item, n - 1);
    }

    public Node<T> addItem(T item, int index) {
        if (head == null) { // insert to head
            create_list(item);
        } else if (index <= 0) { // insert before linkedlist
            insert_before(item);
        } else if (index < n) { // insert after item
            insert_after(item, node_at(index));
        } else { // insert outside afer linkedlist
            insert_after(item, node_at(n));
        }
        return head;
    }

    public int size() {
        return n;
    }

    public void run(int loop) {
        Node<T> current = head;
        while (loop != 0) {
            if (current.item instanceof IRunnable) {
                ((IRunnable) current.item).run();
            }
            if (current.next != null) {
                current = current.next;
                continue;
            }
            loop--;
            current = head;
        }
    }
}

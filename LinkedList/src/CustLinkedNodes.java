import java.util.Iterator;

public class CustLinkedNodes<E> implements Iterable<E> {
    private int size = 0;
    private Node<E> head;
    private Node<E> tail;

    // Добавление элемента
    public void add(E e) {
        Node<E> newNode = new Node<>(null, e, null);
        if (head == null) {
            head = newNode;
        } else {
            newNode.previous = tail;
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    // Размер списка
    public int size() {
        return size;
    }

    // Индекс элемента
    private Node<E> getByIndex(int index) {
        int maxIndex = size - 1;
        if (index == 0) {
            return head;
        }
        if (index == maxIndex) {
            return tail;
        }
        boolean search = index > size / 2;
        Node<E> node = search ? tail: head;
        int counter = search ? maxIndex - index: index;
        for (int i =0; i < counter; i++){
            node = search ? node.previous: node.next;
        }
        return node;
    }
//    Проверка индекса на существование
    public void isIndexExist(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }
//    Отдает жлемент по номеру индекса
    public E getNodeByIndex(int index) {
        isIndexExist(index);
        Node<E> node = getByIndex(index);
        return node.element;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            Node<E> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E element = current.element;
                current = current.next;
                return element;
            }
        };
    }

    @Override
    public String toString() {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (E e : this) {
            sb.append("Node ").append(count++).append(": ").append(e).append("\n");
        }
        sb.append(String.format("List size: %d", size));
        return sb.toString();
    }
}
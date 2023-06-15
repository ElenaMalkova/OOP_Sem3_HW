public class Node<E> {
        Node<E> previous;
        E element;
        Node<E> next;

        public Node(Node<E> previous, E element, Node<E> next) {
            this.previous = previous;
            this.element = element;
            this.next = next;
        }
    }


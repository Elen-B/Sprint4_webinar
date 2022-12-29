import java.util.Iterator;

public class LinkedList<T> implements Iterable<T>{
    Node<T> head, tail;

    public void insert(T data) {
        Node<T> node = new Node(data);
        if (head == null) {
            head = node;
            tail = head;
        }
        else {
            tail.next = node;
            tail = node;
        }
    }

    public void removeFirst() {
        head = head.next;
    }

    public void removeLast() {
        if (head == null) {
            return;
        }
        Node<T> current = head;

        while (current.next != tail)
            current = current.next;

        current.next = null;
    }

    public Node<T> getTail() {
        return tail;
    }

    public Node<T> getHead() {
        return head;
    }

    //добавляет со сдвигом
    public void insertByIndex(int index, T data) {
        Node<T> current = head;
        Node<T> newNode = new Node(data);

        if (index == 0) {
            newNode.next = head;
            head = newNode;
        }
        else {
            for(int i = 1; i < index; i++) {
                    current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            Node<T> current = LinkedList.this.getHead();

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    static class Node<T> {

        T data;
        Node<T> next;

        // Constructor
        Node(T t) {
            data = t;
            next = null;
        }
    }

    public static void main(String[] args) {
        LinkedList<String> listString = new LinkedList<>();
        listString.insert("Привет");
        listString.insert("мир");
        listString.insertByIndex(1,"целый");

        for (String s : listString) {
            System.out.print(s + ' ');
        }
    }

    // домашнее задание
    // 1. добавить метод public void insert(T data), который бы вставлял новый Node в конец списка
    // 2. реализовать интерфейс Iterable<T> (class LinkedList<T> implements Iterable<T>)
    // 3. Добавить методы removeFirst() и removeLast() которые удаляют первый и последний элемент соотвественно
    // 4. Добавить метод insertByIndex(int index, T data), который бы заменял элемент на индексе index
}

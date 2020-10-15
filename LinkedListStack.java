package datastructure;

public class LinkedListStack<E> implements Stack<E> {
    private LinkedList<E> list;

    public LinkedListStack() {
        list = new LinkedList<>();
    }

    @Override
    public E peek() {
        return list.get(0);
    }

    @Override
    public E pop() {
        return list.remove(0);
    }

    @Override
    public void push(E e) {
        list.add(0, e);
    }

    @Override
    public int size() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Stack:top");
        str.append(list);
        return str.toString();
    }

    public static void main(String[] args) {
        LinkedListStack<Integer> li = new LinkedListStack<>();
        for (int i = 1; i < 11; i++) {
            li.push(i);
        }
        System.out.println(li);
    }
}

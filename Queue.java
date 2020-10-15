package datastructure;

public interface Queue<E>{
    public int getSize();
    boolean isEmpty();
    E deQueue();
    void inQueue(E e);
    E getFront();
}
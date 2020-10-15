package datastructure;

public class ArrayQueue<E> implements Queue<E> {
    private Array<E> myQueue;

    public ArrayQueue(int capacity) {
        myQueue = new Array<>(capacity);
    }
    public ArrayQueue(){
        this(10);
    }

    @Override
    public int getSize() {
        return myQueue.getSize();
    }

    @Override
    public boolean isEmpty() {
        return myQueue.isEmpty();
    }

    @Override
    public E deQueue() {
        return myQueue.delFirst();
    }

    @Override
    public void inQueue(E e) {
        myQueue.addLast(e);
    }


    @Override
    public E getFront() {
        return myQueue.findElement(myQueue.getSize()-1);
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> aq=new ArrayQueue<>();
        aq.inQueue(1);
        aq.inQueue(2);
        aq.inQueue(3);
        aq.inQueue(3);
        System.out.println(aq.deQueue());
        System.out.println(aq.deQueue());
        System.out.println(aq.getSize());
    }
}

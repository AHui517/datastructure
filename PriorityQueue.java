package datastructure;

public class PriorityQueue<E extends Comparable<E>> implements Queue<E>{

    private MaxHeap<E> maxHeap;

    public PriorityQueue(){
        maxHeap=new MaxHeap<>();
    }

    @Override
    public int getSize() {
        return maxHeap.getSize();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    @Override
    public E deQueue() {
        return maxHeap.extractMax();
    }

    @Override
    public void inQueue(E e) {
        maxHeap.add(e);
    }

    @Override
    public E getFront() {
        return maxHeap.findMax();
    }
}

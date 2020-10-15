package datastructure;

import java.util.Random;

public class MaxHeap<E extends Comparable<E>> {

    private Array<E> array;

    public MaxHeap(){
        array=new Array<>();
    }

    public MaxHeap(int size){
        array=new Array<>(size);
    }

    public MaxHeap(E[] arr){
        array=new Array<>(arr);
        for (int i = parentIndex(getSize()-1); i >=0 ; i--) {
            siftUp(i);
        }
    }
    public int getSize(){
        return array.getSize();
    }

    public boolean isEmpty(){
        return array.isEmpty();
    }

    public E replace(E e){
        E ret=findMax();
        array.set(0,e);
        siftDown(0);
        return ret;
    }
    private int parentIndex(int index){
        if (index==0)  throw new IllegalArgumentException("index 0 hava not parent node");
        return (index-1)/2;
    }

    private int leftChildIndex(int index){
        return 2*index+1;
    }

    private int rightChildIndex(int index){
        return 2*index+2;
    }

    public void add(E e){
        array.addLast(e);
        //调用siftUp来维持这个堆
        siftUp(array.getSize()-1);
    }
    //新增一个元素后，siftUp()来维持堆
    private void siftUp(int k){
        while (k>0&&array.findElement(parentIndex(k)).compareTo(array.findElement(k))<0){
            array.swap(k,parentIndex(k));
            k=parentIndex(k);
        }
    }

    //查看最大元素
    public E findMax(){
        if (array.isEmpty()) throw new IllegalArgumentException("erro");
        return array.findElement(0);
    }

    //取出最大元素
    public E extractMax(){
        E ret=findMax();
        array.swap(0,array.getSize()-1);
        array.delLast();
        //维持取出最大元素后得新堆
        siftDown(0);
        return ret;
    }

    //siftDown()维持取出最大元素后得堆
    private void siftDown(int k){
        while (leftChildIndex(k)<array.getSize()){
            int j=leftChildIndex(k);
            if (j+1<array.getSize()&&array.findElement(j+1).compareTo(array.findElement(j))>0){
                j++;
//                j=rightChildIndex(k);
            }
            if (array.findElement(k).compareTo(array.findElement(leftChildIndex(k)))>=0)
                break;
            array.swap(k,j);
            k=j;
        }
    }

    public static void main(String[] args) {
        int n=10;
        Random random=new Random();
        MaxHeap<Integer> maxheap=new MaxHeap<>();
        for (int i = 0; i < n; i++) {
            maxheap.add(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < n; i++) {
            System.out.println(maxheap.extractMax());
        }
    }
}

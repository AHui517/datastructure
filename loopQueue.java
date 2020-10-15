package datastructure;

public class loopQueue <E> implements Queue<E>{
    E[] data;
    int front=0;        //指向队首元素
    int tail=0;            //指向队尾元素的后一个元素
//    int size=0;

    public loopQueue(int capacity){
        data = (E[]) new Object[capacity+1];
    }

    public loopQueue(){
        this(10);
    }

    @Override
    public int getSize() {
//        return size;
        return tail>=front?tail-front:tail-front+data.length;
    }

    public int getCapacity(){
        return data.length-1;
    }
    @Override
    public boolean isEmpty() {
        return front==tail;
    }

    @Override
    public E deQueue() {

        if (isEmpty())
            throw new IllegalArgumentException("");
        E ret=data[front];
        data[front]=null;
        front=(front+1)%data.length;
//        size--;
        if (getSize()==getSize()/4&&getSize()/2!=0)
            resize(getSize()/2);

        return ret;
    }


    @Override
    public void inQueue(E e) {
        if ((tail+1)%data.length==front){
            resize(2*getSize());
        }
        data[tail]=e;
        tail=(tail+1)%data.length;
//        size++;
    }

    @Override
    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("");
        return data[front];
    }

    //该方法用于扩充数组
    private void resize(int x){
        E[] newData= (E[]) new Object[x+1];
        for (int i = 0; i < getSize(); i++) {
            newData[i] = data[(i+front)%data.length];
            data=newData;
            front=0;
            tail=getSize();
        }
    }

    @Override
    public String toString(){

        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", getSize(), getCapacity()));
        res.append("front [");
        for (int i=front;i!=tail;i=(i+1)%data.length){
            res.append(data[i]);
            if((i + 1) % data.length != tail)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        loopQueue<Integer> lo = new loopQueue<>();
        lo.inQueue(1);
        lo.inQueue(2);
        lo.inQueue(7);
        System.out.println(lo.getSize());
    }
}

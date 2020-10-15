package datastructure;

public class LinkedListQueue<E> implements Queue<E>{

    private class Node{
        public E e;
        public Node next;

        public Node(E e,Node next){
            this.e=e;
            this.next=next;
        }
        public Node(){
            this(null,null);
        }
        public Node(E e){
            this(e,null);
        }
    }

    private Node head,tail;
    private int size;

    public LinkedListQueue(){
        head=null;
        tail=null;
        size=0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public E deQueue() {
        if (isEmpty())
            throw new IllegalArgumentException("error");
        Node delNode=head;
        head=head.next;
        delNode.next=null;
        if (head==null){
            tail=null;
        }
        size--;
        return delNode.e;
    }

    //入队操作
    @Override
    public void inQueue(E e) {
        if (tail==null){
            tail=new Node(e);
            head=tail;
        }else {
            tail.next=new Node(e);
            tail=tail.next;
        }
        size++;
    }

    @Override
    public E getFront() {
        if (isEmpty()){
            throw new IllegalArgumentException("error");
        }
        return head.e;
    }
    @Override
    public String toString(){
        StringBuilder str=new StringBuilder();
        str.append("Queue:front");
        Node cur=head;
        while (cur!=null){
            str.append(cur.e+"->");
            cur=cur.next;
        }
        str.append("NULL tail");
        return str.toString();
    }
}

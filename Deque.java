package datastructure;

public class Deque<E> {
    private class Node{
        public E e;
        public Node next;
        public Node prev;

        public Node(E e, Node next,Node prev){
            this.e=e;
            this.next=next;
            this.prev=prev;
        }


        public Node(E e){
            this(e,null,null);
        }
        public Node(){
            this(null,null,null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }
    private Node dummyHead;
    private Node tail;
    private int size;

    public Deque(){
        dummyHead=new Node(null,null,null);
        tail=new Node(null,null,null);
        size=0;
    }
    public int getSize(){
        return size;
    }

    public void pushLeft(E e){
        Node node=new Node(e);
        if (size==0){
            dummyHead.next=node;
            tail=node;
            node.prev=dummyHead;
        }
        else {
            node.next=dummyHead.next;
            dummyHead.next.prev=node;
            dummyHead.next=node;
            node.prev=dummyHead;
        }
        size++;
    }

    public void pushRight(E e){
        Node node=new Node(e);
        tail.next=node;
        node.prev=tail;
        tail=tail.next;

        size++;
    }

    public E popLeft(){
        if (dummyHead.next==null)
            throw new IllegalArgumentException("error");
        Node node=dummyHead.next;
        dummyHead.next=node.next;
        node.next.prev=dummyHead;
        size--;
        return node.e;
    }

    public E popRight(){
        if (dummyHead.next==null)
            throw new IllegalArgumentException("error");
        Node node=tail;
        tail=tail.prev;
        tail.next=null;
        size--;
        return node.e;
    }
    public static void main(String[] args) {
        Deque<Integer> de=new Deque<>();
        System.out.println(de.getSize());
        de.pushLeft(1);
        de.pushLeft(2);
        de.pushLeft(3);
        System.out.println(de.dummyHead.next.e);
        de.popLeft();
        System.out.println(de.dummyHead.next.e);
        de.pushRight(10);
        System.out.println(de);
    }
}

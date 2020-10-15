package datastructure;

import java.util.IllformedLocaleException;

public class DoublyLinkedList<E> {
    private class Node{
        E e;
        Node next;
        Node prev;

        public Node(E e,Node next,Node prev){
            this.e=e;
            this.next=next;
            this.prev=prev;
        }
        public Node(){
            e=null;
            next=null;
            prev=null;
        }
        public Node(E e){
            this(e,null,null);
        }
    }

    private Node dummyHead;
    private Node tail;
    private int listSize=0;

    public DoublyLinkedList(){
        dummyHead=new Node(null,null,null);
        tail=new Node(null,null,null);
        listSize=0;
    }

    //指定索引位置增加元素
    public void add(int index,E e) {
        if (index < 0 || index > listSize)
            throw new IllformedLocaleException();
        Node cur=new Node(e);
        Node p=dummyHead;
        int pos=0;
        while (pos!=index){
            p=p.next;
            pos++;
        }
        cur.prev=p.prev;
        cur.prev.next=cur;
        cur.next=p;
        p.prev=cur;

        listSize++;
    }

    public Node remove(int index){
        Node cur=dummyHead;
        int pos=1;
        while (index!=pos){
            cur=cur.next;
            pos++;
        }
        Node e=cur;
        cur.prev.next=cur.next;
        if (cur.next!=null)
            cur.next.prev=cur.prev;

        listSize--;
        return e;
    }

    @Override
    public String toString() {
        StringBuilder str=new StringBuilder();
        Node a=dummyHead;
        while (a!=null){
            a=a.next;
            str.append(a.e+"");
        }
        return str.toString();
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> a=new DoublyLinkedList<>();
        a.add(0,1);
        a.add(0,2);
        a.add(0,3);
        System.out.println(a);
    }
}

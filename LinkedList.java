package datastructure;

public class LinkedList<E> {

    

    private class Node{
        public E e;
        public Node next;

        public Node(E e,Node next){
            this.e=e;
            this.next=next;
        }


        public Node(E e){
            this(e,null);
        }
        public Node(){
            this(null,null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;  //虚拟头节点
    private int size;

    public LinkedList(){
        dummyHead=new Node(null,null);
        size=0;
    }

    //g4获取链表的元素个数
    public int getSize(){
        return size;
    }

    //返回链表是否为空
    public boolean isEmpty(){
        return size==0;
    }

    //在链表头添加元素
    public void addFirst(E e){
//        Node node = new Node(e);
//        head.next=node;
//        head=node;

//        head=new Node(e,head);
        add(0,e);
    }

    public void add(int index,E e){
        if (index<0 || index>size)
            throw new IllegalArgumentException("索引有误");
            Node prev=dummyHead;
            for (int i=0;i<index;i++)
                prev=prev.next;
//            Node node=new Node(e);
//            node.next=prev.next;
//            prev.next=node;
            prev.next=new Node(e, prev.next);
            size++;
    }

    //末尾处添加
    public void addLast(E e){
        add(size,e);
    }

    //获取索引处的值
    public E get(int index){
        if (index<0||index>=size){
            throw new IllegalArgumentException("error");
        }
        Node cur=dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur=cur.next;
        }
            return cur.e;
    }
//修改链表元素
    public void set(int index,E e){
        if (index<0||index>=size){
            throw new IllegalArgumentException("error");
        }
        Node cur=dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur=cur.next;
        }
        cur.e=e;

    }

    //查找是否含有指定元素
    public boolean contains(E e){
        Node cur=dummyHead.next;
        while (cur!=null){
            if (cur.equals(e)){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }

    //删除节点
    public E remove(int index){
        if (index<0||index>=size)
            throw new IllegalArgumentException("error");

        Node prev=dummyHead;
        for (int i = 0; i < index; i++) {
            prev=prev.next;
        }
        Node retNode=prev.next;
        prev.next=retNode.next;
        retNode.next=null;
        size--;
        return retNode.e;
    }

//删除第一个元素
    public E removeFirst(){
        return remove(0);
    }

    //删除最后一个元素
    public E removeLast(){
        return remove(size-1);
    }

    @Override
    public String toString(){
        StringBuilder res=new StringBuilder();
        Node cur=dummyHead.next;
        while (cur!=null){
            res.append(cur+"->");
            cur=cur.next;
        }
        res.append("NULL");
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> lk=new LinkedList<>();
        lk.addFirst(1);
        lk.addFirst(2);
        lk.addFirst(3);
        lk.addFirst(4);
        System.out.println(lk);
        System.out.println(lk);
        int[] arr={0,1,3,7};
        LinkedList<Integer> lkls=new LinkedList<>();
    }
}

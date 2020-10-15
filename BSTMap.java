package datastructure;

public class BSTMap<K extends Comparable<K>,V> implements Map<K,V>{

    private class Node{
        public K key;
        public V value;
        public Node left,right;

        public Node(K key,V value){
            this.key=key;
            this.value=value;
            this.left=null;
            this.right=null;
        }
    }

    private Node root;
    private int size;

    public BSTMap(){
        root=null;
        size=0;
    }

    @Override
    public void add(K key, V value) {
        root=add(root,key,value);
    }

    private Node add(Node node,K key,V value){
        if (node==null){
            size++;
            return new Node(key,value);
        }
        if (key.compareTo(node.key)<0){
            node.left=add(node.left,key,value);
        }
        else if (key.compareTo(node.key)>0){
            node.right=add(node.right,key,value);
        }
        //key==node.key
        else  node.value=value;
        return node;
    }

    @Override
    public V remove(K key) {
        Node node=remove(root,key);
        if (node==null)  return null;
        return node.value;
    }

    private Node remove(Node node,K key){
        if (node==null)  return null;
        if (key.compareTo(node.key)<0){
            node.left = remove(node.left,key);
        }
        else if (key.compareTo(node.key)>0){
            node.right = remove(node.right,key);
        }
        else {
            if (node.left == null){
                Node cur=node.right;
                node=null;
                size--;
                return cur;
            }
            else if (node.right == null) {
                Node cur=node.left;
                node=null;
                size--;
                return cur;
            }
            Node cur = node.right;
            while (cur.left != null) {
                cur = cur.left;
            }
            cur.left = node.left;
            cur.right = node.right;
            node = null;
            return cur;
        }
        return null;
    }

    public Node getNode(Node node,K key){
        if (node==null)  return null;
        if (key.compareTo(node.key)<0) {
            return getNode(node.left, key);
        }
        else if(key.compareTo(node.key)>0) {
            return getNode(node.right, key);
        }
        return node;
    }

    @Override
    public boolean contains(K key) {
        return getNode(root,key)!=null;
    }

    @Override
    public V get(K key) {
        Node node=getNode(root,key);
        return node==null?null:node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node=getNode(root,key);
        if (node==null) throw new IllegalArgumentException(key + " doesn't exist!");
        getNode(root,key).value=newValue;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    public static void main(String[] args) {
        BSTMap<String,Integer> map=new BSTMap<>();
        map.add("zhaoyu",527);
        map.add("liu",4658);
        map.add("kong",1999);
        System.out.println(map.get("kong"));
        System.out.println(map.contains("kong"));
        map.remove("liu");
        System.out.println(map.contains("liu"));
    }
}

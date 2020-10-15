package datastructure;

public class BSTSet<E extends Comparable<E>> implements Set<E>{
    private BST<E> bst;

    public BSTSet(){
        bst=new BST<>();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }

    public void inOrder(){
        bst.midOrder();
    }
    public static void main(String[] args) {
        BSTSet<Integer> set=new BSTSet<>();
        set.add(5);
        set.add(4);
        set.add(9);
        set.add(1);
        set.add(3);
        set.add(7);
        set.add(7);
        set.inOrder();
    }
}

package datastructure;

public class ArrayStack<E> implements Stack<E>{
    private Array<E> array;
//    int size=0;
    public ArrayStack(int capacity){
        array=new Array<>(capacity);
    }

    public ArrayStack(){
        array=new Array<>(10);
    }


    @Override
    public E peek() {
        return array.findElement(array.getSize()-1);
    }

    @Override
    public E pop() {
        return array.delLast();
    }



    @Override
    public void push(Object e) {
        array.addLast((E)e);
    }

    @Override
    public int size() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

}

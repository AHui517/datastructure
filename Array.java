package datastructure;

public class Array<E> {
    private E[] data;
    private int size = 0;

    //有参构造函数，确定数组大小
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
    }

    //无参构造函数默认10
    public Array() {
        this(10);
    }

    //根据数组生成动态数组
    public Array(E[] arr){
        int len=arr.length;
        data = (E[]) new Object[len];
        for (int i = 0; i < len; i++) {
            data[i] = arr[i];
        }
        size=len;
    }

    //返回元素个数
    public int getSize() {
        return size;
    }

    //返回数组大小
    public int getCapacity() {
        return data.length;
    }

    //是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //在索引位置插入元素
    public void add(int index, E element) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("数组越界");
        if (size == data.length) {
            resize(data.length * 3 / 2);
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = element;
        size++;
    }

    //在第一个位置插入元素
    public void addFirst(E element) {
        add(0, element);
    }

    //最后增加元素
    public void addLast(E element) {
        add(size, element);
    }

    //删除索引位置元素
    public E del(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("参数输入有误");
        }
        if (size == data.length / 4) {
            resize(data.length / 2);
        }
        E delElement = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[index] = null;
        size--;
        return delElement;
    }

    //交换俩元素
    public void swap(int i, int j) {
        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    //修改元素
    public void set(int index,E e){
        if (index<0||index>=size)
            throw new IllegalArgumentException("error can't do it");
        data[index] = e;
    }

    //删除第一个元素
    public E delFirst() {
        return del(0);
    }

    //删除最后一个元素
    public E delLast() {
        return del(size - 1);
    }

    //根据元素找索引
    public int findIndex(E element) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    //根据索引找元素
    public E findElement(int index) {
        return data[index];
    }

    //动态扩充数
    private void resize(int x) {
        E[] newArray = (E[]) new Object[x];
        for (int i = 0; i < size; i++) {
            newArray[i] = data[i];
        }
        data = newArray;
    }

    //打印类的基本信息
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array:size=%d,capacity=%d\n", size, data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();

    }
//    public static void morrisPre(Node head) {
//        if(head == null){
//            return;
//        }
//        Node cur = head;
//        Node mostRight = null;
//        while (cur != null){
//            mostRight = cur.left;
//            if(mostRight != null){
//                while (mostRight.right !=null && mostRight.right != cur){
//                    mostRight = mostRight.right;
//                }
//                if(mostRight.right == null){
//                    mostRight.right = cur;
//                    System.out.print(cur.value+" ");
//                    cur = cur.left;
//                    continue;
//                }else {
//                    mostRight.right = null;
//                }
//            }else {
//                System.out.print(cur.value + " ");
//            }
//            cur = cur.right;
//        }
//        System.out.println();
//    }
}

package datastructure;

import java.util.Random;
import java.util.TreeSet;

public class Main {

    public static double stackTest(Stack<Integer> stack,int runCount){
        long startTime=System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < runCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < runCount; i++) {
            stack.pop();
        }
        long endTime=System.nanoTime();
        return (endTime-startTime)/1000000000.0;
    }

    public static double queueTest(Queue<Integer> queue,int runCount){
        long startTime=System.nanoTime();
        Random random=new Random();
        for (int i = 0; i < runCount; i++) {
            queue.inQueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < runCount; i++) {
            queue.deQueue();
        }
        long endTime=System.nanoTime();
        return (endTime-startTime)/1000000000.0;
    }
    public static void main(String[] args) {
//        Array<Character> arr=new Array<>();
//        Array<Integer> array = new Array<>();
//        array.addLast(1);
//        array.addLast(2);
//        System.out.println(array.del(1));
//        String str="kongtonghui";
//        for (int i = 0; i < str.length(); i++) {
//            arr.addLast(str.charAt(i));
//        }
//        System.out.println(arr);
//        ArrayStack<Integer> myStack=new ArrayStack<>();
//        myStack.push(23);
//        myStack.push(12);
//        myStack.push(2112);
//        System.out.println(myStack.pop());
//        System.out.println(myStack.peek());
//        loopQueue<Integer> lo = new loopQueue<>();
//        lo.inQueue(1);
//        lo.inQueue(5);
//        lo.inQueue(7);
//        System.out.println(lo);


        //测试数组，和链表实现栈的性能差异
//        ArrayStack<Integer> arrayStack=new ArrayStack<>();
//        LinkedListStack<Integer> linkedListStack=new LinkedListStack<>();
//        ArrayQueue<Integer> arrayQueue=new ArrayQueue<>();
//        loopQueue<Integer> loopQueue=new loopQueue<>();
//        int opCount=100000;
//        double time1 =stackTest(arrayStack,opCount);
//        double time2 =stackTest(linkedListStack,opCount);
//        System.out.println("ArrayStack:"+time1+"s");
//        System.out.println("linkedListStack:"+time2+"s");
//
//        //测试循环队列和普通队列
//        double time3=queueTest(arrayQueue,opCount);
//        double time4=queueTest(loopQueue,opCount);
//        System.out.println("普通队列："+time3+'s');
//        System.out.println("循环队列："+time4+'s');

        //测试MaxHeap

        String[] words=new String[500000];
        Random random=new Random();
        for(int i=0;i<words.length;i++){
            words[i]=random.nextInt()+"";
        }

        TreeSet<String> set=new TreeSet<>();
        Trie trie=new Trie();
        for(int i=0;i<words.length;i++){
            set.add(words[i]);
        }
        long start=System.nanoTime();
        for(int i=0;i<words.length;i++){
            set.contains(words[i]);
        }
        long end=System.nanoTime();
        System.out.println("TreeSet:"+set.size()+"-----"+(end-start)/1000000000.0+"s");


        for(int i=0;i<words.length;i++){
            trie.add(words[i]);
        }
        start=System.nanoTime();
        for(int i=0;i<words.length;i++){
            trie.contains(words[i]);
        }
        end=System.nanoTime();
        System.out.println("Trie:"+trie.getSize()+"-----"+(end-start)/1000000000.0+"s");
    }
}

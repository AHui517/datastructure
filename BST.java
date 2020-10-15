package datastructure;

import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;

public class BST<E extends Comparable<E>> {
    //E为可比较类型
    private class Node {
        public E e;
        public int height;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            height=1;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int getHight(Node node){
        if (node==null){
            return 0;
        }
        return node.height;
    }

    //获取节点的平衡因子 (绝对值)
    private int getBF(Node node){
        if (node==null){
             return 0;
        }
        return getHight(node.left)-getHight(node.right);
    }

    //当前BST是否平衡
    private boolean isBalance(Node root){
        if (root==null) return true;
        if (Math.abs(getBF(root))>1) return false;
        return isBalance(root.left)&&isBalance(root.right);
    }

//    右旋操作
    private Node rightRotate(Node y){
        Node x=y.left;
        y.left=x.right;
        x.right=y;
        y.height=Math.max(getHight(y.left),getHight(y.right))+1;
        x.height=Math.max(getHight(y),getHight(x.left))+1;
        return x;
    }

//    左旋操作
    private Node leftRotate(Node y){
        Node x=y.right;
        y.right=x.left;
        x.right=y;
        y.height=Math.max(getHight(y.left),getHight(y.right))+1;
        x.height=Math.max(getHight(y),getHight(x.right))+1;
        return x;
    }

    public void add(E e) {
        root = add(root, e);
    }

    //增加元素
    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0)
            node.left = add(node.left, e);
        else if (e.compareTo(node.e) > 0)
            node.right = add(node.right, e);
        node.height=Math.max(getHight(node.left),getHight(node.right))+1;

        int bf=getBF(node);
//        LL
        if (bf>1&&getBF(node.left)>=0)
            return rightRotate(node);
//        RR
        if (bf<-1&&getBF(node.right)<=0)
            return leftRotate(node);
//        LR
        if (bf>1&&getBF(node.left)<0){
            node.left=leftRotate(node.left);
            return rightRotate(node);
        }
//        RL
        if (bf>-1&&getBF(node.right)>0){
            node.right=rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    //查找元素
    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node root, E e) {
        if (root == null)
            return false;
        if (root.e.compareTo(e) == 0)
            return true;
        else if(root.e.compareTo(e)<0)
            return contains(root.right,e);
        else
            return contains(root.left, e);
    }

    //前序遍历
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null)
            return;
        System.out.print(node.e + "--");
        preOrder(node.left);
        preOrder(node.right);
    }

    //中序遍历
    public void midOrder() {
        midOrder(root);
    }

    private void midOrder(Node node) {
        if (node == null)
            return;
        midOrder(node.left);
        System.out.print(node.e+" ");
        midOrder(node.right);
    }

    //后序遍历
    public void PostOrder() {
        midOrder(root);
    }

    private void PostOrder(Node node) {
        if (node == null)
            return;
        PostOrder(node.left);
        System.out.print(node.e + "--");
        PostOrder(node.right);
    }

    //非递归实现前序遍历
    public void preOrderLoop() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.print(node.e + "--");
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }
    }

    //层序遍历
    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.e + "--");
            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
        }
    }

    //寻找二分搜索树的最小值
    public E minValue() {
        if (root == null)
            throw new IllegalArgumentException();
        while (root.left != null) {
            root = root.left;
        }
        return root.e;
    }

    //寻找二分搜索树的最大值
    public E maxValue() {
        if (root == null)
            throw new IllegalArgumentException();
        return maxValue(root);
    }

    public E maxValue(Node node) {
        if (node.left == null)
            return node.e;
        return maxValue(node.left);
    }

    //删除二分搜索的最大值
    public Node removeMaxValue() {
        return removeMaxValue(root);
    }

    private Node removeMaxValue(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMaxValue(node.left);
        //返回根节点
        return node;
    }

    //删除指定节点
    public void remove(E e) {
        root = remove(root, e);
    }

    private Node remove(Node node, E e) {
        if (node == null)
            return null;
        if (e.compareTo(root.e) > 0) {
            node.right = remove(node.right, e);
            //这里是最后一步，将删除指定元素后的新的数返回
            return node;
        } else if (e.compareTo(root.e) < 0) {
            node.right = remove(root.left, e);
            return node;
        } else {
            if (node.left==null) {
                Node cur=node.right;
                node=null;
                size--;
                return cur;
            }
            else if (node.right==null){
                Node cur=node.left;
                node=null;
                size--;
                return cur;
            }
            else{
                Node newNode=node.right;
                while (newNode.left!=null){
                    newNode=newNode.left;
                }
                newNode.left=node.left;
                newNode.right=node.right;
                node=null;
                size--;
                return newNode;
            }
        }
    }
        public static void main (String[]args){
            BST<Integer> bst = new BST<>();
        }
}
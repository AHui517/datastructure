package datastructure;

import java.util.TreeMap;

public class Trie {
    private class Node{
        private boolean isWord;
        private TreeMap<Character,Node> next;

        public Node(boolean isWord){
            this.isWord=isWord;
            next=new TreeMap<>();
        }
        public Node(){
            this(false);
        }
    }

        public Node root;
        public int size;

        public Trie(){
            root=new Node();
            size=0;
        }

        //获取trie中单词个数
        public int getSize(){
            return size;
        }

        //增加字符串
        public void add(String word){
            Node cur=root;
            for(char c:word.toCharArray()){
                if(cur.next.get(c)==null){
                    cur.next.put(c,new Node());
                }
                cur=cur.next.get(c);
            }
            if (!cur.isWord){
                cur.isWord=true;
                size++;
            }
        }

        //查询字符串
    public boolean contains(String word){
            Node cur=root;
            for(char c:word.toCharArray()){
                if (cur.next.get(c)==null){
                    return false;
                }
                cur=cur.next.get(c);
            }
            return cur.isWord;
    }

    //是否有prefix为前缀的单词
    public boolean isPrefix(String prefix){
            Node cur=root;
            for(char c:prefix.toCharArray()){
                if (cur.next.get(c)==null){
                    return false;
                }
                cur=cur.next.get(c);
            }
            return true;
    }

    //删除指定字符串
    public boolean delete(String word){
            Node cur=root;
            Node temp=new Node();
            for (char c:word.toCharArray()){
                if (cur.next.get(c)==null) {
                    return false;
                }
                if (cur.isWord) temp=cur;
                else if (cur.next.keySet().size()>1) temp=cur.next.get(c);
                cur=cur.next.get(c);
            }
            if (cur.next.keySet().size()!=0){
                cur.isWord=false;
            }
            else{
                temp.isWord=false;
                temp.next=null;
            }
            return true;
    }

    public static void main(String[] args) {
        Trie t=new Trie();
        t.add("12345");
        t.add("124");
        t.add("1235");
        t.add("12347");
        t.add("13");
        System.out.println(t.delete("12345"));;
        System.out.println(t.contains("12345"));
        System.out.println(t.contains("124"));
        System.out.println(t.contains("1235"));
    }
}
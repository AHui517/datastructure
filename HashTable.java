package datastructure;


import java.util.TreeMap;

public class HashTable<K,V> {
    TreeMap<K,V>[] hashTable;
    int M;
    int size;

    public  HashTable(int M){
        this.size=0;
        this.M=M;
        hashTable=new TreeMap[M];
        for (int i = 0; i < M; i++) {
            hashTable[i] = new TreeMap<>();
        }
    }

    public HashTable(){
        this(97);
    }

//    添加一个键值对
    public void push(K k,V v){
        TreeMap<K,V> tem=hashTable[hash(k)];
        if (!tem.containsKey(k)) {
            size++;
        }
        tem.put(k,v);
    }

//    删除操作
    public V remove(K k){
        TreeMap<K,V> map=hashTable[hash(k)];
        V ret=null;
        if (map.containsKey(hash(k))) {
            ret = map.remove(k);
            size--;
        }
        return ret;
    }

    //修改操作
    public void set(K k,V v){
        TreeMap<K,V> map=hashTable[hash(k)];
        if (!map.containsKey(k))
            throw new IllegalArgumentException(k + "don't exist!");
        map.put(k,v);
    }

    //是否包含该键
    public boolean containsKey(K k){
        return hashTable[hash(k)].containsKey(k);
    }

    //    获取键对应的值
    public V get(K k){
        if (!hashTable[hash(k)].containsKey(k))
            throw new IllegalArgumentException(k + "don't exist!");
        return hashTable[hash(k)].get(k);
    }

//    hash函数  &操作是保证hash值为正数
    private int hash(K key){
        return (key.hashCode() & 0x7777777) % M;
    }

    public int getSize() {
        return size;
    }
}

package datastructure;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * 实现一个可以动态扩容的hashmap
 * @param <K>
 * @param <V>
 */
public class HashMap<K,V> {
//    当平均的hash碰撞超过10，开始扩容
    private static final int upperTol = 10;
    private static final int lowerTol = 2;
//    hash表的容积大小数组，这些取值更不容易出现hash碰撞
    private final int[] capacity = {17,37,79,163,331,
            673,1361,2729,5471,10949,21911,43853,87719,175447,
            350899,701819,1403641,2807303,5614657,11229331,22458671,
            44917381,89834777,179669557,359339171,718678369,1437356741,2147483647};
//    hash表初始容量
    private int capacityIndex = 0;
    //用红黑树组实现hash表
    private TreeMap<K,V>[] hashTable;
//    hash表的开辟的空间大小
    private int M;
//    hash表已使用的空间
    private int size;
    public  HashMap(){
        this.size=0;
        this.M=capacity[capacityIndex];
        hashTable=new TreeMap[M];
        for (int i = 0; i < M; i++) {
            hashTable[i] = new TreeMap<>();
        }
    }


    //    添加一个键值对
    public void push(K k,V v){
        TreeMap<K,V> tem=hashTable[hash(k)];
        if (!tem.containsKey(k)) {
            size++;
            if (size >= M * upperTol && capacityIndex +1 < capacity.length){
                resize(capacity[++capacityIndex]);
            }
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
            if (size < M * lowerTol && capacityIndex > 0){
                resize(capacity[--capacityIndex]);
            }
        }
        return ret;
    }

    private void resize(int newM) {
        TreeMap<K,V>[] newMap = new TreeMap[newM];
        int oldM=M;
        this.M=newM;
        for (int i = 0; i < newM; i++) {
            newMap[i] = new TreeMap<>();
        }
        for (int i = 0; i < oldM; i++) {
            TreeMap<K,V> map=hashTable[i];
            for (K k :map.keySet()) {
                newMap[hash(k)].put(k,map.get(k));
            }
        }
        this.hashTable = newMap;
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

    @Override
    public String toString() {
        return "HashMap{" +
                "hashTable=" + Arrays.toString(hashTable) +
                '}';
    }
}

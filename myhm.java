import java.util.*;

public class myhm<K,V> {
    
    class Pair {
        K key;
        V value;

        Pair(K key,V value){
            this.key = key;
            this.value = value;
        }

    }

    private LinkedList<Pair>[] buckets ;
    private int size = 0;

    public myhm(){
        buckets = new LinkedList[4];
        for(int i = 0 ; i < buckets.length ; i++){
            buckets[i] = new LinkedList<>();
        }
        size = 0;
    }
    
    public boolean containsKey(K key){
        int bi = hashFunction(key);
        int di = findWithInBucket(key, bi);
        if(di==-1){
            return false;
        } else {
            return true;
        }
    }

    public V get(K key){
        int bi = hashFunction(key);
        int di = findWithInBucket(key, bi);
        if(di==-1){
            return null;
        } else {
            return buckets[bi].get(di).value;
            
        }
    }

    public V remove(K key){
        int bi = hashFunction(key);
        int di = findWithInBucket(key, bi);
        if(di==-1){
            return null;
        } else {
            size--;
            Pair p2r = buckets[bi].remove(di);
            return p2r.value;
        }
    }

    public void put(K key,V value){
        int bi = hashFunction(key);
        int di = findWithInBucket(key, bi);
        if(di==-1){
            Pair p2a = new Pair(key, value);
            buckets[bi].add(p2a);
            size++;
        } else {
            Pair p2u = buckets[bi].get(di);
            p2u.value = value;
        }

        double lambda = size*1.0/buckets.length;
        if(lambda>2.0){
            rehash();
        }
    }
    
    public ArrayList<K> keySet(){
        ArrayList<K> res = new ArrayList<>();
        for(int i = 0 ; i < buckets.length ; i++){
            for(Pair p: buckets[i]){
                res.add(p.key);
            }
        }
        return res;
    }

    public void display(){
        System.out.println("--------------------");
        for(int i = 0 ; i < buckets.length ; i++){
            System.out.print("Bucket " + i + " : ");
            for(Pair p: buckets[i]){
                System.out.print("[" + p.key + "->" + p.value + "],");
            }
            System.out.println();
        }
        System.out.println("--------------------");
    }

    private int hashFunction(K key){
        int hc = key.hashCode();
        int bi = Math.abs(hc) % buckets.length ;
        return bi;
    }

    private int findWithInBucket(K key,int bi){
        int di = 0;

        for (Pair p : buckets[bi]) {
            if(p.key.equals(key)){
                return di;
            }
            di++;
        }

        return -1;
    }

    private void rehash(){
        LinkedList<Pair> [] obuckets = buckets;
        buckets = new LinkedList[obuckets.length * 2];
        for(int i = 0 ; i < buckets.length ; i++){
            buckets[i] = new LinkedList<>();
        }
        size = 0;
        for(int i = 0 ; i < obuckets.length ; i++){
            for(Pair p: obuckets[i]){
                put(p.key, p.value);
            }
        }
    }

}
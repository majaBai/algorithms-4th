import edu.princeton.cs.algs4.*;
import java.util.Iterator;

public class MinPQBasedArray <Key extends Comparable<Key>>{
    private Key[] a;
//    size = a.length
    private int size;

    @SuppressWarnings("unchecked")
    public MinPQBasedArray (int max){
        a = (Key[]) new Comparable[max];
        size = 0;
    }
// insert based unordered Array
    public void insert(Key v){
        size +=1;
        a[size - 1] = v;
}

// due to the unordered Array, should find out min element firstly
    public Key min(){
        InsertSort(a);
        Key min = a[0];
        swap(a, 0, size-1);
        return min;
    }

    public Key delMin(){
        Key min = min();
        a[size -1] = null;
        size--;
        return min;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }
    public void show(int m){
        InsertSort(a);
        for(int i = 0; i < m; i++){
            System.out.println(a[i]);
        }
    }

//    helper methods
    public void InsertSort(Key[] a){
        int n = size;
        for(int i = 1; i < n; i++){
            for(int j = i; j > 0 && less(a[j], a[j-1]); j--){
                swap(a, j, j-1);
            }
        }
    }

    public void swap(Key[]a,int i, int j){
        Key t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    private  boolean less (Key v, Key w){
        return v.compareTo(w) < 0;
    }


    public static void main(String[] a){

    }


}
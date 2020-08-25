import edu.princeton.cs.algs4.*;
import java.util.Iterator;

public class MaxPQBasedArray <Key extends Comparable<Key>>{
    private Key[] a;
    private int size;

    @SuppressWarnings("unchecked")
    public MaxPQBasedArray(int max){
        a = (Key[]) new Comparable[max];
        size = 0;
    }

// insert based ordered array
    public void insert(Key v){
        size +=1;
        a[size-1] = v;
        if(size > 1){
            InsertSort(a);
        }
    }
    public Key max(){
//        cannot return a[a.length - 1], because the a.length is unchangeable,
//        what we changed is size when a element is deleted
        return a[size -1];
    }
// array is up-ordered, delMax can delete the last element directly
    public Key delMax(){
        Key max = max();
        size--;
        a[a.length-1] = null;
        return max;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void show(){
        for(int i = 0; i < size; i++){
            System.out.println(a[i]);
        }
    }
//    helper method
    public void swap(Key[]a,int i, int j){
        Key t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    private  boolean less (Key v, Key w){
        return v.compareTo(w) < 0;
    }
    public void InsertSort(Key[] a){
        int n = size();
        for(int i = 1; i < n; i++){
            for(int j = i; j > 0 && less(a[j], a[j-1]); j--){
                swap(a, j, j-1);
            }
        }
    }

    public static void main(String[] a){

    }


}
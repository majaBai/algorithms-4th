import edu.princeton.cs.algs4.*;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MinPQ<Key extends Comparable<Key>>{
    private Key[] pq;
    private int n;
    private Comparator<Key> comparator;

    @SuppressWarnings("unchecked")
    public MinPQ(int cap){
        pq = (Key[]) new Comparable[cap+1];
        n = 0;
    }

    public MinPQ() {
        this(1);
    }
    @SuppressWarnings("unchecked")

    public MinPQ(int cap, Comparator<Key> comparator){
        this.comparator = comparator;
        pq = (Key[]) new Comparable[cap + 1];
        n =0;
    }
    @SuppressWarnings("unchecked")

    public MinPQ(Key[] keys){
        n = keys.length;
        pq = (Key[]) new Comparable[keys.length+1];
        for(int i = 0; i < n; i++){
            pq[i+1] = keys[i];
        }
        for(int k = n/2; k >=1; k--){
            sink(k);
        }
    }

    public boolean isEmpty(){
        return n ==0 ;
    }

    public int size(){
        return n;
    }

    public Key min(){
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        return pq[1];
    }
    @SuppressWarnings("unchecked")

    public void resize(int cap){
        Key[] temp = (Key[]) new Comparable[cap];
        for(int i = 0; i <= n; i++){
            temp[i] = pq[i];
        }
        pq = temp;
    }

    public void insert(Key x){
        if(n == pq.length - 1) resize(2 * pq.length);
        pq[++n] = x;
        swim(n);
    }

    public Key delMin(){
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        Key min = pq[1];
        exch(1, n--);
        sink(1);
        pq[n+1] = null;
        if((n > 0) && (n == (pq.length-1)/4)) resize(pq.length/2);
        return min;
    }


    private void sink (int k){
        while(2*k <= n){
            int j = 2*k;
            if(j < n && greater(j, j+1)) j++;
            if(!greater(k, j)) break;
            exch(k,j);
            k = j;
        }
    }
    private void swim(int k){
        while (k > 1 && greater(k/2, k)){
            exch(k, k/2);
            k = k/2;
        }
    }

    private boolean greater(int i, int j){
        if(comparator == null){
            return ((Comparable<Key>) pq[i]).compareTo(pq[j]) > 0;
        } else {
            return comparator.compare(pq[i], pq[j]) > 0;
        }
    }

    private void exch(int j, int k){
        Key swap = pq[j];
        pq[j] = pq[k];
        pq[k] = swap;
    }
}



import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.awt.*;

public class IndexMinPQ <Key extends Comparable<Key>>{
    private int N;
    private int[] pq;
    private int[] qp;
    private Key[] keys;

@SuppressWarnings("unchecked")
    public IndexMinPQ(int n){
        keys = (Key[]) new Comparable[n + 1];
        pq = new int[n+1];
        qp = new int[n+1];
        for(int i = 0; i <= n; i++){
            qp[i] =-1;
        }
    }

    public boolean isEmpty(){
        return N == 0;
    }
    public int size(){
        return N;
    }
    public boolean contains(int k){
        return qp[k] != -1;
    }
    public void insert(int k, Key key){
        N++;
        qp[k] = N;
        pq[N] = k;
        keys[k] = key;
        swim(N);
    }

    public void change(int k, Key key){
        keys[k] = key;
        sink(k);
        swim(k);
    }
    public void delete(int k){
        int index = qp[k];
        swap(index, N--);
        swim(index);
        sink(index);
        keys[k] = null;
        qp[k] = -1;
    }

    public Key min(){
        return keys[pq[1]];
    }

    public int minIndex(){
        return pq[1];
    }
    public int delMin(){
        int indexOfMin = pq[1];
        swap(1, N--);
        sink(1);
        keys[pq[N+1]] = null;
        qp[pq[N+1]] = -1;
        pq[N+1] = -1;
        return indexOfMin;
    }

    public void sink(int n){
        while(2*n <= N){
            int j = 2*n;
            if(j < N && greater(j, j+1)) j++;
            if(!greater(n, j)) break;
            swap(n, j);
            n = j;
        }
    }
    public void swim(int n){
        while(n > 1 && greater(n/2, n)){
            swap(n/2, n);
            n = n/2;
        }
    }

    public void swap(int i, int j){
        int t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    public boolean greater(int v, int w){
        return keys[pq[v]].compareTo(keys[pq[w]]) > 0;
    }
    public static void main(String[] args) {
        String[] strings = { "it", "was", "the", "best", "of", "times", "it", "was", "the", "worst" };
        IndexMinPQ<String> pq = new IndexMinPQ<String>(strings.length);
        for (int i = 0; i < strings.length; i++) {
            pq.insert(i, strings[i]);
        }
        while (!pq.isEmpty()) {
            int i = pq.delMin();
            System.out.println(i + " " + strings[i]);
        }
    }
}
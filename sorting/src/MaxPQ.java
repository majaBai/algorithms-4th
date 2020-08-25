import edu.princeton.cs.algs4.StdIn;

import java.util.Comparator;

public class MaxPQ <Key extends Comparable<Key>>{
    private Key[] pq;
    private int N = 0;
    private Comparator<Key> c;


    @SuppressWarnings("unchecked")
    public MaxPQ (int maxN){
        //  pq[0] will not be used
        pq = (Key[]) new Comparable[maxN+1];
    }
    @SuppressWarnings("unchecked")
    public MaxPQ(int maxN, Comparator<Key> comparator){
        this.c = comparator;
        pq = (Key[]) new Comparable[maxN+1];
    }
    public boolean isEmpty(){
        return N ==0;
    }
    public int size(){
        return N;
    }
    public void insert(Key v){
        if(N == pq.length-1){
            resize(pq.length * 2);
        }
        pq[++N] = v;
        swim(N);
    }
    public Key delMax(){
        Key max = pq[1];
        swap(1, N);
        pq[N] = null;
        N-=1;
        sink(1);
        if(N>0 && N == (pq.length-1)/4 ){
            resize(pq.length/2);
        }
        return max;
    }


// helper methods
    @SuppressWarnings("unchecked")
    public void resize(int n){
        Key[] temp = (Key[]) new Comparable[n];
        for(int i = 1; i <= N; i++ ){
            temp[i] = pq[i];
        }
        pq = temp;
    }
    @SuppressWarnings("unchecked")
    public boolean less(int v, int w){
        if(c == null){
            return pq[v].compareTo(pq[w]) < 0;
        } else {
            return c.compare(pq[v], pq[w]) < 0;
        }
    }
    public void swap(int i, int j){
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }
    public void swim(int k){
        while( k > 1 && less(k/2, k)){
            swap(k/2, k);
            k = k/2;
        }
    }
    public void sink(int k){
        while(2*k <= N){
            int j = 2*k;
            if(j < N && less(j, j+1)) j++;
            if(!less(k, j)) break;
            swap(k, j);
            k = j;
        }
    }

    public static void main(String[] args){
        int M = Integer.parseInt(args[0]);
        MaxPQ<Transaction> pq = new MaxPQ<Transaction>(M+1, new Transaction.HowMuchOrder());
//        < comparator.txt
        while(StdIn.hasNextLine()){
            pq.insert(new Transaction(StdIn.readLine()));
            if(pq.size() > M){
                pq.delMax();
            }
        }
        Stack<Transaction> stack = new Stack<Transaction>();
        while(!pq.isEmpty()){
            stack.push(pq.delMax());
        }
        for(Transaction t : stack) System.out.println(t);
    }
}
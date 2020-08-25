

public class IndexMaxPQ<Item extends Comparable<Item>>{
    private int N;
    private int[] pq;
    private int[] qp;
    private Item[] keys;

    @SuppressWarnings("unchecked")
    public IndexMaxPQ(int m){
        pq = new int[m+1];
        qp = new int[m+1];
        keys = (Item[]) new Comparable[m];
        for(int i = 0; i <=m; i++){
            qp[i] = -1;
        }
    }

    public int size(){
        return N;
    }

    public boolean isEmpty(){
        return N ==0;
    }


    public void insert(int i, Item item){
        N+=1;
        keys[i] = item;
        pq[N] = i;
        qp[i] = N;
        swim(N);
    }

    public void change(int i, Item item){
        keys[i] = item;
        swim(i);
        sink(i);
    }

    public boolean contains(int i){
        return qp[i] != -1;
    }

    public void delete (int i){
//        find the index in priority queue
        int index = qp[i];
//        put i at the end of queue and shrink queue's length
        exch(index, N--);
        swim(index);
        sink(index);
        keys[i] = null;
        qp[i] = -1;
    }

    public Item max(){
        return keys[pq[1]];
    }

    public int maxIndex(){
        return pq[1];
    }

    public int delMax(){
        int max = pq[1];
        exch(1, N--);
        sink(1);
//  pq[N+1] is the key of max element which should be deleted
        qp[pq[N+1]] = -1;
        keys[pq[N+1]] = null;
        pq[N+1] = -1;
        return max;
    }

//    helper methods
    public boolean less(int i, int j){
        return keys[pq[i]].compareTo(keys[pq[j]]) < 0;
    }

    public void exch(int i, int j){
        int t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    public void swim(int k){
//        notice: less(k/2, k), not less(k, k/2)
        while(k > 1 && less(k/2, k)){
            exch(k, k/2);
            k=k/2;
        }
    }

    public void sink(int k){
//        notice: 2*k<=N
           while(2*k <= N){
               int j = 2*k;
//               notice: j < N
               if(j < N && less(j, j+1)) j++;
               if(!less(k, j)) break;
               exch(j, k);
               k = j;
           }
    }

    public static void main(String[] args){
        String[] strings = { "it", "was", "the", "best", "of", "times", "it", "was", "the", "worst" };
        IndexMaxPQ<String> pq = new IndexMaxPQ<String>(strings.length);
        for (int i = 0; i < strings.length; i++) {
            pq.insert(i, strings[i]);
        }
        while (!pq.isEmpty()) {
            int i = pq.delMax();
            System.out.println(i + " " + strings[i]);
        }
    }
}
import edu.princeton.cs.algs4.*;

public class HeapSort<Item extends Comparable<Item>> {
    public static void sort(Comparable[] pq) {
        int n = pq.length;
        // heapify phase
        for (int k = n/2; k >= 1; k--)
            sink(pq, k, n);
        // sortdown phase
        int k = n;
        while (k > 1) {
            exch(pq, 1, k--);
            sink(pq, 1, k);
        }
    }

    private static void sink(Comparable[] a, int i, int N){
        while(2 *i <= N){
            int j = 2 * i;
            if(j< N && less(a, j, j +1)) j++;
            if(!less(a, i, j)) break;
            exch(a, i, j);
            i = j;
        }
    }

    private static void exch(Comparable[] a, int i, int j){
        Comparable t = a[i-1];
        a[i-1] = a[j-1];
        a[j-1] = t;
    }
    @SuppressWarnings("unchecked")
    public static boolean isSorted(Comparable[] a){
        for(int i = 1; i < a.length; i++){
            if(a[i].compareTo(a[i-1]) < 0 ){
                return false;
            }
        }
        return true;
    }
    public static void show(Comparable[] a){
        for(int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }
    }
    @SuppressWarnings("unchecked")
    private static boolean less(Comparable[] a, int i , int j){
        return a[i-1].compareTo(a[j-1]) < 0;
    }

    public static void main(String[] args){
//    < merge.txt
            In in = new In();
            String[] a = in.readAllStrings();
            HeapSort.sort(a);
            assert isSorted(a);
            HeapSort.show(a);
    }
}
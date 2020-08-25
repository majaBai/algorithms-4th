import edu.princeton.cs.algs4.*;


import java.util.Comparator;

public class QuickSelect {
//    find the kth value in array
    public static Comparable select(Comparable[] a, int k){
        int lo = 0, hi = a.length-1;
        while(lo < hi){
            int j = partition(a, lo, hi);
            if(j == k) return a[k];
            else if(j > k) hi = j-1;
            else if(j < k) lo = j + 1;
        }
        return a[k];
    }

    @SuppressWarnings("unchecked")
    public static int partition(Comparable[] a, int lo, int hi){
        if(a[0].compareTo(a[a.length-1]) > 0) swap(a, 0, a.length-1);
        Comparable v = a[lo];
        int i = lo +1, j = hi;
        while(i <= j){
            while(less(a[i], v)) i++;
            while(less(v, a[j])) j--;
            if(i <= j){
                swap(a, i, j);
                i++;
                j--;
            }
        }
        swap(a, lo, j);
        return i;
    }

    public static void swap(Comparable[] a, int i, int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
@SuppressWarnings("unchecked")
    public static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }


    public static void main(String[] args){
//        < merge.txt
        In in = new In();
        String[] a = in.readAllStrings();
        int m = 3;
        Comparable s = QuickSelect.select(a, m);
        System.out.println("the " + m +" th value is: " + s);
        AllSort.SelectionSort(a);
        for(int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }
    }
}
import java.util.Comparator;
import edu.princeton.cs.algs4.*;

public class AllSort {
    @SuppressWarnings("unchecked")
    private static boolean less (Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }
    @SuppressWarnings("unchecked")
    private static boolean lessOrEqual(Comparable v, Comparable w){
        return v.compareTo(w) <= 0;
    }

    private static void exch(Comparable[] a, int i , int j){
        Comparable t = a[i]; a[i] = a[j]; a[j] = t;
    }

    private static void show(Comparable[] a){
        for(int i = 0; i < a.length; i++){
            System.out.println(a[i] + " ");
        }
    }

    private static boolean isSorted(Comparable[] a){
        for(int i = 0; i < a.length; i++){
            if(less(a[i], a[i - 1])) return false;
        }
        return true;
    }

    public static void SelectionSort(Comparable[] a){
        int n = a.length;
        for(int i = 0; i < n; i++){
            int min = i;
            for(int j = i+1; j < n; j++){
                if(less(a[j], a[min])) min = j;
            }
            exch(a, i, min);
        }
    }

    public static void InsertSort(Comparable[] a){
        int n = a.length;
        for(int i = 1; i < n; i++){
            for(int j = i; j > 0 && less(a[j], a[j-1]); j--){
                exch(a, j, j-1);
            }
        }
    }

    public static void ShellSort(Comparable[] a){
        int n = a.length;
        int h = 1;
        while(h < n/3) h = 3*h + 1;
        while(h >= 1){
            for(int i = h; i < n; i++){
                for(int j =i; j >= h && less(a[j], a[j-h]); j-=h){
                    exch(a, j, j-h);
                }
            }
            h = h/3;
        }
    }

    private static Comparable[] aux;
    public static void TopDownMerge(Comparable[] a){
        aux = new Comparable[a.length];
        TopDownMergeInner(a, 0, a.length-1);
    }
    private static void TopDownMergeInner(Comparable[]a, int lo, int hi){
        if(a.length <= 15){
            InsertSort(a);
        } else {
            if (lo >= hi) return;
            int mid = lo + (hi - lo) / 2;
            TopDownMergeInner(a, lo, mid);
            TopDownMergeInner(a, mid + 1, hi);
            if (!lessOrEqual(a[mid], a[mid + 1])) {
                merge(a, lo, mid, hi);
            }
        }
    }
    public static void DownTopMerge(Comparable[] a){
        int n = a.length;
        aux = new Comparable[n];
        for(int sz = 1; sz < n; sz += sz+sz){
            for(int lo = 0; lo < n-sz; lo += sz+sz){
                merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, n-1));
            }
        }
    }
    public static  void merge(Comparable[]a, int lo, int mid, int hi){
//        Comparable[] aux = new Comparable[a.length];
//        int mid = lo + (hi - lo)/2;
        int i = lo, j = mid +1;
        for(int k = lo; k <= hi; k++){
            aux[k] = a[k];
        }

        for(int t = lo; t <= hi; t++){
            if( i > mid) a[t] = aux[j++];
            else if(j > hi) a[t] = aux[i++];
            else if(less(aux[j], aux[i])) a[t] = aux[j++];
            else a[t] = aux[i++];
        }
    }

    public static void QuickSort(Comparable[] a){
        StdRandom.shuffle(a);
        qs(a, 0, a.length-1);
    }
    private static void qs(Comparable[] a, int lo, int hi){
        if(hi <= lo + 15){
            InsertSort(a);
            return;
        }
        int j = partition(a, lo, hi);
        qs(a, lo, j -1);
        qs(a, j+1, hi);
    }
    private static int partition(Comparable[] a, int lo, int hi){
        int i = lo, j = hi +1;
        Comparable v = a[lo];
        while(true){
            while(less(a[++i], v)) if(i == hi) break;
            while(less(v, a[--j])) if(j == lo) break;
            if(i>= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }



    public static void main(String[] args){
        In in = new In();
        String[] a = in.readAllStrings();
//        InsertSort(a);
//        ShellSort(a);
        int len = a.length;
//        StopWatch timer = new StopWatch();
//        merge(a,0,len-1);
//        double time = timer.elapsedTime();
//        System.out.println("time: "  + time);
//        TopDownMerge(a);
        QuickSort(a);
        assert isSorted(a);
        show(a);
    }
}
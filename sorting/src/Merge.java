import edu.princeton.cs.algs4.*;

public class Merge{
    @SuppressWarnings("unchecked")
    private static boolean less (Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    private static boolean isSorted(Comparable[] a){
        for(int i = 0; i < a.length; i++){
            if(less(a[i], a[i - 1])) return false;
        }
        return true;
    }

//    private static Comparable[] aux;
    public static void sort(Comparable[] a){
        Comparable[] aux;
        aux = new Comparable[a.length];
        TopDownMerge(a, 0, a.length-1, aux);
//        DownTopMerge(a);
    }

    public static void innerMerge(Comparable[] a, int lo, int mid, int hi,Comparable[] aux){
        int i = lo, j = mid+1;
        for(int k = lo; k <= hi; k++){
            aux[k] = a[k];
        }
//        note: the limit of k > [lo, hi]
        for(int k = lo; k <= hi; k++) {
//            if (i <= mid && (less(aux[i], aux[j]) || (j > hi))) a[k] = aux[i++];
//            else a[k] = aux[j++];
            if(i > mid) a[k] = aux[j++];
            else if(j > hi) a[k] = aux[i++];
            else if(less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }

    }
    public static void TopDownMerge(Comparable[] a, int lo, int hi, Comparable[] aux){
       if(lo >= hi) return;
       int mid = lo + (hi - lo)/2;
       TopDownMerge(a, lo, mid, aux);
       TopDownMerge(a, mid+1, hi, aux);
       innerMerge(a, lo, mid, hi, aux);
    }

//    public static void DownTopMerge(Comparable[] a){
//        int N = a.length;
//        for(int width = 1; width < N; width *=2){
//            for(int lo =0; lo < N-width; lo += width+width){
//                innerMerge(a, lo, lo+width-1, Math.min(lo+width+width-1, N-1));
//            }
//        }
//    }

    public static void show(Comparable[] a){
        for(int i = 0; i < a.length; i++){
            System.out.println(a[i] + " ");
        }
    }


    public static void main(String arg[]){
//        merge.txt
        In in = new In();
        String[] a = in.readAllStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
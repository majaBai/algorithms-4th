import edu.princeton.cs.algs4.*;

public class Quick3way<Item extends Comparable<Item>>{
@SuppressWarnings("unchecked")
    private static void sort(Comparable[] a, int lo, int hi){
        if(lo >= hi) return;
//        a[lt] is always the limit value
        int lt = lo, i = lo+1, gt = hi;
        Comparable v = a[lo];
        while(i <= gt){
            int cmp = a[i].compareTo(v);
//            a[i] < v
            if(cmp < 0){
                exch(a, i, lt);
                lt++;
                i++;
            } else if(cmp >0){
//                a[i] > v
                exch(a, i, gt);
                gt--;
            } else {
//                a[i] = v
                i++;
            }
        }
        sort(a, lo, lt - 1);
        sort(a, gt +1, hi);
    }

    private static void exch(Comparable[] a, int i, int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
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
        for(Comparable t : a){
            System.out.println(t);
        }
    }


    public static void main(String[] args){
//    < merge.txt
        In in = new In();
        String[] a = in.readAllStrings();
        int len = a.length;
        Quick3way.sort(a, 0, a.length-1);
        assert isSorted(a);
        Quick3way.show(a);
    }

}
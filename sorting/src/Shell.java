import edu.princeton.cs.algs4.*;

public class Shell{
    @SuppressWarnings("unchecked")
    public static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    public static boolean isSorted(Comparable[] a){
        for(int i = 0; i < a.length; i++){
            if(less(a[i], a[i-1])) return false;
        }
        return true;
    }

    public static void exch(Comparable[] a, int i, int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void sort(Comparable[] a){
        int n = a.length;
        int h = 1;
        while(h < n/3) h = 3*h+1;
        while(h >=1){
            for(int i = h; i < n; i++){
                for(int j = i; j >= h &&less(a[j], a[j-h]); j -=h){
                    exch(a, j, j-h);
                }
            }
            h = (h-1)/3;
        }
    }

    public static void show(Comparable[] a){
        for(int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }
    }


    public static void main(String[] arg){
        In in = new In();
        String[] a = in.readAllStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }

}
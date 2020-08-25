import java.util.Arrays;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class StaticSETofInts{
    private int[] t;

    public StaticSETofInts(int[] total){
        t = new int[total.length];
        for(int i = 0; i< total.length; i++){
            t[i] = total[i];
        }
        Arrays.sort(t);
    }

    public boolean contain(int k){
        return rank(k) != -1;
    }

   private int rank(int k){
        int lo = 0;
        int hi = t.length -1;
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(k > t[mid]) lo = mid + 1;
            else if(k < t[mid]) hi = mid -1;
            else return mid;
        }
        return -1;
   }

   public static void main(String args[]){
        In in = new In(args[0]);
        int[] wl = in.readAllInts();
        StaticSETofInts set = new StaticSETofInts(wl);
       while (!StdIn.isEmpty()){
           int key = StdIn.readInt();
           if(!set.contain(key)){
               System.out.println(key);
           }
       }
   }

}
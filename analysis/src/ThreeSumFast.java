import edu.princeton.cs.algs4.In;
import java.util.Arrays;

public class ThreeSumFast{
// O(N2lgN)
    public static int count(int[] a){
        Arrays.sort(a);
        int cnt = 0;
        for(int i = 0; i < a.length; i++){
            for(int j = i+1; j< a.length; j++){
                if(TwoSumFast.BSearch(a, -a[i]-a[j]) > j){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String agrs[]){
        for(int i = 0; i < agrs.length; i++){
            In in = new In(agrs[i]);
            int[] a = in.readAllInts();
            StopWatch watch = new StopWatch();
            int b = count(a);
            double time= watch.elapsedTime();
            System.out.println("length: "+ a.length + "  " +"time: "+ time + "  " + "result: " + b);
        }
    }

}
import edu.princeton.cs.algs4.StdRandom;
import java.text.DecimalFormat;

public class DoublingRation{
    public static double timeTrial(int n){
        int[] a = new int[n];
        int MAX = 1000000;
        for(int i = 0; i<n; i++){
            a[i] = StdRandom.uniform(-MAX, MAX);
        }
        StopWatch timer = new StopWatch();
//        O(N3)
        int cnt = ThreeSum.count(a);
        return timer.elapsedTime();
    }

    public static void main(String args[]){
        double prev = timeTrial(125);
        for(int n = 250; true; n+=n ){
            double time = timeTrial(n);
//            time/prev should be about 8
            System.out.println("length: " + n + "  " + "time: " + time +"  " + "ration: " + new DecimalFormat("0.00").format(time/prev) );
            prev = time;
        }
    }
}
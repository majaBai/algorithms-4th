import edu.princeton.cs.algs4.StdRandom;

public class DoublingTest{
    public static double timeTrial(int n){
      int[] a = new int[n];
      int MAX = 1000000;
      for(int i = 0; i<n; i++){
          a[i] = StdRandom.uniform(-MAX, MAX);
      }
      StopWatch timer = new StopWatch();
      int cnt = ThreeSum.count(a);
      return timer.elapsedTime();
    }

    public static void main(String args[]){
        for(int i = 10; i <= 10000; i*=10 ){
            double time = timeTrial(i);
            System.out.println("length: "+ i + "    " + "time: " + time + " s");
        }
    }
}
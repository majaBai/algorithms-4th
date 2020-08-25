import edu.princeton.cs.algs4.In;

public class ThreeSum{

//    O(N3)
    public static int count(int[] a){
        int n = a.length;
        int cnt = 0;
        for(int i = 0; i < n; i++){
            for (int j = i + 1; j < n; j++){
                for(int k = j+1; k<n; k++){
                    if(a[i] + a[j] + a[k] == 0){
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    public static void main(String agrs[]){
        In in = new In(agrs[0]);
        int[] a = in.readAllInts();
        StopWatch watch = new StopWatch();
        int b = count(a);
        double time= watch.elapsedTime();
        System.out.println(b + " " + time + " second");
    }

}
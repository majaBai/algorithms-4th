import java.util.Arrays;
import edu.princeton.cs.algs4.StdRandom;

public class TwoSumFast{

    public static int BSearch(int[]a, int item){
        Arrays.sort(a);
        int lp = 0;
        int rp = a.length - 1;
        while(lp <= rp){
            int mid = (rp - lp)/2 + lp;
            if(item < a[mid]) rp = mid -1;
            else if(item > a[mid]) lp = mid+1;
            else return mid;
        }
        return -1;
    }

    public static int[] generateArray(int n){
        int MAX = 10000;
        int[] a = new int[n];
        for(int i = 0; i< n; i++){
            a[i] = StdRandom.uniform(-MAX, MAX);
        }
        return a;
    }

//    public static int count(int[] a){
//        int cnt = 0;
//        for(int i = 0; i< a.length; i++){
//            for(int j = i + 1; j < a.length; j++){
//                if(a[i] + a[j] == 0){
//                    cnt++;
//                }
//            }
//        }
//        return cnt;
//    }

    public static int count(int[]a){
        int cnt = 0;
        for(int i = 0; i < a.length; i++){
            if(BSearch(a, -a[i]) > i){
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String args[]){
        for(int i = 150; i < 100000; i *= 2){
            int[] a = generateArray(i);
            StopWatch timer = new StopWatch();
            int c = count(a);
            double time = timer.elapsedTime();
            System.out.println("length: " + i + "   " + "time: "+ time + "  " + "result: " + c);
        }
    }
}
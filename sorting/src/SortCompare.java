import edu.princeton.cs.algs4.*;

public class SortCompare {
    public static double time(String alg, Comparable[] a){
        StopWatch timer = new StopWatch();
        if(alg.equals("Select")) AllSort.SelectionSort(a);
        if(alg.equals("Insertion")) AllSort.InsertSort(a);
        if(alg.equals("Shell")) AllSort.ShellSort(a);
        return timer.elapsedTime();
    }

    public static double timeRandomInput(String alg, int n, int t){
        double total = 0.0;
        Double[] a = new Double[n];
        for(int j = 0; j < t; j++){
            for(int i = 0; i < n; i++){
                a[i] = StdRandom.uniform();
            }
            total += time(alg, a);
        }
        return total;
    }

    public static void main(String arg[]){
        String agl1 = arg[0];
        String agl2 = arg[1];
//        length of array
        int n = Integer.parseInt(arg[2]);
//        amount of array
        int t = Integer.parseInt((arg[3]));
        double t1 = timeRandomInput(agl1,n, t);
        double t2 = timeRandomInput(agl2, n, t);
        System.out.printf("for %d random Doubles\n  %s is", n, agl2);
        System.out.printf(" %.1f times faster than %s\n", t2/t1, agl1);
    }


}
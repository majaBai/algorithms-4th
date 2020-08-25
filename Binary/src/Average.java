import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Average {
    public static void main(String[] args){
        double sum = 0.0;
        int cnt = 0;
//        System.out.println("here");
        while(!StdIn.isEmpty()){
//            StdOut.print("in \n");
            sum += StdIn.readDouble();
            cnt++;
        }
        double avg = sum / cnt;
        StdOut.printf("average is %.2f", avg);
    }
}

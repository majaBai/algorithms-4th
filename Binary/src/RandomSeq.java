import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.lang.Integer;

public class RandomSeq {
    public static boolean isEqual(String[] a){
        for(String t : a){
            if(t != a[0]){
                return false;
            }
        }
        return true;
    }

    public static int gcd(int p, int q){
        System.out.println("args " + p + "  "+ q);
        if(q == 0 ) return p;
        int r = p % q;
        return gcd(q, r);
    }

    public static void main(String[] args){
//      int N = Integer.parseInt(args[0]);
//      double lo = Double.parseDouble(args[1]);
//      double hi = Double.parseDouble(args[2]);
//      for(int i = 0; i < N; i++){
//          double x = StdRandom.uniform(lo, hi);
//          StdOut.printf("%.2f\n", x);
//      }

//      double b = 123.4;
//      int a =10;

//      StdOut.print("print a string");
//      StdOut.println();
//      StdOut.println("change line");
//      StdOut.printf("PI is approximately %.3f\n", Math.PI);
//      StdOut.printf("%.3f\n", b);
//      StdOut.printf("%-10d\n", a);
//      StdOut.printf("%-5s",  "hello world");
//        EX_1:
//        System.out.println(isEqual(args));
//        int f = 0;
//        int g = 1;
//        for(int i = 0; i <= 15; i++){
//            StdOut.println(f);
//            f = f + g;
//            g = f - g;
//        }
//        double t = 9.0;
//        while(Math.abs(t - 9.0/t) > .001)
//            t = (9.0/t + t) / 2.0;
//        System.out.printf("%.5f\n", t);
//
//        int sum = 0 ;
//        for(int i =1; i < 1000; i++){
//            for(int j = 0; j < i; j++){
//                sum++;
//            }
//        }
//        System.out.println(sum);
//
//        int s =0;
//        for(int i =1; i < 1000; i*=2){
//            for(int j = 0; j < 1000; j++) {
//                s++;
//            }
//        }
//        System.out.println(s);
         int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = gcd(a, b);
        System.out.println(c);
    }
}

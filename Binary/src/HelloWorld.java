
import java.util.Arrays;

public class HelloWorld {
  public static int rank(int key, int[] a) {
    int lp = 0;
    int rp = a.length - 1;
    while (lp <= rp) {
      int mid = lp + (rp - lp) / 2;
      if (key < a[mid]) {
        rp = mid - 1;
      } else if (key > a[mid]) {
        lp = mid + 1;
      } else {
        return mid;
      }
    }
    return -1;
  }

  public static int inner_rank(int key, int[] a, int lp, int rp) {
    if (lp > rp)
      return -1;
    int mid = lp + (rp - lp) / 2;
    if (key < a[mid])
      return inner_rank(key, a, lp, mid - 1);
    else if (key > a[mid])
      return inner_rank(key, a, mid + 1, rp);
    else
      return mid;
  }

  public static int getMax(int[] b) {
    int m = b[0];
    for (int i = 0; i < b.length; i++) {
      if (b[i] > m)
        m = b[i];
    }
    return m;
  }

  public static double getAverage(double[] a) {
    int n = a.length;
    double sum = 0.0;
    for (int i = 0; i < a.length; i++) {
      sum += a[i];
    }
    return sum / n;
  }

  public static double[] copyArray(double[] a) {
    int n = a.length;
    double[] r = new double[n];
    for (int i = 0; i < n; i++) {
      r[i] = a[i];
    }
    return r;
  }

  public static void reverseArray(int[] a) {
    int n = a.length;
    for (int i = 0; i < n / 2; i++) {
      int temp = a[i];
      a[i] = a[n - 1 - i];
      a[n - 1 - i] = temp;
    }
  }

  public static int[] reverse(int[] a) {
    int n = a.length;
    int[] r = new int[n];
    for (int i = 0, j = n - 1; i < n; i++, j--) {
      r[j] = a[i];
    }
    return r;
  }

  public static double averageCores(double[][] a) {
    double v = 0.0;
    int n = 0;
    for (double m[] : a) {
      for (double t : m) {
        n++;
        v += t;
      }
    }
    return v / n;
  }

  public static double abs(double x) {
    if (x < 0.0)
      x = -x;
    return x;
  }

  public static boolean isPrime(int n) {
    if (n < 2)
      return false;
    for (int i = 2; i < n; i++) {
      if (n % i == 0)
        return false;
    }
    return true;
  }

  public static String mystery(String s){
    int N = s.length();
    if( N <= 1 ) return s;
    String a = s.substring(0, N/2);
    String b = s.substring(N/2, N);
    return mystery(b) + mystery(a);
  }

  public static void main(String[] args) {
//    System.out.println("Hellp World");
//    int[] a = { 20, 35, 29, 56, 10 };
//    double[] b = { 13.5, 32.6, 35, 78 };
//    int r = inner_rank(56, a, 0, a.length - 1);
//    int m = getMax(a);
//    double v = getAverage(b);
//    double[] w = copyArray(b);
//    System.out.println("56 rank in a: " + r);
//    System.out.println("max is: " + m);
//    System.out.println("average is: " + v);
//    System.out.println("the copy of b is: " + Arrays.toString(w));
//    reverseArray(a);
//    System.out.println("reversed a is: " + Arrays.toString(a));
//    double[][] c = { { 82, 90, 91 }, { 68, 72, 64 }, { 95, 91, 89 }, { 67, 52, 60 }, { 79, 81, 85 }, };
//    double h = averageCores(c);
//    System.out.println("average core is: " + h);
//    String[] names = { "ABC", "XYZ", "zoo" };
//    String s = names[1];
//    names[1] = "cat";
//    System.out.println(s);
    System.out.println(mystery("like"));

  }
}

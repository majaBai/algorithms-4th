import edu.princeton.cs.algs4.StdIn;

public class LSD{
    public static void sort(String[] a, int w){
        int N = a.length;
        int R = 256;
        String[] aux = new String[N];

        for(int d = w- 1; d >= 0; d--){
            int[] count = new int[R+1];
            for(int i = 0; i < N; i++) count[a[i].charAt(d)+1]++;
            for(int r =0; r < R; r++) count[r+1] += count[r];
            for(int j = 0; j < N; j++) aux[count[a[j].charAt(d)]++] = a[j];
            for(int k = 0; k < N; k++) a[k] = aux[k];
        }
    }

    public static void  main(String[] args){
//        java LSD < LSD.txt
        String[] a = StdIn.readAllStrings();
        int n = a.length;
        int w = a[0].length();
        for(int i = 0; i < n; i++) sort(a, w);
        for(int j = 0; j < n; j++) System.out.print(a[j] + " ");
    }
}
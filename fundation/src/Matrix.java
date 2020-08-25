
import java.util.Arrays;
import java.util.NoSuchElementException;
public class Matrix {

//    vector dot product
    public static double dot(double[] x, double[] y) {
        double r = 0.0;
        for (int i = 0; i < x.length; i++) {
            r += x[i] * y[i];
        }
        return r;
    }

//    transpose matrix A to b:
//    write the rows of A as columns of B
//    write the columns of A as rows of B
    public static double[][] transpose(double[][] a) {
        int m = a.length, n = a[0].length;
        double[][] b = new double[n][m];
        for(int i =0; i < m; i++){
            for(int j = 0; j < n; j++){
                b[j][i] = a[i][j];
            }
        }
        return b;
    }
//    matrix-matrix product
//    columns in matrix A (m * n) =  rows in matrix B (n * p)
//    rows in result matrix (m * p) = rows in A
//    columns in result matrix = columns in B
    public static double[][] mult(double[][] a, double[][] b){
        if(a[0].length != b.length) throw new NoSuchElementException("mult: columns in matrix A should equal with rows in matrix B");
        int m = a.length, n = b[0].length;
        double[][] r = new double[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < a[0].length;k++){
                    r[i][j] += a[i][k]*b[k][j];
                }
            }
        }
        return r;
    }

//    matrix-vector product
    public static double[] mult(double[][] a, double[] x){
//        columns in matrix a = numbers of elements in x
        if(a == null || x == null || a[0].length != x.length) throw new IllegalArgumentException("wrong arguments");
        double[] r = new double[a.length];
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j< x.length; j++){
                r[i] += a[i][j]*x[j];
            }
        }
        return r;
    }

//    vector-matrix product
    public static double[] mult(double[] x, double[][] a){
//        rows in matrix a = numbers of elements in x
        if(a == null || x == null || a.length != x.length) throw new IllegalArgumentException("wrong arguments");
        double[] r = new double[a[0].length];
        for(int i = 0; i < a[0].length; i++){
            for(int j = 0; j < x.length; j++){
                r[i] += a[j][i]*x[j];
            }
        }
        return r;
    }

    public static double[] constantVector(double x, double[] a){
        for(int i =0;i < a.length;i++){
            a[i] = x*a[i];
        }
        return a;
    }

    public static double[] vectorVector(double[] a, double[] b){
        for(int i = 0; i < a.length; i++){
            a[i] = a[i] + b[i];
        }
        return a;
    }

    public static double[] vectorMatrix(double[] x, double[][] a){
        if(x.length != a.length || x == null || a == null) throw new IllegalArgumentException("wrong argument");
        double[] r = new double[a[0].length];
        for(int i = 0; i < a.length; i++){
           r = vectorVector(r, constantVector(x[i], a[i]));
        }
        return r;
    }

    public static double[] matrixVector(double[][] a, double[] y){
        if(y.length != a[0].length || y == null || a == null) throw new IllegalArgumentException("wrong argument");
        double[][] A = transpose(a);
        double[] r = new double[A[0].length];
        for(int i = 0; i < A.length; i++){
            r = vectorVector(r, constantVector(y[i], A[i]));
        }
        return r;
    }

    



    public static void main(String[] args) {
        {
        {
            double[] x = {0.2, 0.3, 0.1};
            double[][] a = {
                    {4.2, 5.3},
                    {6.4, 3.8},
                    {2.2, 8.8}
            };
//            System.out.println(Arrays.toString(mult(x, a)));
        }

            double[] x = {0.2, 0.3};
            double[][] a = {
                    {4.2, 5.3},
                    {6.4, 3.8},
                    {2.2, 8.8}
            };
            System.out.println(Arrays.toString(mult(a, x)));
        }

    }
}
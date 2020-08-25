import java.lang.Integer;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdDraw;

public class VisualAccumulator{
    private int count;
    private double total;

    public VisualAccumulator(int trials, double max){
        StdDraw.setXscale(0, trials);
        StdDraw.setYscale(0, max);
        StdDraw.setPenRadius(.005);

    }

    public void addData(double val){
        total += val;
        count++;
        StdDraw.setPenColor(StdDraw.DARK_GRAY);
        StdDraw.point(count, val);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.point(count, total/count);
    }

    public double mean(){
        return total/count;
    }

    public String toString(){
        return "mean (" + count + "values) :" + String.format("%7.5f", mean());
    }

    public static void main(String args[]){
        int T = Integer.parseInt(args[0]);
        VisualAccumulator a = new VisualAccumulator(T, 1.0);
        for(int i = 0; i< T; i++){
            a.addData(StdRandom.uniform());
        }
        System.out.print(a);
    }
}
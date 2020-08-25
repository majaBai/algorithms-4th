import java.lang.Integer;
import edu.princeton.cs.algs4.StdRandom;

public class Accumulator{
    private int count;
    private double total;

    public void addData(double val){
        total += val;
        count++;
    }

    public double mean(){
        return total/count;
    }

    public String toString(){
        return "mean (" + count + "values) :" + String.format("%7.5f", mean());
    }

    public static void main(String args[]){
        int N = Integer.parseInt(args[0]);
        Accumulator a = new Accumulator();
        for(int i = 0; i < N; i++){
            a.addData(StdRandom.uniform(10));
        }
        System.out.println(a);

    }

}
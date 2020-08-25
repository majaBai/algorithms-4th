
public class SparseVector{
    private ST<Integer, Double> st;
    public SparseVector(){
        st = new ST<Integer, Double>();
    }

    public int size(){
        return st.size();
    }

    public void put(int i, double x){
        st.put(i, x);
    }

    public double get(int i){
        if(!st.contains(i)) return 0.0;
        else return st.get(i);
    }

    public double dot(double[] that){
        double sum = 0.0;
        for(int i : st.keys()){
            sum+=that[i]*this.get(i);
        }
        return sum;
    }

    public static void main(String[] args){
        int N = 5;
        SparseVector[] a = new SparseVector[N];
        double[] x = {0.05, 0.04, 0.36, 0.37, 0.19};
        double[] b = new double[N];
        for(int i = 0; i < N; i++){
            a[i] = new SparseVector();
        }
        a[0].put(1, 0.90);
        a[1].put(2, 0.36);
        a[1].put(3, 0.36);
        a[1].put(4, 0.18);
        a[2].put(3, 0.90);
        a[3].put(0, 0.90);
        a[4].put(0, 0.47);
        a[4].put(2, 0.47);
        for(int i = 0; i < N; i++){
            b[i] = a[i].dot(x);
            System.out.println("b[" + i +"]:" + b[i]);
        }
    }
}
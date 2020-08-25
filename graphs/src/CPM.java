import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
public class CPM{
    public static void main(String[] args){
        int N = StdIn.readInt();
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(2*N+2);
        int s = 2*N, t = 2*N+1;
        for(int i = 0; i < N; i++){
            String[] a = StdIn.readLine().split("\\s+");
            System.out.print(a[0]);
            double duration = Double.parseDouble(a[0]);
            G.addEdge(new DirectedEdge(i, i + N, duration));
            G.addEdge(new DirectedEdge(s, i, 0.0));
            G.addEdge(new DirectedEdge(i+N, t, 0.0));
            for(int j = 1; j < a.length; j++){
                int successor = Integer.parseInt(a[j]);
                G.addEdge(new DirectedEdge(i+N, successor, 0.0));
            }
        }

        AcyclicLP lp = new AcyclicLP(G, s);
        System.out.println("start time: ");
        for(int i =0; i < N; i++){
            System.out.format("%4d: %5.1f\n", i, lp.distTo(i));
        }
        System.out.println("");
        System.out.format("finish time: %5.1f\n", lp.distTo(t));
    }
}
import edu.princeton.cs.algs4.In;

public class DijkstraSP{
    private DirectedEdge[] edgeTo;
    private double[] distTo;
    private IndexMinPQ<Double> pq;

    public DijkstraSP(EdgeWeightedDigraph G, int s){
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];
        pq = new IndexMinPQ<Double>(G.V());
        for(int v = 0; v < G.V(); v++){
            distTo[v] = Double.POSITIVE_INFINITY;
        }
         distTo[s] = 0.0;
        pq.insert(s, 0.0);
        while(!pq.isEmpty()){
            relax(G, pq.delMin());
        }
    }

    private void relax(EdgeWeightedDigraph g, int v){
        for(DirectedEdge e : g.adj(v)){
            int w = e.to();
            if(distTo[w] > distTo[v] + e.weight()){
                distTo[w] = distTo[v]+e.weight();
                edgeTo[w] = e;
                if(pq.contains(w)) pq.change(w, distTo[w]);
                else pq.insert(w, distTo[w]);
            }
        }
    }

    public double distTo(int v){
//        if(!hasPathto(v)) throw new IllegalArgumentException("has no path to "+v);
        return distTo[v];
    }

    public boolean hasPathto(int v){
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    public Iterable<DirectedEdge> pathTo(int v){
        if(!hasPathto(v)) return null;
        Stack<DirectedEdge> path = new Stack<DirectedEdge>();
        for(DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]){
            path.push(e);

        }
        return path;
    }

    public static void main(String[] args){
//        java DijkstraSP tinyEWD.txt 0
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(new In(args[0]));
        int s = Integer.parseInt(args[1]);
        DijkstraSP sp = new DijkstraSP(G, s);
        for(int t = 0; t < G.V(); t++){
            System.out.print(s + " to " + t);
            System.out.format(" (%4.2f): ",sp.distTo(t));
            if(sp.hasPathto(t)){
                for(DirectedEdge e : sp.pathTo(t)){
                    System.out.print(e +" ");
                }
            }
            System.out.println(" ");
        }
    }
}
import edu.princeton.cs.algs4.In;

public class PrimMST{
    private Edge[] edgeTo;
    private double[] distTo;
    private boolean[] marked;
    private IndexMinPQ<Double> pq;

    public PrimMST(EdgeWeightedGraph G){
        edgeTo = new Edge[G.V()];
        distTo = new double[G.V()];
        marked = new boolean[G.V()];
        for(int i = 0; i < G.V(); i++){
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        pq = new IndexMinPQ<Double>(G.V());

        distTo[0] = 0.0;
        pq.insert(0, 0.0);
        while(!pq.isEmpty()){
            visit(G, pq.delMin());
        }
    }

    private void visit(EdgeWeightedGraph  G, int v){
        marked[v] = true;
        for(Edge e : G.adj(v)){
            int w = e.other(v);
            if(marked[w]) continue;
            if(e.weight() < distTo[w]){
                edgeTo[w] = e;
                distTo[w] = e.weight();
                if(pq.contains(w)) pq.change(w, distTo[w]);
                else pq.insert(w, distTo[w]);
            }
        }
    }

    public Iterable<Edge> edges(){
        Bag<Edge> mst = new Bag<Edge>();
        for(int v = 1; v < edgeTo.length; v++){
            Edge e = edgeTo[v];
            if(e != null){
                mst.add(e);
            }
        }
        return mst;
    }

    public double weight(){
        double weight = 0.0;
        for(Edge e : edges()){
            weight += e.weight();
        }
        return weight;
    }

    public static void main(String args[]){
//        java PrimMST tinyEWG.txt
        In in = new In(args[0]);
        EdgeWeightedGraph G = new EdgeWeightedGraph(in);
        PrimMST mst = new PrimMST(G);
        for(Edge e : mst.edges()){
            System.out.println(e);
        }
        System.out.println("total weight of minimum spanning tree: " + mst.weight());
    }
}
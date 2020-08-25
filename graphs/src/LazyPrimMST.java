import edu.princeton.cs.algs4.In;

public class LazyPrimMST{
    private boolean[] marked;
    private Queue<Edge> mst;
    private double weight;
    private MinPQ<Edge> pq;

    public LazyPrimMST(EdgeWeightedGraph G){
        pq = new MinPQ<Edge>();
        marked = new boolean[G.V()];
        mst = new Queue<Edge>();
        visit(G, 0);
        while(!pq.isEmpty()){
            Edge e = pq.delMin();
            int v = e.either();
            int w = e.other(v);
            if(marked[v] && marked[w]) continue;
            mst.enqueue(e);
            weight += e.weight();
            if(!marked[v]) visit(G, v);
            if(!marked[w]) visit(G, w);
        }
    }

    private void visit(EdgeWeightedGraph G, int v){
        marked[v] = true;
        for(Edge e : G.adj(v)){
            if(!marked[e.other(v)]) pq.insert(e);
        }
    }

    public Iterable<Edge> edges(){
        return mst;
    }

    public double weight(){
        return weight;
    }

    public static void main(String args[]){
//        java lazyPrimMST tinyEWG.txt
        In in = new In(args[0]);
        EdgeWeightedGraph G = new EdgeWeightedGraph(in);
        LazyPrimMST mst = new LazyPrimMST(G);
        for(Edge e : mst.edges()){
            System.out.println(e);
        }
        System.out.println("total weight of minimum spanning tree: " + mst.weight());
    }

}
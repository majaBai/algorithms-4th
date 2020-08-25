import edu.princeton.cs.algs4.In;

public class KruskalMST{
    private Queue<Edge> mst;
    public KruskalMST(EdgeWeightedGraph G){
        mst = new Queue<Edge>();
        MinPQ<Edge> pq = new MinPQ<Edge>();
        for(Edge e : G.edges()){
            pq.insert(e);
        }
        WeightedUF uf = new WeightedUF(G.V());
        while(!pq.isEmpty() && mst.size() < G.V()-1){
            Edge e = pq.delMin();
            int v = e.either(), w = e.other(v);
            if(uf.connected(v, w)) continue;
            uf.union(v, w);
            mst.enqueue(e);
        }
    }

    public Iterable<Edge> edges(){
        return mst;
    }

    public double weight(){
        double weight = 0.0;
        for(Edge e : edges()){
            weight += e.weight();
        }
        return weight;
    }

    public static void main(String[] args){
        //        java KruskalMST tinyEWG.txt
        In in = new In(args[0]);
        EdgeWeightedGraph G = new EdgeWeightedGraph(in);
        KruskalMST mst = new KruskalMST(G);
        for(Edge e : mst.edges()){
            System.out.println(e);
        }
        System.out.println("total weight of minimum spanning tree: " + mst.weight());
    }
}
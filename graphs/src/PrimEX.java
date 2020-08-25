
public class PrimEX{
    private Edge[] edgeTo;
    private double[] distTo;
    private boolean[] marked;
    private IndexMinPQ<Double> pq;

    public PrimEX(EdgeWeightedGraph G){
      edgeTo = new Edge[G.V()];
      distTo = new double[G.V()];
      for(int v = 0; v < G.V(); v++){
          distTo[v] = Double.POSITIVE_INFINITY;
      }
      marked = new boolean[G.V()];
      pq = new IndexMinPQ<Double>(G.V());
      distTo[0] = 0.0;
      pq.insert(0, 0.0);
      while(!pq.isEmpty()){
          visit(G, pq.delMin());
      }
    }

    private void visit(EdgeWeightedGraph g, int v){
       marked[v] = true;
       for(Edge e : g.adj(v)){
           int w = e.other(v);
           if(marked[w]) continue;
           if(e.weight()< distTo[w]){
               edgeTo[w] = e;
               distTo[w] = e.weight();
               if(pq.contains(w)) pq.change(w, distTo[w]);
               else pq.insert(w, distTo[w]);
           }
       }
    }


}

import edu.princeton.cs.algs4.In;

public class AcyclicSP{
    private DirectedEdge[] edgeTo;
    private double[] distTo;

    public AcyclicSP(EdgeWeightedDigraph G, int s){
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];
        for(int v = 0; v < G.V(); v++){
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;

//        top is the topological order of G
        TopologicalX top = new TopologicalX(G);
        for(int v : top.order()){
            relax(G, v);
        }
    }

//    relax a vertex
    private void relax(EdgeWeightedDigraph G, int v){
        for(DirectedEdge e : G.adj(v)){
            int w = e.to();
            if(distTo[w] > distTo[v] + e.weight()){
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
            }
        }
    }

    public double distTo(int v){
        return distTo[v];
    }

    public boolean hasPathTo(int v){
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    public Iterable<DirectedEdge> pathTo(int v){
        if(!hasPathTo(v)) return null;
        Stack<DirectedEdge> path = new Stack<DirectedEdge>();
        for(DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]){
            path.push(e);
        }
        return path;
    }

    public static void main(String[] args){
//        java AcyclicSP tinyEWDAG.txt 5
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(new In(args[0]));
        int s = Integer.parseInt(args[1]);
        AcyclicSP sp = new AcyclicSP(G, s);
        for(int t = 0; t < G.V(); t++){
            System.out.print(s + " to " + t);
            System.out.format(" (%4.2f): ",sp.distTo(t));
            if(sp.hasPathTo(t)){
                for(DirectedEdge e : sp.pathTo(t)){
                    System.out.print(e +" ");
                }
            }
            System.out.println(" ");
        }
    }
}
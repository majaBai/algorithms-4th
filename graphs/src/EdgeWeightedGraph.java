import edu.princeton.cs.algs4.In;

public class EdgeWeightedGraph {
    private int V;
    private int E;
    private Bag<Edge>[] adj;

    @SuppressWarnings("unchecked")
    public EdgeWeightedGraph(int v){
        this.V =  v;
        this.E = 0;
        adj = (Bag<Edge>[]) new Bag[V];
        for(int w = 0; w < V; w++){
            adj[w] = new Bag<Edge>();
        }
    }

//    read a graph file
    public EdgeWeightedGraph(In in){
        this(in.readInt());
        int E = in.readInt();
        for(int i = 0; i < E; i++){
            int v = in.readInt();
            int w = in.readInt();
            double weight = in.readDouble();
            Edge e = new Edge(v, w, weight);
            addEdge(e);
        }
    }

    public int V(){
        return V;
    }

    public int E(){
        return E;
    }

    public void addEdge(Edge e){
        int v = e.either();
        int w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    public Iterable<Edge> adj(int v){
        return adj[v];
    }

    public Iterable<Edge> edges(){
        Bag<Edge> b = new Bag<Edge>();
        for(int v = 0; v < V; v++){
            for(Edge e : adj[v]){
                if(e.other(v) > v) b.add(e);
            }
        }
        return b;
    }

    public String toString(){
        String s = V + " vertexes, " + E + " edges" + "\n";
        for(int w = 0; w < V; w++) {
            s+=w + ": ";
            for(Edge e : adj(w)){
                s+=e + " ";
            }
            s+="\n";
        }
        return s;
    }

    public static void main(String[] args){
//     % java EdgeWeightedGraph tinyEWG.txt
        In in = new In(args[0]);
        EdgeWeightedGraph EWG = new EdgeWeightedGraph(in);
//        the next line will call EWG.toString() automatically;
        System.out.print(EWG);
    }
}
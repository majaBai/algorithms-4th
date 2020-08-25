import edu.princeton.cs.algs4.In;
public class EdgeWeightedDigraph{
    private int V;
    private int E;
    private Bag<DirectedEdge>[] adj;
    private int[] indegree;

    @SuppressWarnings("unchecked")
    public EdgeWeightedDigraph(int v){
        this.V = v;
        this.E = 0;
        adj = (Bag<DirectedEdge>[]) new Bag[V];
        indegree = new int[V];
        for(int w =0; w < V; w++){
            adj[w] = new Bag<DirectedEdge>();
        }
    }

    public EdgeWeightedDigraph(In in){
        this(in.readInt());
        int E = in.readInt();
        for(int i = 0; i < E; i++){
             int v = in.readInt();
             int w = in.readInt();
             double weight = in.readDouble();
             DirectedEdge e = new DirectedEdge(v, w, weight);
             addEdge(e);
        }
    }

    public int V(){
        return V;
    }
    public int E(){
        return E;
    }
    public void addEdge(DirectedEdge e){
        int w = e.to();
        int v = e.from();
        adj[v].add(e);
        indegree[w]++;
        E++;
    }
    public Iterable<DirectedEdge> adj(int v){
        return adj[v];
    }
    public Iterable<DirectedEdge> edges(){
        Bag<DirectedEdge> bag = new Bag<DirectedEdge>();
        for(int v = 0; v < V; v++){
            for(DirectedEdge e : adj[v]){
                bag.add(e);
            }
        }
        return bag;
    }

    public int outdegree(int v){
        return adj[v].size();
    }

    public int indegree(int v){
        return indegree[v];
    }

    public String toString(){
        String s = V + " vertexes, " + E + " edges" + "\n";
        for(int w = 0; w < V; w++){
            s+= w +": ";
            for(DirectedEdge e : adj[w]){
                s+=e +" ";
            }
            s+="\n";
        }
        return s;
    }

    public static void main(String[] args){
//        % java EdgeWeightedDigraph tinyEWG.txt
        In in = new In(args[0]);
        EdgeWeightedDigraph DWG = new EdgeWeightedDigraph(in);
        System.out.print(DWG);
    }
}
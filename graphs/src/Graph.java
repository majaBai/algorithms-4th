import edu.princeton.cs.algs4.In;

import java.util.Iterator;

public class Graph{
    private int V;
    private int E;
    private Bag<Integer>[] adj;
//    UF is for the practice  4.1.8
    private WeightedUF UF;

    @SuppressWarnings("unchecked")
    public Graph(int V){
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for(int i = 0; i < V; i++){
//            each vertex has a Bag, in which all connected vertex are saved
            adj[i] = new Bag<Integer>();
        }
        UF = new WeightedUF(V);
    }

    // read a graph file
    public Graph(In in){
        this(in.readInt());
        int E = in.readInt();
        for(int i = 0; i < E; i++){
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
            UF.union(v, w);
        }
    }
    public int V(){
        return V;
    }
    public int E(){
        return E;
    }

    public void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    public int degree(int v){
        int d = 0;
        for(int w : adj(v)) d++;
        return d;
    }
    public String toString(){
        String s = V + " vertices, " + E + " edges\n";
        for(int v = 0; v < V; v++){
            s+= v + ": ";
            for(int w : this.adj(v)){
                s += w + " ";
            }
            s+="\n";
        }
        return s;
    }

    public boolean connected(int v, int w){
        return UF.connected(v, w);
    }

    public int vertexesConnectedWith(int k){
        return UF.vertexesWith(k);
    }
    public static void main(String[] args){
//        java Graph tinyG.txt
        In in = new In(args[0]);
        Graph g = new Graph(in);
        for(int i= 0 ; i <= 12; i++){
            System.out.print("vertexes connected whit " + i + ": ");
            for(int v: g.adj(i)){
                System.out.print(v + " ");
            }
            System.out.println(" ");
        }
    }
}
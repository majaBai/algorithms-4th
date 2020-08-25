import edu.princeton.cs.algs4.In;

public class Digraph{
    private int V;
    private int E;
    private Bag<Integer>[] adj;
    private int[] indegree;        // indegree[v] = indegree of vertex v

    @SuppressWarnings("unchecked")
    public Digraph(int v){
        this.V = v;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        indegree = new int[V];
        for(int w = 0; w < V; w++){
            adj[w] = new Bag<Integer>();
        }
    }

    public Digraph(In in){
        this(in.readInt());
        int E = in.readInt();
        for(int i = 0; i < E; i++){
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
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
        indegree[w]++;
        E++;
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    public Digraph reverse(){
      Digraph R = new Digraph(V);
      for(int v = 0; v < V; v++){
          for(int w : adj(v)){
              R.addEdge(w, v);
          }
      }
      return R;
    }

    public int degree(int v){
        return indegree[v];
    }

    public String toString(){
        String s = V + " vertexes, " + E + " edges" + "\n";
        for(int i = 0; i < V; i++) {
            s+= i + ": ";
            for(int w : adj(i)){
                s+= w + " ";
            }
            s+= "\n";
        }
        return s;
    }

    public static void main(String[] args){
//        java Digraph tinyG.txt
        In in = new In(args[0]);
        Digraph g = new Digraph(in);
        for(int i= 0 ; i <= 12; i++){
            System.out.print("the edges from " + i + ": ");
            for(int v: g.adj(i)){
                System.out.print(v + " ");
            }
            System.out.println(" ");
        }
    }

}
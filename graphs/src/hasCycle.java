import edu.princeton.cs.algs4.In;

public class hasCycle{
    private boolean[] marked;
    private boolean hasCycle;

    public hasCycle(Graph G){
        marked = new boolean[G.V()];
        for(int s = 0; s < G.V(); s++){
            if(!marked[s]){
                dfs(G, s, s);
            }
        }
    }

    private void dfs(Graph g, int v, int u){
        marked[v] = true;
        for(int w : g.adj(v)){
            if(!marked[w]){
                dfs(g, w, v);
            } else if(w != u){
                hasCycle = true;
            }
        }
    }

    public boolean hasCycle(){
        return hasCycle;
    }

    public static void main(String[] args){
        Graph G = new Graph(new In(args[0]));
        hasCycle c = new hasCycle(G);
        System.out.print(c.hasCycle);
    }
}
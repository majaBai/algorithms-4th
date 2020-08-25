
public class Transitive{
    private DirectedDFS[] all;
    public Transitive(Digraph G){
        all = new DirectedDFS[G.V()];
        for(int v =0; v < G.V(); v++){
            all[v] = new DirectedDFS(G, v);
        }
    }

    public boolean reachable(int v, int w){
        return all[v].marked(w);
    }
}
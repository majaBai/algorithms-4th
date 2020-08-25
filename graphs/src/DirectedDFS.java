import edu.princeton.cs.algs4.In;

public class DirectedDFS {
    private boolean[] marked;

    public DirectedDFS(Digraph G, int s){
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    public DirectedDFS(Digraph G, Iterable<Integer> source){
        marked = new boolean[G.V()];
        for(int s : source){
            if(!marked[s]) dfs(G, s);
        }
    }

    public void dfs(Digraph g, int s){
        marked[s] = true;
        for(int w : g.adj(s)){
            if(!marked[w]) dfs(g, w);
        }
    }

    public boolean marked(int v){
        return marked[v];
    }

    public static void main(String[] args){
//        which vertexes can be reachable from source ( source >= one vertex )
//        % java DirectedDFS tinyDG.txt 1 2 6
        Digraph G = new Digraph(new In(args[0]));
        Bag<Integer> source = new Bag<Integer>();
        for(int i = 1; i < args.length; i++){
            source.add(Integer.parseInt(args[i]));
        }
        DirectedDFS reachable = new DirectedDFS(G, source);
        System.out.println("the following vertexes are reachable: ");
        for(int v = 0; v< G.V(); v++){
            if(reachable.marked(v)) System.out.print(v + " ");
        }
    }
}

import edu.princeton.cs.algs4.In;

// the goal of DepthFirstPaths: find the path from the start vertex to arbitrary vertex
public class DepthFirstPaths{
//    during search, if meet this vertex
    private boolean[] marked;
//    document the last vertexes to goal vertex
    private int[] edgeTo;
    private int S;

    public DepthFirstPaths(Graph G, int s){
        this.S = s;
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        dfs(G, s);
    }

    public DepthFirstPaths(Digraph G, int s){
        this.S = s;
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        dfs(G, s);
    }

    public void dfs(Graph g, int v){
        marked[v] = true;
        for(int w: g.adj(v)){
            if(!marked[w]){
                edgeTo[w] = v;
                dfs(g, w);
            }
        }
    }
    public void dfs(Digraph g, int v){
        marked[v] = true;
        for(int w: g.adj(v)){
            if(!marked[w]){
                edgeTo[w] = v;
                dfs(g, w);
            }
        }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v){
        if(!hasPathTo(v))return null;
        Stack<Integer> path = new Stack<Integer>();
//        from goal vertexes back to its parents vertexes until meet the start vertex
        for(int k = v; k !=S; k = edgeTo[k]){
            path.push(k);
        }
        path.push(S);
        return path;
    }
    public static void main(String[] args){
//        % java DepthFirstPaths tinyCG.txt 0
        Graph G = new Graph(new In(args[0]));
        int s = Integer.parseInt(args[1]);
        DepthFirstPaths search = new DepthFirstPaths(G, s);
        System.out.println(G.V());
        for(int v = 0; v < G.V(); v++){
            System.out.print(s + " to " + v + ": ");
            if(search.hasPathTo(v)){
                for(int x : search.pathTo(v)){
                    if(x == s) System.out.print(x);
                    else System.out.print(" - " + x);
                }
            }
            System.out.println(" ");
        }
    }
}
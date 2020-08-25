import edu.princeton.cs.algs4.In;

public class DepthFirstSearch{
    private boolean[] marked;
    private int count;

    public DepthFirstSearch(Graph G, int s){
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    public void dfs(Graph g, int s){
        marked[s] = true;
        count++;
        for(int v : g.adj(s)){
            if(!isMarked(v)) dfs(g, v);
        }
    }

    public boolean isMarked(int k){
        return marked[k];
    }

    public int count(){
        return count;
    }

    public static void main(String[] args){
//        % java DepthFirstSearch tinyG.txt 9
        Graph g = new Graph(new In(args[0]));
        int s = Integer.parseInt(args[1]);
        DepthFirstSearch DFS = new DepthFirstSearch(g, s);
        System.out.print("vertexes connected with " + s +": ");
        for(int i = 0; i < g.V(); i++){
            if(DFS.isMarked(i)) System.out.print(i + " ");
        }
        System.out.println(" ");
        System.out.println("total: " + DFS.count());
    }
}
import edu.princeton.cs.algs4.In;

public class CC{
   private int count;
   private int[] id;
   private boolean[] marked;

    public CC(Graph G) {
        id = new int[G.V()];
        marked = new boolean[G.V()];
        for(int i = 0; i < G.V(); i++){
            if(!marked[i]){
                dfs(G, i);
                count++;
            }
        }
    }
    public void dfs(Graph g, int v){
        marked[v] = true;
        id[v] = count;
        for(int w : g.adj(v)){
            if(!marked[w]){
                dfs(g, w);
            }
        }
    }

    public int count(){
        return count;
    }

    public int id(int v){
        return id[v];
    }

    public boolean connected(int v, int w){
        return id[v] == id[w];
    }
@SuppressWarnings("unchecked")
    public static void main(String[] args){
//        % java CC tinyG.txt
        Graph G = new Graph(new In(args[0]));
        CC cc = new CC(G);
        int M = cc.count();
        System.out.println(M + " components");

        Queue<Integer>[] components = (Queue<Integer>[]) new Queue[M];
        for(int j = 0; j < M; j++){
            components[j] = new Queue<Integer>();
        }
            //      put vertexes into correct connected-component
        for(int v = 0; v < G.V(); v++){
            components[cc.id(v)].enqueue(v);
        }
        // print all components and concrete elements
        for(int i = 0; i < M; i++){
            for(int w : components[i]){
                System.out.print(w + " ");
            }
            System.out.println(" ");
        }
    }


}
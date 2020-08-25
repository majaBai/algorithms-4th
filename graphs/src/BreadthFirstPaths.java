import edu.princeton.cs.algs4.In;

public class BreadthFirstPaths{
    private static int INFINITY = Integer.MAX_VALUE;
    private boolean[] marked;
    private int[] edgeTo;
    private int S;
//    distTo[v] = number of edges shortest s-v path
    private int[] distTo;

    public BreadthFirstPaths(Graph G, int s){
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        distTo = new int[G.V()];
        this.S = s;
        bfs(G, s);
    }
    public BreadthFirstPaths(Graph G, Iterable<Integer> sources){
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        distTo = new int[G.V()];
        for(int v = 0; v < G.V(); v++){
            distTo[v] = INFINITY;
            bfs(G, sources);
        }
    }


    public BreadthFirstPaths(Digraph G, int s){
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        distTo = new int[G.V()];
        for(int v = 0; v < G.V(); v++){
            distTo[v] = INFINITY;
        }
        this.S = s;
        bfs(G, s);
    }
    public BreadthFirstPaths(Digraph G, Iterable<Integer> sources){
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        distTo = new int[G.V()];
        for(int v = 0; v < G.V(); v++){
            distTo[v] = INFINITY;
            bfs(G, sources);
        }
    }


    public void bfs(Digraph g, int s){
        Queue<Integer> q = new Queue<Integer>();
        marked[s] = true;
        distTo[s] = 0;
        q.enqueue(s);
        while(!q.isEmpty()){
            int v = q.dequeue();
            for(int w: g.adj(v)){
                if(!marked[w]){
                    marked[w] = true;
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] +1;
                    q.enqueue(w);
                }
            }
        }
    }

    public void bfs(Digraph g, Iterable<Integer> sources){
        Queue<Integer> q = new Queue<Integer>();
        for(int s : sources){
            marked[s] = true;
            distTo[s] = 0;
            q.enqueue(s);
        }
        while(!q.isEmpty()){
            int v = q.dequeue();
            for(int w : g.adj(v)){
                if(!marked[w]){
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    marked[w] = true;
                    q.enqueue(w);
                }
            }
        }
    }



    public void bfs(Graph g, Iterable<Integer> sources){
        Queue<Integer> q = new Queue<Integer>();
        for(int s : sources){
            marked[s] = true;
            distTo[s] = 0;
            q.enqueue(s);
        }
        while(!q.isEmpty()){
            int v = q.dequeue();
            for(int w : g.adj(v)){
                if(!marked[w]){
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    marked[w] = true;
                    q.enqueue(w);
                }
            }
        }
    }

    public void bfs(Graph g, int s){
       Queue<Integer> q = new Queue<Integer>();
       for(int v = 0; v < g.V(); v++){
           distTo[v] = INFINITY;
       }
       marked[s] = true;
       distTo[s] = 0;
       q.enqueue(s);
       while(!q.isEmpty()){
           int v = q.dequeue();
           for(int w: g.adj(v)){
               if(!marked[w]){
                   marked[w] = true;
                   edgeTo[w] = v;
                   distTo[w] = distTo[v] +1;
                   q.enqueue(w);
               }
           }
       }
    }


    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v){
        if(!marked[v]) return null;
        Stack<Integer> path = new Stack<Integer>();
        for(int w = v; w != S; w = edgeTo[w]){
            path.push(w);
        }
        path.push(S);
        return path;
    }



    public static void main(String[] args){
//        java BreadthFirstPaths tinyCG.txt 0
        Graph G = new Graph(new In(args[0]));
        int s = Integer.parseInt(args[1]);
        BreadthFirstPaths search = new BreadthFirstPaths(G, s);
        for(int i = 0; i < G.V(); i++){
            System.out.print(s+" to " + i + ": ");
            if(search.hasPathTo(i)){
                for(int p : search.pathTo(i)){
                    if(p == s) System.out.print(p);
                    else System.out.print("-" + p);
                }
            }
            System.out.println(" ");
        }
    }

}
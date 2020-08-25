import edu.princeton.cs.algs4.In;

public class Search{
    private Graph G;
    private int S;

    public Search(Graph g, int s){
        this.G = g;
        this.S = s;
    }

//    check: is v connected with S
    public boolean marked(int v){
        return G.connected(S, v);
    }

//    the count of vertexes, which connect with S
    public int count(){
        return G.vertexesConnectedWith(S);
    }

    public static void main(String[] args){
//        % java Search tinyG.txt 0
        Graph G = new Graph(new In(args[0]));
        int s = Integer.parseInt(args[1]);
        Search search = new Search(G, s);
        for(int i = 0; i < G.V(); i++){
            if(search.marked(i)){
                System.out.print(i + " ");
            }
        }
        System.out.println(" ");
        System.out.println("the connected vertexes count: " + search.count());
        if(search.count() != G.V()){
            System.out.println("not connected");
        } else System.out.println("connected");
    }
}
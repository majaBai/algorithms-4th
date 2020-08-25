import edu.princeton.cs.algs4.In;

public class Topological{
    private Iterable<Integer> order;

    public Topological(Digraph G){
        DirectedCycle cycleFinder = new DirectedCycle(G);
        if(!cycleFinder.hasCycle()){
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversePost();
        }
    }

    public Iterable<Integer> order(){
        return order;
    }

    public boolean isDAG(){
        return order != null;
    }

    public static void main(String[] args){
//        % java Topological jobs.txt "/"
        String filename = args[0];
        String separator = args[1];
        SymbolGraph sg = new SymbolGraph(filename, separator);
        Topological topo = new Topological(sg.DG());
        for(int v : topo.order()){
            System.out.println(sg.name(v));
        }
    }
}
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;

public class SymbolGraph{
//    can deal with Graph and Digraph
    private LinearProbingHashST<String, Integer> st;
    private String[] keys;
    private Graph G;
    private Digraph DG;

    public SymbolGraph(String stream, String sp){
        st = new LinearProbingHashST<String, Integer>();
        In in = new In(stream);
        while(in.hasNextLine()){
            String[] a = in.readLine().split(sp);
            for(int i = 0; i < a.length; i++){
                if(!st.contains(a[i])){
                    st.put(a[i], st.size());
                }
            }
        }
        keys = new String[st.size()];
        for(String name : st.keys()){
            keys[st.get(name)] = name;
        }

//      SymbolGraph supports Graph and Digraph
        G = new Graph(st.size());
        DG = new Digraph(st.size());
        in = new In(stream);
        while(in.hasNextLine()){
            String[] a = in.readLine().split(sp);
            int v = st.get(a[0]);
            for(int i = 1; i < a.length; i++){
                G.addEdge(v, st.get(a[i]));
                DG.addEdge(v, st.get(a[i]));
            }
        }
    }

    public boolean contains(String s){
        return st.contains(s);
    }

    public int index(String s) {
        return st.get(s);
    }

    public String name(int v){
        return keys[v];
    }

    public Graph G(){
        return G;
    }

    public Digraph DG(){ return DG;}

    public static void main(String[] args){
//       % java SymbolGraph moviesG.txt "/"
//        Reiner, Carl
        String filename = args[0];
        String delim = args[1];
        SymbolGraph sg = new SymbolGraph(filename, delim);
        Graph G = sg.G();
        while(StdIn.hasNextLine()){
            String source = StdIn.readLine();
            for(int w : G.adj(sg.index(source))){
                System.out.println("  "+ sg.name(w));
            }
        }
    }
}
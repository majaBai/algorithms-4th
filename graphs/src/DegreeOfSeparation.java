import edu.princeton.cs.algs4.StdIn;

public class DegreeOfSeparation{
    public static void main(String[] args){
//        % java DegreeOfSeparation routes.txt " " JFK
        SymbolGraph sg = new SymbolGraph(args[0], args[1]);
        Graph G = sg.G();

        String source = args[2];
        if(!sg.contains(source)){
            System.out.print(source + "not in database");
            return;
        }
        int s = sg.index(source);
        BreadthFirstPaths bfs = new BreadthFirstPaths(G, s);
        while(!StdIn.isEmpty()){
            String sink = StdIn.readLine();
            if(sg.contains(sink)){
                int t = sg.index(sink);
                if(bfs.hasPathTo(t)){
                    for(int v : bfs.pathTo(t)){
                        System.out.println("  " + sg.name(v));
                    }
                } else System.out.println(sink + " is not connected");
            } else {
                System.out.println(sink + " not in database");
            }
        }
    }
}
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.In;

public class Multiway{
    public static void merge(In[] streams){
        int N = streams.length;
        IndexMinPQ<String> pq = new IndexMinPQ<String>(N);
        for(int i = 0; i < N; i++){
            if(!streams[i].isEmpty()){
                String s = streams[i].readString();
                pq.insert(i, s);
            }
        }

        while(!pq.isEmpty()){
            System.out.println(pq.min());
            int i = pq.delMin();
            if(!streams[i].isEmpty()){
                String s = streams[i].readString();
                pq.insert(i, s);
            }
        }
    }

    public static void main(String[] args){
        int N = args.length;
        In[] streams = new In[N];
        for(int i = 0; i < N; i++){
            streams[i] = new In(args[i]);
        }
        merge(streams);
    }
}

import edu.princeton.cs.algs4.StdIn;

public class WeightedUF{
//    initial tree: all item in id[] are root node
    private int[] id;
//    save nodes of each tree; only one root node when initialed
    private int[] size;
//    the amount of trees in th end
    private int count;

    public WeightedUF(int N){
        count = N;
        id = new int[N];
        for(int i = 0; i < N; i++) id[i] = i;
        size = new int[N];
        for(int j =0; j < N; j++) size[j] = 1;
    }

    public int count(){
        return count;
    }

    public int find(int p){
        while(p != id[p]) p = id[p];
        return p;
    }

    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    public void union(int p, int q){
        int pRoot = find(p);
        int qRoot = find(q);
        if(connected(p, q)) return;
        if(size[pRoot] < size[qRoot]) { id[pRoot] = qRoot; size[qRoot] += size[pRoot];}
        else{id[qRoot] = pRoot; size[pRoot] += size[qRoot];}
        count--;
    }

    public static void main(String args[]){
        int N = StdIn.readInt();
        WeightedUF uf = new WeightedUF(N);
        while(!StdIn.isEmpty()){
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            uf.union(p, q);
            System.out.println(p + " " + q);
        }
        System.out.println(uf.count() + " component");
    }
}
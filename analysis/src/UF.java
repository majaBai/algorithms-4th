import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UF {
    private int[] id;
    private int count;

    public UF(int N){
     count = N;
     id = new int[N];
     for(int i = 0; i< id.length; i++){
         id[i] = i;
     }
    }

    public int count(){
        return count;
    }

//    method1: quick-fiind
//    public int find(int p){
//        return id[p];
//    }
//
//    public void union(int p, int q){
//        if(connected(p, q)) return;
//        int pID = find(p);
//        int qID = find(q);
//        for(int i = 0; i< id.length; i ++){
//            if(id[i] == pID) id[i] = qID;
//        }
//        for(int i = 0; i < id.length; i++){
//            System.out.print(id[i] + " ");
//        }
//        count--;
//    }
//    public boolean connected(int p, int q){
//        return find(p) == find(q);
//    }

//    method2: quick-union
    public int find(int p){
        while(p != id[p]) p = id[p];
        return p;
    }

    public void union(int p, int q){
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == qRoot) return;
        id[pRoot] = qRoot;
        for(int i = 0; i < id.length; i++){
            System.out.print(id[i] + " ");
        }
        count--;
    }



    public static void main(String args[]){
        int N = StdIn.readInt();
        UF uf = new UF(N);
        while(!StdIn.isEmpty()){
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            uf.union(p, q);
            System.out.println("");
            System.out.println(p + " " + q);
        }
        System.out.println(uf.count() + " component");
    }
}
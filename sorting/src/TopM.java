
import edu.princeton.cs.algs4.*;

public class TopM {
    public static void main(String[] args){
        int M = Integer.parseInt(args[0]);
//        MinPQBasedArray<Transaction> pq = new MinPQBasedArray<Transaction>(M+1);
        MaxPQBasedArray<Transaction> pq = new MaxPQBasedArray<Transaction>(M+1);

        while(StdIn.hasNextLine()){
            pq.insert(new Transaction(StdIn.readLine()));
//            always keep M elements, if more than M, delete the min element
            if(pq.size() > M){
                pq.delMax();
//                pq.delMin();

            }
        }
//        pq.show(M);
//        pq.show();
        Stack<Transaction> stack = new Stack<Transaction>();
        while(!pq.isEmpty()){
            stack.push(pq.delMax());
//            stack.push(pq.delMin());

        }
        for(Transaction t : stack) System.out.println(t);
    }
}
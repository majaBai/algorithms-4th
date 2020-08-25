import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Out;

public class InOut{
    public static void main(String args[]) {

//        String query = args[0];
//        String r = "";
//        while(!StdIn.isEmpty()){
//            String s = StdIn.readLine();
//            System.out.println("string from txt: " + s);
//            if(s.contains(query)) {
//                r = s;
//                System.out.println(r);
//            }
//        }
//        if(r.length() == 0) {
//            System.out.println("this name dose not exist.");
//        }
//    }
        Out out = new Out(args[args.length - 1]);
        for (int i = 0; i < args.length - 1; i++) {
            In in = new In(args[i]);
            String s = in.readAll();
            out.println(s);
            in.close();
        }
        out.close();
    }
}
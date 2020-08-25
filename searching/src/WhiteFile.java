import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.In;

public class WhiteFile{
//    java WhiteFile list.txt < tinyTale.txt
    public static void main(String[] args){
        HashSET<String> set;
        set = new HashSET<String>();
        In in = new In(args[0]);
        while(!in.isEmpty()){
            set.add(in.readString());
        }
        while(!StdIn.isEmpty()){
            String word = StdIn.readString();
//            if(set.contains(word)){
//                System.out.print(word+" ");
//            }
            if(!set.contains(word)){
                System.out.print(word+" ");
            }
        }
    }
}
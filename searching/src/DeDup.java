import edu.princeton.cs.algs4.StdIn;

public class DeDup{
//    < tinyTale.txt
    public static void main(String[] args){
//        SET<String> set;
//        set = new SET<String>();
        HashSET<String> set;
        set = new HashSET<String>();
        while(!StdIn.isEmpty()) {
            String key = StdIn.readString();
            if(!set.contains(key)){
                set.add(key);
                System.out.println(key);
            }
        }
//        only for the SET, which is iterable
//        for(String s : set){
//            System.out.println(s+" ");
//        }
    }
}
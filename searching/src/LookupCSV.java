import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.In;

public class LookupCSV{
    public static void main(String[] args){
//        java LookupCSV amino.csv 0 3
        In in = new In(args[0]);
        int keyField = Integer.parseInt(args[1]);
        int valueField = Integer.parseInt(args[2]);
        ST<String, String> st = new ST<String, String>();
        while(in.hasNextLine()){
            String line = in.readLine();
            String[] tokens = line.split(",");
            String key = tokens[keyField];
            String value = tokens[valueField];
            st.put(key, value);
        }
        while(!StdIn.isEmpty()){
            String query = StdIn.readString();
            if(st.contains(query)){
                System.out.println(query+ "  "+st.get(query));
            }
        }
    }
}
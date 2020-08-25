import java.util.Arrays;
// read file
import edu.princeton.cs.algs4.In;
// read data from console (can be a file also)
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FixedCapStackofString {
    private String[] a;
    private  int n;
    public FixedCapStackofString(int c){
        a = new String[c];
    }

    public boolean isEmpty(){
        return n ==0;
    }

    public int size(){
        return n;
    }

    public void push(String s){
        a[n++] = s;
    }

    public String pop(){
        return a[--n];
    }

    public boolean isFull(){
        return n == a.length;
    }

    public void resizing(int max){
        String[] temp = new String[max];
        for(int i = 0; i< a.length; i++){
            temp[i] = a[i];
        }
        a = temp;
    }

    public static void main(String args[]) {
        FixedCapStackofString f = new FixedCapStackofString(3);
        while(!StdIn.isEmpty()){
            String item = StdIn.readString();
            if(!item.equals("-")){
                if(f.isFull()){
                    System.out.println(item);
                    System.out.println("array is enlarged " + f.isFull());
                    f.resizing(2*f.size());
                }
                f.push(item);
            } else if(!f.isEmpty()){
                System.out.print(f.pop() + " ");
            }
        }
        System.out.print("(" + f.size() + " left in stack)");
    }
}
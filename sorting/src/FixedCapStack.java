import edu.princeton.cs.algs4.StdIn;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class FixedCapStack<Item> implements Iterable<Item> {
    private Item[] a;
    private int n;

    @SuppressWarnings("unchecked")
    public FixedCapStack( int c){
//        change data type
        a = (Item[]) new Object[c];
    }

    public int size(){
        return n;
    }

    public boolean isEmpty(){
         return n == 0;
    }

//    check size of array; enlarge by necessary
@SuppressWarnings("unchecked")
    public void resize(int max){
        Item[] temp = (Item[]) new Object[max];
        for(int i = 0; i < n; i++){
            temp[i] = a[i];
        }
        a = temp;
    }


    public void push(Item s){
        if(n == a.length){
            resize(2*a.length);
        }
        a[n++] = s;
    }

    public Item pop(){
        Item item = a[--n];
        a[n] = null;
        if(n > 0 && n == a.length /4){
            resize(a.length / 2);
        }
        return item;
    }
    public Iterator<Item> iterator(){
        return new ReverseArrayIterator();
    }
    private class ReverseArrayIterator implements Iterator<Item>{
        private int i = n;
        public boolean hasNext(){
            return i > 0;
        }
        public Item next(){
            return a[--n];
        }
        public void remove(){}
    }

    @SuppressWarnings("unchecked")
    public static void main(String args[]){
        FixedCapStack<String> f;
         f = new FixedCapStack<String>(100);
        while(!StdIn.isEmpty()){
            String s = StdIn.readString();
            if(!s.equals("-")){
                f.push(s);
            } else if (!f.isEmpty()){
                for(String h : f){
                    System.out.println("iterator: " + h);
                }
                f.pop();
//                System.out.print(f.pop() + " ");
            }
        }
        System.out.print("(" + f.size() +" left in stack)");
    }
}
import edu.princeton.cs.algs4.StdIn;
import java.util.Iterator;

@SuppressWarnings("unchecked")
public class ResizingArrayStack<Item> implements Iterable<Item> {
    private int n;
    private Item[] a = (Item[]) new Object[1];

    public boolean isEmpty(){
        return n == 0;
    }

    public int size(){
        return n;
    }

    @SuppressWarnings("unchecked")
    public void resize(int max){
        Item[] temp = (Item[]) new Object[max];
        for(int i = 0; i < a.length; i++){
            temp[i] = a[i];
        }
        a = temp;
    }

    public void push(Item v){
        if(n == a.length){
            resize(a.length * 2);
        }
        a[n++] = v;
    }

    public Item pop(){
        System.out.println("n before pop: " + n);
        Item v = a[--n];
        System.out.println("n in pop is: " + n);
        a[n] = null;
        if(n > 0 && n == a.length/4){
            resize(a.length / 2);
        }
        return v;
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
            return a[i--];
        }
        public void remove(){}
    }

    public static void main(String args[]){
        ResizingArrayStack<String> R = new ResizingArrayStack<String>();
        R.push("to");
        R.push("be");
        R.push("or");
        R.push("or");
        R.push("not");
        R.push("to");
        R.push("be");
        String s = R.pop();
        System.out.println("value poped is: " + s);
    }
}
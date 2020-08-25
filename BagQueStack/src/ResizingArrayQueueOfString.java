import java.util.NoSuchElementException;

public class ResizingArrayQueueOfString {
    private String[] a;
    private int n;

    public ResizingArrayQueueOfString(int max){
        a = new String[max];
    }

    public boolean isFull(){
        return n == a.length;
    }

    public boolean isEmpty(){
        return n == 0;
    }

    public int size(){
        return n;
    }

    public void resizing(int max){
        String[] temp = new String[max];
        for(int i = 0; i<a.length; i++){
            temp[i] = a[i];
        }
        a = temp;
    }

    public void enqueue(String s){
        if(isFull()){
            System.out.println("Queue is full, enlarge...");
            resizing(a.length*2);
        }
        a[n] = s;
        n++;
        System.out.println("n after enqueue: " + n);
    }

    public String dequeue(){
        String r = a[0];
        n--;
        for(int k = 0; k < n; k++){
            a[k] = a[k+1];
        }
        if(n > 0 && n == a.length/4){
            resizing(a.length/2);
        }
        System.out.println("n after dequeue: " + n);
        return r;
    }

    public String readValAtIndex(int i){
        if(i > n) throw new NoSuchElementException("index over the length od Queue");
        String r = "";
        for(int j = 0; j < n; j++){
            System.out.println("current value is: " + a[j]);
            if(j == (n - i)){
                System.out.println("n is: " +n);
                System.out.println("j is: " +j);
                System.out.println("i is: " +i);
                r = a[j];
                break;
            }
        }
        return r;
    }

    public static void main(String args[]){
        ResizingArrayQueueOfString Q = new ResizingArrayQueueOfString(3);
        Q.enqueue("to");
        Q.enqueue("be");
        Q.enqueue("or");
        Q.enqueue("not");
        Q.enqueue("to");
        Q.enqueue("be");
        String h = Q.dequeue();
        System.out.println("the value dequeue: "+ h);
//        String l = Q.dequeue();
//        System.out.println("the value dequeue: "+ l);
        String y = Q.readValAtIndex(4);
        System.out.println("the value at index -2 is: " + y);
    }
}
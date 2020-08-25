
public class Counter{
    private final String name;
    private  int count;

    public Counter(String id){
        name = id;
    }

    public void increament(){
        count++;
    }

    public int tally(){
        return count;
    }

    public String toString(){
        return count+" "+name;
    }

    public static void main(String args[]){
        Counter heads = new Counter("heads");
        Counter tails = new Counter("tails");

        heads.increament();
        tails.increament();
        heads.increament();

        System.out.println(heads + " " + tails);
        System.out.println(heads.tally() + tails.tally());

    }
}
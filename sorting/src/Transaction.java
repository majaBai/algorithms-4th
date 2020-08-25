import java.lang.Integer;
import java.util.Comparator;
import java.util.concurrent.Callable;

public class Transaction implements Comparable<Transaction>{
    private String name;
    private Date time;
    private double amount;

//    public Transaction(String who, Date when, double money){
//        name = who;
//        time = when;
//        amount = money;
//    }
    public Transaction(String s){
        String[] fields = s.split(" ");
        name = fields[0];
        Date t = new Date(fields[1]);
        time = t;
        amount = Double.parseDouble(fields[2]);
    }

    public String isWho(){
        return name;
    }

    public Date isWhen(){
        return time;
    }

    public double howMuch(){
        return amount;
    }

    public String toString(){
        return isWho() + " " + isWhen() + " " + howMuch();
    }

    public boolean equals(Object x){
        if(this == x) return true;
        if(x == null) return false;
        if(this.getClass() != x.getClass()) return false;
        Transaction  that = (Transaction) x;
        if(this.isWho() != that.isWho()) return false;
        if(this.howMuch() != that.howMuch()) return false;
        if(!this.isWhen().equals(that.isWhen())) return false;
        return true;
    }

    public int compareTo(Transaction that){
        if(this.amount > that.amount) return +1;
        if(this.amount < that.amount) return -1;
        return 0;
    }
    // wait to complement
    public int hashCode(){
        return 0;
    }

    public static class WhoOrder implements Comparator<Transaction>{
        public int compare(Transaction v, Transaction w){
            return v.name.compareTo(w.name);
        }
    }

    public static class WhenOrder implements Comparator<Transaction>{
        public int compare(Transaction v, Transaction w){
            return v.time.compareTo(w.time);
        }
    }

    public static class HowMuchOrder implements Comparator<Transaction>{
        public int compare(Transaction v, Transaction w){
            if(v.amount < w.amount) return -1;
            if(v.amount > w.amount) return +1;
            return 0;
        }
    }

    public static void main(String args[]){
//        String n = "Maja";
//        Date d = new Date("2020/03/24");
//        double m = 1200.01;
        Transaction T = new Transaction("Maja 2020/03/24 1200.01");
        System.out.println(T.toString());
    }

}
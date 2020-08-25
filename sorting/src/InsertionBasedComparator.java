import java.util.Comparator;

public class InsertionBasedComparator{

    public static void sort(Object[] a, Comparator c){
        int n = a.length;
        for(int i = 1; i< n; i++){
            for(int j = i; j >0 && less(c, a[j], a[j-1]); j--){
                exch(a, j, j-1);
            }
        }
    }
    @SuppressWarnings("unchecked")

    private static boolean less(Comparator c, Object v, Object w){
        return c.compare(v, w) < 0;
    }

    private static void exch(Object[] a, int i, int j){
        Object t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    public static void main(String[] a){
        Transaction[] t = new Transaction[4];
        t[0] = new Transaction("Turing 1990/6/17 644.08");
        t[1] = new Transaction("Tarjan 2002/3/26 4121.85");
        t[2] = new Transaction("Knuth 1999/6/14 288.34");
        t[3] = new Transaction("Dijkstra 2007/8/22 2678.40");

        System.out.println("unsorted: ");
        for(int i = 0; i < t.length; i++){
            System.out.println(t[i]);
        }

        System.out.println("sorted by name: ");
        InsertionBasedComparator.sort(t, new Transaction.WhoOrder());
        for(int i = 0; i < t.length; i++){
            System.out.println(t[i]);
        }

        System.out.println("sorted by date: ");
        InsertionBasedComparator.sort(t, new Transaction.WhenOrder());
        for(int i = 0; i < t.length; i++){
            System.out.println(t[i]);
        }

        System.out.println("sorted by amount: ");
        InsertionBasedComparator.sort(t, new Transaction.HowMuchOrder());
        for(int i = 0; i < t.length; i++){
            System.out.println(t[i]);
        }
    }
}
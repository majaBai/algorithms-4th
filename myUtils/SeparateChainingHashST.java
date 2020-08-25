
public class SeparateChainingHashST<Key, Value>{
    private int N;
    private int M;
    private SequentialSearchST<Key, Value>[] st;

    public SeparateChainingHashST(){
        this(997);
    }
@SuppressWarnings("unchecked")
    public SeparateChainingHashST(int m){
        this.M = m;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
        for(int i =0; i < M; i++){
            st[i] = new SequentialSearchST();
        }
    }

    public int size(){
        return N;
    }

    public void resizing(int cap){
        SeparateChainingHashST<Key, Value> temp =  new SeparateChainingHashST<Key, Value>(cap);
        for(int i = 0; i < M; i++){
            for(Key k: st[i].keys()){
                temp.put(k, st[i].get(k));
            }
        }
        this.M = temp.M;
        this.N = temp.N;
        this.st = temp.st;
    }
    public boolean isEmpty(){
        return size() == 0;
    }

    public boolean contains(Key key){
        return get(key) != null;
    }


    private int hash(Key key){
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public Value get(Key key){
        return (Value) st[hash(key)].get(key);
    }

    public void put(Key key, Value val){
        if(N >= 10*M) resizing(2*M);
        st[hash(key)].put(key, val);
    }

    public void delete(Key key){
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");
        int h = hash(key);
        if(contains(key)) N--;
        st[h].delete(key);
        if(N == M/4) resizing(M/2);
    }
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < M; i++) {
            if (st[i] != null) {
                Iterable<Key> q = st[i].keys();
                for (Key k : q) {
                    queue.enqueue(k);
                }
            }
        }
        return queue;
    }

    public static void main(String[] args){
        SeparateChainingHashST<String, Integer> st  = new SeparateChainingHashST<String, Integer>();
        String [] a = {"E", "A", "S", "F", "M", "P", "Y", "H", "A", "E"};
        for(int i = 0; i < a.length; i++){
            st.put(a[i], i);
        }
        for(String k : st.keys()){
            System.out.println(k + ": " + st.get(k));
        }
    }


}
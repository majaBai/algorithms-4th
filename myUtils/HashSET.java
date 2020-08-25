
// too difficult...
public class HashSET<Key>{
    private LinearProbingHashST<Key, Integer> set ;
    public HashSET(){
        set = new LinearProbingHashST<Key, Integer>();
    }
    public void add(Key key){
        set.put(key, 1);
    }

    public void delete(Key key){
        set.delete(key);
    }

    public boolean contains(Key key){
        return set.contains(key);
    }

    public boolean isEmpty(){
        return set.isEmpty();
    }

    public int size(){
        return set.size();
    }

    public static void main(String[] args){

    }

}
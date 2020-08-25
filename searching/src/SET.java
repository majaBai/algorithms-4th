import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.TreeSet;

public class SET<Key extends Comparable<Key>> implements Iterable<Key>{
    private TreeSet<Key> set;

    public SET(){
        set = new TreeSet<Key>();
    }
    public SET(SET<Key> x){
        set = new TreeSet<Key>(x.set);
    }
    public void add(Key key){
        if(key == null) throw new IllegalArgumentException("calls add() with null key");
        set.add(key);
    }
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("called contains() with a null key");
        return set.contains(key);
    }
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("called delete() with a null key");
        set.remove(key);
    }
    public int size() {
        return set.size();
    }
    public boolean isEmpty() {
        return size() == 0;
    }
    public String toString() {
        String s = set.toString();
        return "{ " + s.substring(1, s.length() - 1) + " }";
    }
    public SET<Key> union(SET<Key> that) {
        if (that == null) throw new IllegalArgumentException("called union() with a null argument");
        SET<Key> c = new SET<Key>();
        for (Key x : this) {
            c.add(x);
        }
        for (Key x : that) {
            c.add(x);
        }
        return c;
    }
    public SET<Key> intersects(SET<Key> that) {
        if (that == null) throw new IllegalArgumentException("called intersects() with a null argument");
        SET<Key> c = new SET<Key>();
        if (this.size() < that.size()) {
            for (Key x : this) {
                if (that.contains(x)) c.add(x);
            }
        }
        else {
            for (Key x : that) {
                if (this.contains(x)) c.add(x);
            }
        }
        return c;
    }

    public Iterator<Key> iterator() {
        return set.iterator();
    }

    public static void main(String[] args){
        SET<String> set = new SET<String>();
        set.add("www.apple.com");
        set.add("www.baidu.com");
        set.add("www.google.com");
        set.add("www.alipay.com");
        set.add("www.qq.com");
        for (String s : set) {
            System.out.println(s);
        }
    }
}
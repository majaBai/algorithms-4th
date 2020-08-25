import java.awt.*;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.lang.UnsupportedOperationException;

public class Stack<Item> implements Iterable<Item> {
    private Node first;
    private int n;

    private class Node{
        Item item;
        Node next;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public int size(){
        return n;
    }

    public void push(Item v){
        Node oldFirst = first;
        first = new Node();
        first.item = v;
        first.next = oldFirst;
        n++;
    }

    public Item pop(){
        Node oldFirst = first;
        first = first.next;
        n--;
        return oldFirst.item;
    }

    public Item readLast(){
        Node current = first;
        while(current.next != null){
            current = current.next;
        }
        return current.item;
    }

    public Item peek(){
        if(isEmpty()) throw new NoSuchElementException("stack is empty");
        return first.item;
    }

    public static Stack<String> copy(Stack<String> stk){
        Stack<String> temp = new Stack<String>();
        Stack<String> result = new Stack<String>();
        for(String s : stk){
            temp.push(s);
        }
        for(String v : temp){
            result.push(v);
        }
        return result;
    }

    public static boolean Parentheses(String s){
        Stack<String> stk = new Stack<String>();
        for(int i = 0; i< s.length(); i++){
            String v = s.substring(i, i+1);
            if(v.equals("[") ||v.equals("(") || v.equals("{")){
                stk.push(v);
//                System.out.println("symbol pushed: " + v);
            } else if(v.equals("]")){
                if(stk.isEmpty()){
                    return false;
                }
                String t = stk.pop();
//                System.out.println("symbol1 : " + t);
                if(!t.equals("[")){
                    return false;
                }
            } else if(v.equals(")")){
                if(stk.isEmpty()){
                    return false;
                }
                String t = stk.pop();
//                System.out.println("symbol2 : " + t);
                if(!t.equals("(")){
                    return false;
                }
            } else if(v.equals("}")){
                if(stk.isEmpty()){
                    return false;
                }
                String t = stk.pop();
//                System.out.println("symbol3 : " + t);
                if(!t.equals("{")){
                    return false;
                }
            }
        }
        if(!stk.isEmpty()){
            return false;
        }
        return true;
    }

    public static void addLeftParentheses(String s){
        Stack<String> ops = new Stack<String>();
        Stack<String> vals = new Stack<String>();

        for(int i =0; i<s.length(); i++){
            String v = s.substring(i, i+1);
            if(v.equals("+") || v.equals("-") ||v.equals("*") ||v.equals("/") ||v.equals("sqrt")){
                ops.push(v);
            } else if(v.equals(")")){
                String op = ops.pop();
                String va = vals.pop();
                if(op.equals("+")||op.equals("-")||op.equals("*")||op.equals("/")){
                    String subexpression = "( " + vals.pop() + " " + op + " " + va + " )";
                    vals.push(subexpression);
                }
                if(op.equals("sqrt")){
                    String subexpression = op + " ( " + va + " ) ";
                    vals.push(subexpression);
                }
            } else {
                vals.push(v);
            }
        }

        System.out.print(vals.pop());
    }

    public Iterator<Item> iterator(){
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>{
        private Node current = first;
        public boolean hasNext(){
            return current != null;
        }
        public void remove(){
            throw new UnsupportedOperationException("dose not support remove");
        }
        public Item next(){
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String args[]){
        Stack<String> s = new Stack<String>();
//        System.out.println("is stack empty before push: " + s.isEmpty());
        s.push("to");
        s.push("be");
        s.push("or");
        s.push("not");
//        s.push("to");
//        s.push("be");
//        s.push("that");
//        s.push("is");
//        System.out.println("the size of stack: " + s.size());
//        System.out.println("the value poped: " +s.pop());
//        System.out.println("the last value:" + s.readLast());
//        for(String item : s){
//            System.out.println("iterator: " + item);
//        }
        System.out.println("the value added lately:" + s.peek());
        Stack<String> C = copy(s);
        for(String f: C){
            System.out.println("copy s: " + f);
        }
        String s1 = "{[]}({{[]}})()";
        System.out.println("s1: " + Parentheses(s1));
        String s2 = "[]}}";
        System.out.println("s2: " + Parentheses(s2));

        String u = "1+2)*3-4)*5-6)))";
        addLeftParentheses(u);
    }
}
import edu.princeton.cs.algs4.StdIn;

public class FrequencyCounter{

    public static void main(String[] args){
//        < tinyTale.txt
//        SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
//        BinarySearchST<String, Integer> st = new BinarySearchST<String, Integer>(100);
//          BST<String, Integer> st = new BST<String, Integer>();
//        SeparateChainingHashST<String, Integer> st = new SeparateChainingHashST<String, Integer>();
        LinearProbingHashST<String, Integer> st = new LinearProbingHashST<String, Integer>();

        int min = Integer.parseInt(args[0]);
        while(!StdIn.isEmpty()){
            String word = StdIn.readString();
            if(word.length() < min) continue;
            if(!st.contains(word)) st.put(word, 1);
            else st.put(word, st.get(word)+1);
        }

        String max = " ";
        st.put(max, 0);
        for(String word: st.keys()){
            if(st.get(word) > st.get(max)){
                max = word;
            }
        }

        int j = st.get(max);

        Queue<String> q = new Queue<String>();
        for(String k : st.keys()){
            if (st.get(k) == j) {
                q.enqueue(k);
            }
        }
        while(!q.isEmpty()){
            System.out.println(q.dequeue()+ " "+ j  );
        }
    }

}
import edu.princeton.cs.algs4.StdIn;

public class Alphabet{
    private char[] alphabet;// the characters in the alphabet
    private int[] inverse;// indices
    private int R;// the . of the alphabet

    public Alphabet(String alpha){
        boolean[] unicode = new boolean[Character.MAX_VALUE];
        for(int i = 0; i < alpha.length(); i++){
            char c = alpha.charAt(i);
            if(unicode[c])
                throw new IllegalArgumentException("Illegal alphabet: repeated character = '" + c + "'");
            unicode[c] = true;
        }

        alphabet = alpha.toCharArray();
        R = alpha.length();
        inverse = new int[Character.MAX_VALUE];
        for(int c = 0; c < R; c++){
            inverse[alphabet[c]] = c;
        }
    }

    public Alphabet(int radix){
        this.R = radix;
        alphabet = new char[R];
        inverse = new int[R];
        for(int i = 0; i < R; i++) alphabet[i] = (char) i;
        for(int i = 0; i< R; i++) inverse[i] = i;
    }

    public Alphabet() {this(256);}

    public boolean contains(char c){
        return inverse[c] != -1;
    }
    public int radix() {return R;}
    public int lgR(){
        int lgR = 0;
        for(int t = R - 1; t >= 1; t/=2) lgR++;
        return lgR;
    }

    public int toIndex(char c){
        if (c >= inverse.length || inverse[c] == -1) {
            throw new IllegalArgumentException("Character " + c + " not in alphabet");
        }
        return inverse[c];
    }
    public int[] toIndices(String s){
        char[] source = s.toCharArray();
        int[] target = new int[s.length()];
        for(int i = 0; i < source.length; i++){
            target[i] = toIndex(source[i]);
        }
        return target;
    }

    public char toChar(int index){
        if (index < 0 || index >= R) {
            throw new IllegalArgumentException("index must be between 0 and " + R + ": " + index);
        }
        return alphabet[index];
    }

    /**
     *  The binary alphabet { 0, 1 }.
     */
    public static final Alphabet BINARY = new Alphabet("01");

    /**
     *  The octal alphabet { 0, 1, 2, 3, 4, 5, 6, 7 }.
     */
    public static final Alphabet OCTAL = new Alphabet("01234567");

    /**
     *  The decimal alphabet { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }.
     */
    public static final Alphabet DECIMAL = new Alphabet("0123456789");

    /**
     *  The hexadecimal alphabet { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, A, B, C, D, E, F }.
     */
    public static final Alphabet HEXADECIMAL = new Alphabet("0123456789ABCDEF");

    /**
     *  The DNA alphabet { A, C, T, G }.
     */
    public static final Alphabet DNA = new Alphabet("ACGT");

    /**
     *  The lowercase alphabet { a, b, c, ..., z }.
     */
    public static final Alphabet LOWERCASE = new Alphabet("abcdefghijklmnopqrstuvwxyz");

    /**
     *  The uppercase alphabet { A, B, C, ..., Z }.
     */

    public static final Alphabet UPPERCASE = new Alphabet("ABCDEFGHIJKLMNOPQRSTUVWXYZ");

    /**
     *  The protein alphabet { A, C, D, E, F, G, H, I, K, L, M, N, P, Q, R, S, T, V, W, Y }.
     */
    public static final Alphabet PROTEIN = new Alphabet("ACDEFGHIKLMNPQRSTVWY");

    /**
     *  The base-64 alphabet (64 characters).
     */
    public static final Alphabet BASE64 = new Alphabet("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/");

    /**
     *  The ASCII alphabet (0-127).
     */
    public static final Alphabet ASCII = new Alphabet(128);

    /**
     *  The extended ASCII alphabet (0-255).
     */
    public static final Alphabet EXTENDED_ASCII = new Alphabet(256);

    /**
     *  The Unicode 16 alphabet (0-65,535).
     */
    public static final Alphabet UNICODE16     = new Alphabet(65536);

   public static void main(String[] args){
       Alphabet alpha = new Alphabet(args[0]);
       int R = alpha.radix();
       int[] count = new int[R];
       String s = StdIn.readLine();
       int N = s.length();
       for(int i = 0; i < N; i++){
           if(alpha.contains(s.charAt(i))) count[alpha.toIndex(s.charAt(i))]++;
       }
       for(int c = 0; c< R; c++){
           System.out.println(alpha.toChar(c) + "  " + count[c]);
       }
   }

}
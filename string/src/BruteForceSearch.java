
public class BruteForceSearch{

    public static int search(String pat, String txt){
        int j, M = pat.length();
        int i, N = txt.length();
        for(i = 0, j = 0; i < N && j < M; i++){
            if(txt.charAt(i) == pat.charAt(j)){
                j +=1;
            } else {
//                i -= j;
//                j = 0;
//                in this specific situation, let j = 1 to avoid  i backing up
                j =1;
            }
        }
        if(j == M) return i - M;
        else return N;
    }

    public static void main(String args[]){
        String pat = "AAB";
        String txt = "AAAAAAAAB";
        int N = search(pat, txt);
        System.out.print(N);
    }
}
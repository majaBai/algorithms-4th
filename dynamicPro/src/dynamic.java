public class dynamic{

    public static int fib(int n){
       if(n < 2) return n;
       return fib(n - 1)+fib(n - 2);
    }

    public static int dynamicFib(int n){
        int[] a = new int[n+1];
        if(n == 1 || n == 2) return 1;
        a[0] = 0;
        a[1] = 1;
        a[2] = 1;
        for(int i = 3; i <= n; i++){
            a[i] = a[i-1] + a[i-2];
        }
        return a[n];
    }

    public static int iteratorFib(int n){
        int firstpre = 1;
        int pre = 1;
        int result = 1;
        if(n > 2){
            for(int i = 3; i <= n; i++){
                result = pre + firstpre;
                firstpre = pre;
                pre = result;
            }
        }
        return result;
    }

    public static void longstSubstring(String w, String s){

    }

    public static int max(int a, int b){
        return a >= b? a:b;
    }

    public static int cutRod(int[] p, int n){
        if(n == 0) return 0;
        int q = -1;
        for(int i = 1; i <=n; i++){
            q = max(q, p[i-1]+cutRod(p, n -i));
        }
        return q;
    }

    public static int  memoizedCutRod(int[] p, int n){
        int[] r = new int[n+1];
        for(int i = 0; i <= n; i++) r[i] = -1;
        return memoizedCutAux(p, n, r);
    }

    public static int memoizedCutAux(int[] p, int n, int[] r){
        int q = -1;
        if(r[n] >=0) return r[n];
        if(n == 0) q = 0;
        else{
            for(int i = 1; i <= n; i++){
                q = max(q, p[i - 1]+memoizedCutAux(p, n -i, r));
            }
        }
        r[n] = q;
        return q;
    }

    public static int bottomUpCutRod(int[] p, int n ){
        int[] r = new int[n+1];
        r[0] = 0;
        for(int j = 1; j <= n; j++){
            int q = -1;
            for(int i = 1; i <=j; i++){
                q = max(q, p[i - 1] + r[j-i]);
            }
            r[j] = q;
        }
        return r[n];
    }


    public static void main(String[] args){
//        int n = 17;
//        StopWatch timer1 = new StopWatch();
//        int f1 = fib(n);
//        double time1 = timer1.elapsedTime();
//        System.out.print("fib("+ n +"): " + f1 +"  " + time1);
//
//        System.out.print("  ----  ");
//        StopWatch timer2 = new StopWatch();
//        int f2 = dynamicFib(n);
//        double time2 = timer1.elapsedTime();
//        System.out.print("dyFib("+ n +"): " + f2 +"  " + time2);
//
//        System.out.print("  ----  ");
//        StopWatch timer3 = new StopWatch();
//        int f3 = iteratorFib(n);
//        double time3 = timer1.elapsedTime();
//        System.out.print("iteratorFib("+ n +"): " + f3 +"  " + time3);
        int n = 4;
        int[] p = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        int r = cutRod(p, n);
        System.out.println("max revenue: " + cutRod(p, n) + " " + memoizedCutRod(p,n) + " "+bottomUpCutRod(p,n));

    }
}
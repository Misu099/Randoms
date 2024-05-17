public class Fibonacci {




    public int fib(int n){
        if (n == 0 || n == 1){
            return n;
        }
        return (fib(n-2)+fib(n-1));
    }

    public int[] fibArr(int n){
        int[] arr = new int[n];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < n; i++){
            arr[i] = arr[i-2] + arr[i-1];
        }
        return arr;
    }

}

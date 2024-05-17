import java.util.Arrays;

public class Main {
    public static void main(String[] args) {


        Fibonacci fib = new Fibonacci();
        for (int i = 0; i < 10; i++) {
            System.out.println(fib.fib(i));
        }

        System.out.println(Arrays.toString(fib.fibArr(10)));


    }
}
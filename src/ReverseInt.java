public class ReverseInt {


    public int reverse(int n) {
        //TODO: overflow/underflow solution
        //
        //

        boolean isNegative = n < 0;
        int res = 0;
        n = Math.abs(n);

        while (n > 0) {
            res = res * 10 + (n % 10);
            n = n / 10;
        }
        if (isNegative) {
            return -res;
        } else return res;

    }
}

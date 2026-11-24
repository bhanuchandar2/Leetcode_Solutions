class Solution {

    public int reverse(int n) {
        boolean isNegative = n < 0;

        long num = Math.abs((long) n);

        long res = reverseHelper(num);

        if (isNegative) {
            res = -res;
        }

        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return 0;
        }

        return (int) res;
    }

    public int numberofdigits(long n) {
        return String.valueOf(n).length() - 1;
    }

    public long reverseHelper(long n) {
        if (n == 0) {
            return 0;
        }

        int len = numberofdigits(n);
        long mul = (long) Math.pow(10, len);
        long val = (n % 10) * mul;

        return val + reverseHelper(n / 10);
    }
}
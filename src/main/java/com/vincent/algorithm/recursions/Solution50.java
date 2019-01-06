package com.vincent.algorithm.recursions;

public class Solution50 {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 1 / myPow(x, -n);
        }
        double y = myPow(x * x, n / 2);
        return y * ((n & 1) == 1 ? x : 1);
    }

    public double mypow2(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        double pow = 1d;
        while (n > 0) {
            if ((n & 1) == 1) {
                pow *= x;
            }
            x *= x;
            n = (n >> 1);
        }

        return pow;
    }


    public static void main(String[] args) {
        Solution50 solution50 = new Solution50();
        System.out.println(solution50.myPow(3, 2));
    }

    public double mypow3(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        double pow = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                pow *= x;
            }
            x *= x;
            n = (n >> 1);
        }

        return pow;
    }
}

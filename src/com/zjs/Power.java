package com.zjs;

/**
 * 两种方法求解数值的整数次方
 *
 * 优化前: 时间复杂度O(n) 空间复杂度O(1)
 * 优化后: 时间复杂度O(log^n) 空间复杂度O(log^n)
 *
 * 题目链接: https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
 */
public class Power {
    static boolean ifInvalidInput = false;

    public static void main(String[] args) {
        System.out.println(myPow(2.0,10));
    }

    public static double myPow(double x, int n) {
        double result = 1.0;
        if (x == 0.0 && n < 0) {
            ifInvalidInput = true;
            return 0;
        }
        result = powerWithUnsignedExponent2(x, n);
        if (n < 0) {
            return 1.0 / result;
        } else {
            return result;
        }
    }

    //未优化
    public static double powerWithUnsignedExponent1(double base, int exponent) {
        double result = 1.0;
        int absExponent = Math.abs(exponent);
        for (int i = 0; i < absExponent; i++) {
            result *= base;
        }
        return result;
    }

    //优化powerWithUnsignedExponent
    public static double powerWithUnsignedExponent2(double base, int exponent) {
        int absExponent = Math.abs(exponent);
        if (absExponent == 0) {
            return 1.0;
        }
        if (absExponent == 1) {
            return base;
        }
        double result = powerWithUnsignedExponent2(base, absExponent>>1);
        result *= result;
        if ((absExponent & 1) == 0) {
            return result;
        } else {
            return result * base;
        }
    }
}

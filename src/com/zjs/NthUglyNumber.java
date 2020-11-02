package com.zjs;

/**
 * @ClassName NthUglyNumber
 * @Description TODO
 * @Author zhangjusheng
 * @Date 2020/10/30 0:01
 * @Version 1.0
 **/
public class NthUglyNumber {
    public static void main(String[] args) {
        NthUglyNumber nthUglyNumber = new NthUglyNumber();
        System.out.println(nthUglyNumber.nthUglyNumber(10));
    }

    public int nthUglyNumber(int n) {
        if (n <= 0)
            return -1;

        int[] uglyNumbers = new int[n];

        //设置第一个初始元素
        uglyNumbers[0] = 1;

        int t2 = 0;
        int t3 = 0;
        int t5 = 0;

        int number2 = 0;
        int number3 = 0;
        int number5 = 0;

        for (int i = 1; i < n; i++) {
            number2 = uglyNumbers[t2] * 2;
            number3 = uglyNumbers[t3] * 3;
            number5 = uglyNumbers[t5] * 5;

            uglyNumbers[i] = min(number2, number3, number5);

            if (number2 == uglyNumbers[i])
                t2++;
            if (number3 == uglyNumbers[i])
                t3++;
            if (number5 == uglyNumbers[i])
                t5++;
        }

        return uglyNumbers[n - 1];
    }

    int min(int number1, int number2, int number3) {
        int res = number1 > number2 ? number2 : number1;
        return res = res > number3 ? number3 : res;
    }
}

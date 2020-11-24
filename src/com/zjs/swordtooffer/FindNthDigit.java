package com.zjs.swordtooffer;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @ClassName FindNthDigit
 * @Description TODO
 * @Author zhangjusheng
 * @Date 2020/10/26 17:37
 * @Version 1.0
 **/
public class FindNthDigit {
    public static void main(String[] args) {
        FindNthDigit findNthDigit = new FindNthDigit();
        System.out.println(findNthDigit.findNthDigit(1000000000));
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });
    }

    public int findNthDigit(int n) {
        if (n < 0) {
            return -1;
        }
        if (n >= 0 && n <= 9) {
            return n;
        }
        long num = 90;
        //记录之前跳过的位数
        long preDigits = 10;
        //记录当前跳过的位数
        long curDigits = preDigits;
        String s;
        for (int i = 2; ; i++) {
            if (i == 10) {
                System.out.println(4);
            }
            //记录当前跳过的位数
            curDigits = preDigits + i * num;
            if (curDigits > n) {
                //如果当前跳过的位数超过了要寻找的位数,
                s = String.valueOf(powerBase10(i - 1) + (n - preDigits) / i);
                return s.charAt((int) (n - preDigits) % i) - '0';
            }
            preDigits = curDigits;
            num = num * 10;
        }
    }

    public int powerBase10(int n) {
        int result = 1;
        for (int i = 0; i < n; i++)
            result *= 10;

        return result;
    }
}

package com.zjs.swordtooffer;

import java.util.HashMap;
import java.util.Map;

public class Fib {
    public static void main(String[] args) {
        System.out.println(fib1(48));
        System.out.println(fib2(48));
    }

    public static int fib1(int n) {
        //创建映射Map,来存储斐波那契数列中的每一项
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 0);
        map.put(1, 1);
        for(int i = 2; i <= n; i++) {
            Integer num = map.get(i - 1) + map.get(i - 2);
            map.put(i, num % 1000000007);
        }
        return map.get(n);
    }

    public static int fib2(int n) {
        //并不需要一个很大的数组来求解当前项,我们只需要记录下当前项的前两项
        int pre1 = 0, pre2 = 1;
        //记录当前项的值
        int num = 0;
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
        for(int i = 2; i <= n; i++) {
            //开始刷新前两项的值
            num = (pre1 + pre2) % 1000000007;
            pre1 = pre2;
            pre2 = num % 1000000007;
        }
        return num;
    }
}

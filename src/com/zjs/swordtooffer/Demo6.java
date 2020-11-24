package com.zjs.swordtooffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Demo6
 * @Description TODO
 * @Author zhangjusheng
 * @Date 2020/11/1 11:38
 * @Version 1.0
 **/
public class Demo6 {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }

    public static int changeList(int[] a) {
        return ++a[0];
    }
}
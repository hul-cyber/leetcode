package com.zjs;

/**
 * @ClassName Demo6
 * @Description TODO
 * @Author zhangjusheng
 * @Date 2020/11/1 11:38
 * @Version 1.0
 **/
public class Demo6 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        System.out.println(changeList(a) + changeList(a));
    }

    public static int changeList(int[] a) {
        return ++a[0];
    }
}
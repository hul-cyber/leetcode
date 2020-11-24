package com.zjs.swordtooffer;

public class MinArray {
    public static void main(String[] args) {
        int[] numbers = { 3, 1, 1 };
        System.out.println(minArray2(numbers));
    }

    public static int minArray1(int[] numbers) {
        if(numbers == null || numbers.length == 0)
            return 0;
        //暴力法
        int i;
        for(i = 0; i < numbers.length - 1; i++) {
            if(numbers[i] > numbers[i + 1]) {
                return numbers[i + 1];
            }
        }
        //如果遍历完之后没有找到,那么返回数组首元素
        return numbers[0];
    }

    public static int minArray2(int[] numbers) {
        //暴力法与二分法相结合
        if(numbers == null || numbers.length == 0)
            return -1;
        int left = 0;
        int right = numbers.length - 1;
        int mid = 0;
        while(left < right) {
            mid = (left + right) / 2;
            //直接能够找到旋转数组所在
            if(numbers[mid] > numbers[right])
                left = mid + 1;
            else if(numbers[mid] < numbers[right])
                right = mid;
            else {
                right--;
            }
        }
        return numbers[left];
    }
}

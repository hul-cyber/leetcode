package com.zjs.swordtooffer;

/**
 * @ClassName RepeatNumber2
 * @Description 剑指Offer 03.数组中的重复数字,题目链接:https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 * 将原题改为长度为n + 1的数组中数的范围为1 ~ n
 * @Author zhangjusheng
 * @Date 2020/10/16 11:01
 * @Version 1.0
 **/
public class RepeatNumber2 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 4, 3, 2, 6, 7};
        System.out.println(findRepeatNumber(nums));
    }

    public static int findRepeatNumber(int[] nums) {
        if (nums == null && nums.length == 0)
            return -1;

        int start = 1;
        int end = nums.length - 1;
        int mid = 0;
        int count = 0;
        while (start <= end) {
            mid = (start + end) / 2;

            //统计元素在start与mid之间的元素数量
            count = countRange(start, mid, nums);

            if (count <= (mid - start + 1)) {
                //如果上面的区间没有重复元素
                start = mid + 1;
            } else {
                if (mid == start)
                    return start;
                //如果上面的区间有重复元素
                end = mid;
            }
        }

        return -1;
    }

    public static int countRange(int start, int end, int[] nums) {
        int count = 0;

        //计算出在start - end之间元素的数量
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= end && nums[i] >= start) {
                count++;
            }
        }

        return count;
    }
}

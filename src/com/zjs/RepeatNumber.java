package com.zjs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RepeatNumber {
    public static void main(String[] args) {
        int[] array = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber1(array));
    }
    public static int findRepeatNumber1(int[] nums) {
        //时间复杂度O(n), 空间复杂度O(n)
        //用一个数组来统计元素的个数,数组的索引代表该元素,java中默认int数组元素为0
        int result = 0;
        int[] bucket = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            bucket[nums[i]]++;
        }
        for(int i = 0; i < nums.length; i++) {
            if(bucket[i] > 1) {
                result = i;
                break;
            }
        }
        return result;
    }

    public static int findRepeatNumber2(int[] nums) {
        //时间复杂度: O(log2n)
        //首先进行对数组的排序
        Arrays.sort(nums);
        //排序完成后就可以扫描整个数组
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }
        return -1;
    }

    public static int findRepeatNumber3(int[] nums) {
        //时间复杂度O(n) 空间复杂度O(1)
        //用于交换位置的元素
        int swap;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i) {
                //当前元素没有在本应该待的位置
                if(nums[nums[i]] == nums[i]) {
                    //判断在本应该待的位置的元素是否与当前元素相等,相等的话,找到重复元素
                    return nums[i];
                }
                //如果不相等,将该元素放到本应该待的正确位置
                swap = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = swap;
            }
        }
        return -1;
    }
    public static int findRepeatNumber4(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < 0 || nums[i] > nums.length) {
                return -1;
            }
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            if(!set.add(nums[i])) {
                return nums[i];
            }
        }
        return -1;
    }
}

package com.zjs.twopoints;

/**
 * @ClassName ReverseVowels1
 * @Description 345 反转字符串中的元音字母 题目链接: https://leetcode-cn.com/problems/reverse-vowels-of-a-string/
 * 双指针
 * @Author zhangjusheng
 * @Date 2020/11/25 8:30
 * @Version 1.0
 */
public class ReverseVowels1 {

    public String reverseVowels(String s) {
        if (s == null || s.length() == 0)
            return "";
        // 转化之后的字符数组
        char[] arr = s.toCharArray();
        // 右边界
        int right = s.length() - 1;
        // 左边界
        int left = 0;
        while (left < right) {
            // 移动右边界
            while (right >= 0 && !judgeVowel(arr[right]))
                right--;
            // 移动左边界
            while (left < right && !judgeVowel(arr[left]))
                left++;
            if (left >= right) {
                break;
            }
            else {
                // 交换两者位置
                char temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;
            }
            left++;
            right--;
        }
        return new String(arr);
    }

    // 不需要额外申请内存的交换字符的方法
    /*char arr[left] = (char) (arr[right] + arr[left]);
    arr[right] = (char) (arr[left] - arr[right]);
    arr[left] = (char) (arr[left] - arr[right]);*/

    public boolean judgeVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
            return true;
        return false;
    }

}

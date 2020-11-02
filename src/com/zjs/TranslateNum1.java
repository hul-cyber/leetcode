package com.zjs;

/**
 * @ClassName TranslateNum1
 * @Description 剑指Offer 46 把数字翻译成字符串, 题目链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
 * 递归 + 回溯
 * @Author zhangjusheng
 * @Date 2020/10/28 23:56
 * @Version 1.0
 **/
public class TranslateNum1 {
    int count = 0;

    public static void main(String[] args) {
        TranslateNum1 translateNum = new TranslateNum1();
        System.out.println(translateNum.translateNum(220));
    }

    public int translateNum(int num) {
        //将数字转化成字符串
        String strOfNum = String.valueOf(num);
        recursive(strOfNum, 0);
        return count;
    }

    void recursive(String s, int index) {
        Integer j = 0;
        StringBuilder sb = new StringBuilder();
        if (index == s.length()) {
            count++;
        } else {
            for (int i = 0; i < 2; i++) {
                if (i == 0) {
                    if (s.charAt(index) == '0' || index == s.length() - 1) {
                        continue;
                    }
                    //当i为0,与后面的元素相结合
                    sb.append(s.charAt(index)).append(s.charAt(++index));
                    if (Integer.parseInt(sb.toString()) > 25) {
                        index--;
                        continue;
                    } else {
                        //继续寻求下一个元素
                        recursive(s, ++index);
                        index-=2;
                    }
                } else {
                    //当i为1,不与后面的元素相结合
                    recursive(s, ++index);
                }
            }
        }
    }
}

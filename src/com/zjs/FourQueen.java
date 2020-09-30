package com.zjs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.StrictMath.abs;

public class FourQueen {
    public static void main(String[] args) {
        System.out.println(fourQueen2(4));
    }

    public int fourQueen1() {
        return 0;
    }

    //非递归解法
    public static void fourQueen2(List<Integer[]> queenPositions, int n) {
        List<Integer[]> lists = new ArrayList<>() ;
        Integer[] integers = new Integer[n];
        //记录解法的次数
        int count = 0;
        //使用一个数组每一行当前已经遍历的位置
        int[] a = new int[n];
        Arrays.fill(a, -1);
        //记录当前正在遍历的行数
        int k = 0;
        //因为回溯的原因,当第一行遍历完后,会向上第0行回溯,可以作为算法结束的标志,所以这里的条件是k > -1
        while (k > -1) {
            a[k]++;
            if(a[k] > n - 1) {
                //如果已经到达最后一列,向上回溯
                k--;
                continue;
            } else {
                //如果没有到达最后一列
                if (valid(a, k)) {
                    //能够放置皇后
                    if (k == n - 1) {
                        //如果已经到达了最后一行了
                        count++;
                        //向上回溯
                        k--;
                        continue;
                    }
                    //当前位置能够放置皇后,像下移动一行
                    a[++k] = -1;
                    continue;
                } else {
                    //当前位置不能放置皇后

                }
            }
        }
    }

    /*如果一个皇后能放在第k行第a[k]列，则返回真(1)，否则返回假(0)*/
    static boolean valid(int[] a, int k)
    {
        int i;
        for (i = 0; i < k; ++i)
        {
            /*如果前k-1行中有某行的皇后与第k行的在同一列或同一斜线，返回0*/
            /*Java中的abs返回参数的绝对值*/
            if ((a[i] == a[k]) || (abs(i - k) == abs(a[i] - a[k])))
                return false;
        }
        return true;
    }

}

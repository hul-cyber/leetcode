package com.zjs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.StrictMath.abs;


public class SolveNQueens {
    public static void main(String[] args) {
        solveNQueens(4);
    }

    public static List<List<String>> solveNQueens(int n) {
        List<Integer[]> numList = new ArrayList<>();
        numList = findQueenPos(n);
        List<List<String>> strList = convert(numList, n);
        for (List<String> list : strList) {
            System.out.println(list);
        }
        return strList;
    }

    //非递归解法
    public static List<Integer[]> findQueenPos(int n) {
        List<Integer[]> numList = new ArrayList<>();
        Integer[] numPos = new Integer[n];
        //记录解法的次数
        int count = 0;
        //使用一个数组每一行当前已经遍历的位置
        Integer[] a = new Integer[n];
        Arrays.fill(a, -1);
        //记录当前正在遍历的行数
        int k = 0;
        //因为回溯的原因,当第一行遍历完后,会向上第0行回溯,可以作为算法结束的标志,所以这里的条件是k > -1
        while (k > -1) {
            a[k]++;
            if(a[k] > n - 1) {
                //如果已经到达最后一列,向上回溯,并将当前a[k]置为-1,表示还未放置
                a[k] = -1;
                k--;
                continue;
            } else {
                //如果没有到达最后一列
                if (valid(a, k)) {
                    //能够放置皇后
                    if (k == n - 1) {
                        //如果已经到达了最后一行了
                        count++;
                        //将当前列记录下来
                        numList.add(a.clone());
                        //并将其当前行的a[k]置为-1,即将当前行的皇后移走
                        a[k] = -1;
                        //向上回溯
                        k--;
                        continue;
                    }
                    //当前位置能够放置皇后,像下移动一行
                    a[++k] = -1;
                } else {
                    //当前位置不能放置皇后
                }
                continue;
            }
        }
        return numList;
    }

    /*如果一个皇后能放在第k行第a[k]列，则返回真(1)，否则返回假(0)*/
    private static boolean valid(Integer[] a, int k) {
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

    //将皇后位置的数字表示转化为字符串表示
    public static List<List<String>> convert(List<Integer[]> numList, int n) {
        List<List<String>> strList = new ArrayList<>();
        //用数字表示一个棋盘皇后的位置
        Integer[] numPos = null;
        String str = null;
        for (int i = 0; i < numList.size(); i++) {
            //用字符串来表示一个棋盘皇后的位置
            ArrayList<String> strPos = new ArrayList<>();
            numPos = numList.get(i);
            for (int j = 0; j < numPos.length; j++) {
                StringBuilder pos = new StringBuilder();
                //初始化pos,先全部赋值为"."
                for (int m = 0; m < n; m++) {
                    pos.append('.');
                }
                //将相应位置上的"."转化为"Q"
                pos.setCharAt(numPos[j], 'Q');
                //将pos转化成字符串
                str = pos.toString();
                //将用字符串表示的位置添加到strPos中
                strPos.add(str);
            }
            strList.add(strPos);
        }
        return strList;
    }
}
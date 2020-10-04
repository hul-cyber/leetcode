package com.zjs;

import java.util.HashSet;
import java.util.Set;

/**
 *  深度优先遍历(使用回溯法)求解机器人移动范围
 *  最坏情况下: 时间复杂度:O(MN) 空间的复杂度:O(MN)
 *  题目链接: https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 */
public class RobotMovRange1 {
    public static void main(String[] args) {
        System.out.println(movingCount(1, 2, 1));
    }

    public static int movingCount(int m, int n, int k) {
        if (m < 1 || m > 100 || n < 1 || n > 100 || k < 0 || k > 20)
            return 0;
        else {
            //存储已经到达的位置
            Set<Position> arrived = new HashSet<>();
            return search(0, 0, k, arrived, m, n);
        }
    }

    public static int search(int x, int y, int k, Set<Position> arrived, int m, int n) {
        if (x < 0 || x > m - 1 || y < 0 || y > n - 1) {
            return 0;
        } else {
            //当前位置
            Position currentPos = new Position(x, y);
            if (((sumOfDigits2(x) + sumOfDigits2(y)) <= k) && !arrived.contains(currentPos)) {
                //如果当前位置满足数位之和小于等于k,并且还没有到达过
                //将该位置加入到已到达
                arrived.add(currentPos);
                //只需要向下和向右就可以遍历所有情况,向上和向左完全没有必要
                return search(x + 1, y, k, arrived, m, n) + search(x, y + 1, k, arrived, m, n) + 1;
            } else {
                return 0;
            }
        }
    }

    static class Position {
        //横坐标
        int x;
        //纵坐标
        int y;

        //构造函数
        Position() {}
        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Position position = (Position) o;

            if (x != position.x) return false;
            return y == position.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

    //计算数位之和
    public static int sumOfDigits1(int num) {
        if(num == 100) {
            //等于100时
            return 1;
        } else if (10 <= num && num <= 99) {
            //大于等于10且小于等于99时
            return num / 10 + num % 10;
        } else {
            //当小于 10时
            return num;
        }
    }

    //另外一种计算数位之和的方法
    public static int sumOfDigits2(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
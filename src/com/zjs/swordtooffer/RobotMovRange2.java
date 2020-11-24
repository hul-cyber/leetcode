package com.zjs.swordtooffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 广度优先遍历求解机器人移动范围
 * 最坏情况下: 时间复杂度:O(MN) 空间复杂度O(MN)
 * 题目链接: https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 */
public class RobotMovRange2 {
    public static void main(String[] args) {
        System.out.println(movingCount(1, 2, 1));
    }

    public static int movingCount(int m, int n, int k) {
        if (m < 1 || m > 100 || n < 1 || n > 100 || k < 0 || k > 20)
            return 0;
        else {
            //用二维boolean数组记录已到达的位置
            boolean[][] arrived = new boolean[m][n];
            //创建一个队列实现广度优先遍历
            Queue<Position> q = new LinkedList<>();
            Position pos = new Position(0, 0);
            q.offer(pos);
            return search(q, k, arrived, m, n);
        }
    }

    public static int search(Queue<Position> q, int k, boolean[][] arrived, int m, int n) {
        while (!q.isEmpty()) {
            //当队列不为空
            //取出队首元素
            Position currentPos = q.poll();
            int x = currentPos.x;
            int y = currentPos.y;
            if (x > m - 1 || y > n - 1 || ((sumOfDigits2(x) + sumOfDigits2(y)) > k) || arrived[x][y] == true) {
                //如果不满足条件,则继续寻找下一个
                continue;
            } else {
                //将该元素添加到已到达
                arrived[x][y] = true;
                //将其下面和右面的位置添加到队列中
                Position downPos = new Position(x + 1, y);
                Position rightPos = new Position(x, y + 1);
                q.offer(downPos);
                q.offer(rightPos);
                //返回
                return search(q, k, arrived, m, n) + 1;
            }
        }
        return 0;
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

    static class Position {
        int x;
        int y;

        public Position() {}
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

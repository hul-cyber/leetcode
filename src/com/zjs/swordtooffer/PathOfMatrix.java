package com.zjs.swordtooffer;

import java.util.HashSet;
import java.util.Set;

public class PathOfMatrix {
    public static void main(String[] args) {
        /*char[][] board = {{'a', 'a'}};
        String word = "aaa";
        System.out.println(exist(board, word));*/
        Set<Position> set = new HashSet<>();
        Position p1 = new Position(0, 0);
        set.add(p1);
        Position p2 = new Position(0, 0);
        System.out.println(p1.equals(p2));
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
        if (set.contains(p2)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    public static boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0].length == 0) {

        } else {
            //储存已通过的位置
            Set<Position> passed = new HashSet<>();
            int targetIndex = 0;
            char target = '\0';
            for (int i = 0; i < board.length; i++) {
                for(int j = 0; j < board[i].length; j++) {
                    //找到第一个元素
                    target = word.charAt(targetIndex);
                    if(board[i][j] == target) {
                        //将第一个元素添加到集合中
                        Position startPos = new Position(i, j);
                        passed.add(startPos);
                        targetIndex++;
                        if(targetIndex < word.length()) {
                            //当还有剩余元素为寻找时
                            //寻找剩余元素
                            if (explore(targetIndex, passed, startPos, board, word)) {
                                return true;
                            } else {
                                //未找到,继续寻找,并且将index置0,并且将起始位置从集合中移除
                                targetIndex = 0;
                                passed.remove(startPos);
                                continue;
                            }
                        } else {
                            //如果没有要寻找的元素
                            return true;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        return false;
    }

    public static boolean judge(Position pos, Set<Position> passed) {
        if (passed.contains(pos))
            return true;
        else
            return false;
    }

    public static boolean ifLegal(Position nextPos, char target, char[][] board, Set<Position> passed) {
        if(nextPos.x >= 0 && nextPos.x <= board.length - 1 && nextPos.y >= 0 && nextPos.y <= board[0].length - 1) {
            if (board[nextPos.x][nextPos.y] == target && !judge(nextPos, passed))
                return true;
            else
                return false;
        } else {
            return false;
        }
    }

    public static boolean explore(int targetIndex, Set<Position> passed, Position currentPos, char[][] board, String word) {
        //存储下一个要找的位置
        Position nextPos = null;
        //目标字符
        char target = word.charAt(targetIndex);
        //遍历四个方向
        int nextPosX;
        int nextPosY;
        for (int i = 0; i < 4; i++) {
            if (i == 0) {
                nextPosX = currentPos.x - 1;
                nextPosY = currentPos.y;
            } else if (i == 1) {
                nextPosX = currentPos.x + 1;
                nextPosY = currentPos.y;
            } else if (i == 2) {
                nextPosX = currentPos.x;
                nextPosY = currentPos.y - 1;
            } else {
                nextPosX = currentPos.x;
                nextPosY = currentPos.y + 1;
            }
            nextPos = new Position(nextPosX, nextPosY);
            if (ifLegal(nextPos, target, board, passed)) {
                //如果在该位置找到了目标字符
                if (targetIndex == word.length() - 1) {
                    //如果是最后一个字符
                    return true;
                } else {
                    //如果不是最后一个字符
                    passed.add(nextPos);
                    targetIndex++;
                    if (explore(targetIndex, passed, nextPos, board, word)) {
                        //如果后续同样也找到最后的元素
                        return true;
                    } else {
                        //如果最后未找到最后的元素
                        //从集合中将刚加进去的元素移除
                        passed.remove(nextPos);
                        targetIndex--;
                        //继续遍历
                        continue;
                    }
                }
            } else {
                //如果未在该位置找到目标字符,继续遍历
                continue;
            }
        }
        //遍历完依旧未找到
        return false;
    }

    static class Position {
        //横坐标
        private int x;
        //纵坐标
        private int y;

        //构造函数
        public Position() {}
        public Position(int x, int y) {
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
}

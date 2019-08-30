import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Copyright (c) 2017 XiaoMi Inc. All Rights Reserved.
 *
 * @author: linzebin <linzebin@xiaomi.com>
 * Created on 2019/8/5
 */
/*
题目描述
NowCoder最喜欢游乐场的迷宫游戏，他和小伙伴们比赛谁先走出迷宫。
现在把迷宫的地图给你，你能帮他算出最快走出迷宫需要多少步吗？

输入描述:
输入包含多组数据。

每组数据包含一个10*10，由“#”和“.”组成的迷宫。其中“#”代表墙；“.”代表通路。
入口在第一行第二列；出口在最后一行第九列。
从任意一个“.”点都能一步走到上下左右四个方向的“.”点。

输出描述:
对应每组数据，输出从入口到出口最短需要几步。

示例1
输入
#.########
#........#
#........#
#........#
#........#
#........#
#........#
#........#
#........#
########.#
#.########
#........#
########.#
#........#
#.########
#........#
########.#
#........#
#.######.#
########.#

输出
16
30
 */
public class Maze2 {
    public static class Node{
        int x,y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static String[] str = new String[10];
    public static char[][] maze = new char[10][10];
    public static int[][] step = new int[10][10];
    public static int[][] direct = {{0,1},{0,-1},{1,0},{-1,0}};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            for (int i = 0; i < 10; i++) {
                str[i] = scanner.next();
            }
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    maze[i][j] = str[i].charAt(j);
                }
            }

            System.out.println(bfs());

        }
    }

    public static int bfs(){
        int startI = 0, startJ = 1, endI = 9, endJ = 8;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(startI,startJ));
        maze[startI][startJ] = '#';

        Node cur;
        while(!queue.isEmpty()){
            cur = queue.poll();
            if(cur.x == endI && cur.y == endJ){
                return step[endI][endJ];
            }
            for (int i = 0; i < 4; i++) {
                int x = cur.x + direct[i][0];
                int y = cur.y + direct[i][1];
                if(check(x,y)){
                    queue.offer(new Node(x,y));
                    maze[x][y] = '#';
                    step[x][y] = step[cur.x][cur.y] + 1;
                }
            }
        }
        return step[endI][endJ];
    }
    public static boolean check(int x, int y){
        if(x>=0&&x<10&&y>=0&&y<10&&maze[x][y]=='.'){
            return true;
        }
        return false;
    }
}

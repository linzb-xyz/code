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
定义一个二维数组N*M（其中2<=N<=10;2<=M<=10），如5 × 5数组下所示：

int maze[5][5] = {
        0, 1, 0, 0, 0,
        0, 1, 0, 1, 0,
        0, 0, 0, 0, 0,
        0, 1, 1, 1, 0,
        0, 0, 0, 1, 0,

};

它表示一个迷宫，其中的1表示墙壁，0表示可以走的路，只能横着走或竖着走，不能斜着走，要求编程序找出从左上角到右下角的最短路线。入口点为[0,0],既第一空格是可以走的路。

Input
一个N × M的二维数组，表示一个迷宫。数据保证有唯一解,不考虑有多解的情况，即迷宫只有一条通道。

Output
左上角到右下角的最短路径，格式如样例所示。

Sample Input
0 1 0 0 0
0 1 0 1 0
0 0 0 0 0
0 1 1 1 0
0 0 0 1 0

Sample Output
(0, 0)
(1, 0)
(2, 0)
(2, 1)
(2, 2)
(2, 3)
(2, 4)
(3, 4)
(4, 4)

输入描述:
输入两个整数，分别表示二位数组的行数，列数。再输入相应的数组，其中的1表示墙壁，0表示可以走的路。数据保证有唯一解,不考虑有多解的情况，即迷宫只有一条通道。

输出描述:
左上角到右下角的最短路径，格式如样例所示。

示例1
输入:
5 5
0 1 0 0 0
0 1 0 1 0
0 0 0 0 0
0 1 1 1 0
0 0 0 1 0
输出:
(0,0)
(1,0)
(2,0)
(2,1)
(2,2)
(2,3)
(2,4)
(3,4)
(4,4)
https://www.nowcoder.com/practice/cf24906056f4488c9ddb132f317e03bc?tpId=37&&tqId=21266&rp=1&ru=/activity/oj&qru=/ta/huawei/question-ranking
 */
public class Maze {
    public static class Node{
        int x,y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int row, col;
    public static int[][] maze, visited;
    public static Node[][] path;
    public static int[][] direct = {{0,1},{0,-1},{1,0},{-1,0}};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            row = scanner.nextInt();
            col = scanner.nextInt();

            maze = new int[row][col];
            visited = new int[row][col];
            path = new Node[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    maze[i][j] = scanner.nextInt();
                }
            }
            bfs();
            printPath();

        }
    }

    public static void bfs(){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(row-1,col-1));
        visited[row-1][col-1] = 1;

        Node cur;
        while (!queue.isEmpty()){
            cur = queue.poll();
            if(cur.x == 0 && cur.y == 0){
                break;
            }

            for (int i = 0; i < 4; i++) {
                int x = cur.x + direct[i][0];
                int y = cur.y + direct[i][1];
                if(check(x, y)){
                    queue.offer(new Node(x,y));
                    visited[x][y] = 1;
                    path[x][y] = new Node(cur.x,cur.y);
                }
            }
        }
    }
    public static boolean check(int x, int y){
        if(x>=0&&x<row&&y>=0&&y<col&&visited[x][y]==0 && maze[x][y]==0){
            return true;
        }
        return false;
    }

    public static void printPath(){
        int x = 0, y = 0;
        while (!(x==row-1 && y ==col-1)){
            System.out.println("("+x+","+y+")");
            int temp_x = path[x][y].x;
            int temp_y = path[x][y].y;
            x = temp_x;
            y = temp_y;
        }
        System.out.println("("+x+","+y+")");
    }
}

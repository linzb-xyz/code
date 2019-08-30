import java.util.*;

/**
 * Copyright (c) 2017 XiaoMi Inc. All Rights Reserved.
 *
 * @author: linzebin <linzebin@xiaomi.com>
 * Created on 2019/8/5
 */
/*
题目描述
假设一个探险家被困在了地底的迷宫之中，要从当前位置开始找到一条通往迷宫出口的路径。
迷宫可以用一个二维矩阵组成，有的部分是墙，有的部分是路。
迷宫之中有的路上还有门，每扇门都在迷宫的某个地方有与之匹配的钥匙，只有先拿到钥匙才能打开门。
请设计一个算法，帮助探险家找到脱困的最短路径。
如前所述，迷宫是通过一个二维矩阵表示的，每个元素的值的含义如下 0-墙，1-路，2-探险家的起始位置，3-迷宫的出口，大写字母-门，小写字母-对应大写字母所代表的门的钥匙

输入描述:
迷宫的地图，用二维矩阵表示。第一行是表示矩阵的行数和列数M和N
后面的M行是矩阵的数据，每一行对应与矩阵的一行（中间没有空格）。M和N都不超过100, 门不超过10扇。

输出描述:
路径的长度，是一个整数

示例1
输入
5 5
02111
01a0A
01003
01001
01111

输出
7

*/
public class Maze3 {
    static class Node{
        int x,y;
        char c;
        int key;
        int step;

        public Node(int x, int y, char c, int key, int step) {
            this.x = x;
            this.y = y;
            this.c = c;
            this.key = key;
            this.step = step;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x &&
                    y == node.y &&
                    c == node.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, c);
        }
    }

    static int m, n;
    static char[][] maze;
    static int[][][] visited;
    static Node start, end;
    static int[][] direct = {{0,1},{0,-1},{1,0},{-1,0}};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            m = scanner.nextInt();
            n = scanner.nextInt();
            maze = new char[m][n];
            visited = new int[m][n][1025];
            for (int i = 0; i < m; i++) {
                    maze[i] = scanner.next().toCharArray();
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (maze[i][j]=='2') {
                        start = new Node(i,j,'2',0,0);
                        System.out.println(bfs(start));
                        break;
                    }
                }
            }
        }
    }
    
    public static int bfs(Node start){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(start);
        visited[start.x][start.y][start.key] = 1;

        Node cur;
        while (!queue.isEmpty()){
            cur = queue.poll();
            if(cur.c == '3'){
                return cur.step;
            }
            for (int i = 0; i < 4; i++) {
                int x = cur.x + direct[i][0];
                int y = cur.y + direct[i][1];
                int key = cur.key;
                if(check(x,y)){
                    if(maze[x][y] >='a' && maze[x][y] <= 'z'){
                        key = key | (1<<(maze[x][y]-'a'));
                    }
                    if(maze[x][y] >='A' && maze[x][y] <= 'Z' && (key&(1<<(maze[x][y]-'A'))) == 0 ){
                        continue;
                    }
                    if(visited[x][y][key] == 0){
                        visited[x][y][key] = 1;
                        queue.offer(new Node(x,y,maze[x][y],key,cur.step+1));
                    }
                }
            }
        }
        return -1;
    }

    public static boolean check(int i,int j){
       if(i>=0&&i<m&&j>=0&&j<n){
           if(maze[i][j] != '0'){
               return true;
           }
       }
       return false;

    }
}

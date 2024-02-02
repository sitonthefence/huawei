package NK;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static int n;
    static int[][] matrix;
    static int[][] candy;
    static int[][] offsets = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        matrix = new int[n][n];
        candy = new int[n][n];

        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                candy[i][j] = -1;

                matrix[i][j] = sc.nextInt();
                // 妈妈的位置
                if (matrix[i][j] == -3) {
                    candy[i][j] = 0;
                    queue.add(i * n + j); // 二维坐标一维化
                }
            }
        }

        // 记录题解
        int ans = -1;

        // bfs 按层扩散
        while (queue.size() > 0) {
            // 记录当前扩散层的点
            LinkedList<Integer> newQueue = new LinkedList<>();

            // 当前层是否有宝宝所在的点
            boolean flag = false;

            for (int pos : queue) {
                // 源点坐标
                int x = pos / n;
                int y = pos % n;

                // 向四个方向扩散
                for (int[] offset : offsets) {
                    // 当前扩散点坐标
                    int newX = x + offset[0];
                    int newY = y + offset[1];

                    // 当前扩散点坐标越界，或者扩散点是墙，则无法扩散
                    if (newX < 0 || newX >= n || newY < 0 || newY >= n || matrix[newX][newY] == -1) continue;

                    // 当前扩散点坐标对应的糖果数量为-1，说明对应扩散点坐标位置还没有加入到当前扩散层
                    if (candy[newX][newY] == -1) {
                        newQueue.addLast(newX * n + newY); // 加入当前扩散层
                    }

                    // 当前扩散点可能会被多个源点扩散到，因此比较保留扩散过程中带来的较大糖果数
                    // candy[newX][newY] 记录的是当前扩散点获得的糖果数
                    // candy[x][y] + Math.max(0, matrix[newX][newY]) 记录的是从源点(x,y)带来的糖果数 + (newX,newY)位置原本的糖果数
                    candy[newX][newY] =
                            Math.max(candy[newX][newY], candy[x][y] + Math.max(0, matrix[newX][newY]));

                    // 如果当前扩散点是宝宝位置，则可以停止后续层级的bfs扩散，因为已经找到宝宝的最短路径长度（即扩散层数）
                    if (matrix[newX][newY] == -2) {
                        ans = candy[newX][newY];
                        flag = true;
                    }
                }
            }

            // 已经找到去宝宝位置的最短路径和最大糖果数，则终止bfs
            if (flag) break;

            // 否则继续
            queue = newQueue;
        }

        System.out.println(ans);
    }
}
package NK;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main1 {
    public static void main(String[] args) {
        // 创建Scanner对象以读取用户输入
        Scanner scanner = new Scanner(System.in);

        // 读取测试数据组数
        int testCases = scanner.nextInt();
        // 创建一个二维数组来存储每组测试数据
        int[][] inputData = new int[testCases][];

        // 读取每组测试数据
        for (int i = 0; i < testCases; i++) {
            // 读取线段数量
            int segments = scanner.nextInt();
            // 创建一个数组来存储线段长度
            int[] lengths = new int[segments];
            // 读取每条线段的长度
            for (int j = 0; j < segments; j++) {
                lengths[j] = scanner.nextInt();
            }
            // 将线段长度数组存入inputData数组
            inputData[i] = lengths;
        }

        // 遍历每组测试数据
        for (int[] lengths : inputData) {
            // 对线段长度进行升序排序
            Arrays.sort(lengths);
            // 调用nonRecursiveDFS函数并输出结果
            System.out.println(nonRecursiveDFS(lengths));
        }
    }

    public static int nonRecursiveDFS(int[] lengths) {
        int maxTriangles = 0;
        boolean[] usedSegments = new boolean[lengths.length];
        Stack<State> stack = new Stack<>();
        stack.push(new State(0, 0, usedSegments));

        // 遍历状态栈
        while (!stack.isEmpty()) {
            State currentState = stack.pop();
            int currentIndex = currentState.index;
            int currentCount = currentState.count;
            usedSegments = currentState.used.clone();

            maxTriangles = Math.max(maxTriangles, currentCount);

            // 遍历线段数组，从currentIndex开始
            for (int i = currentIndex; i < lengths.length; i++) {
                if (usedSegments[i]) continue;
                for (int j = i + 1; j < lengths.length; j++) {
                    if (usedSegments[j]) continue;
                    for (int k = j + 1; k < lengths.length; k++) {
                        if (usedSegments[k]) continue;

                        // 检查当前三条线段是否满足勾股定理
                        if (lengths[i] * lengths[i] + lengths[j] * lengths[j] == lengths[k] * lengths[k]) {
                            boolean[] newUsedSegments = usedSegments.clone();
                            newUsedSegments[i] = true;
                            newUsedSegments[j] = true;
                            newUsedSegments[k] = true;
                            stack.push(new State(i + 1, currentCount + 1, newUsedSegments));
                        }
                    }
                }
            }
        }

        return maxTriangles;
    }

    // State类用于存储每个状态的信息，包括当前索引、已找到的直角三角形数量和已使用的线段
    static class State {
        int index;
        int count;
        boolean[] used;

        State(int index, int count, boolean[] used) {
            this.index = index;
            this.count = count;
            this.used = used;
        }
    }
}



package NK;

import java.util.Scanner;
import java.util.Stack;

public class HJ43 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int m = in.nextInt();
            int n = in.nextInt();
            int[][] arr = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = in.nextInt();
                }
            }
            Stack<String> stack =new Stack<>();
            getWay(arr,0,0,m,n,stack);
  while (!stack.isEmpty()){
      System.out.println(stack.pop());
  }

        }
    }

    public static boolean getWay(int[][] arr, int i, int j, int m, int n, Stack<String> stack) {
        if (arr[m - 1][n - 1] == 2) {
            stack.push("("+i+","+j+")");
            return true;
        } else {
            if (arr[i][j] == 0) {
                arr[i][j] = 2;
                if (i - 1 >= 0 && getWay(arr, i - 1, j, m, n,stack)) {
                    stack.push("("+i+","+j+")");
                    return true;
                } else if (j + 1 < n && getWay(arr, i, j + 1, m, n,stack)) {
                    stack.push("("+i+","+j+")");
                    return true;
                } else if (i + 1 < m && getWay(arr, i + 1, j, m, n,stack)) {
                    stack.push("("+i+","+j+")");
                    return true;
                } else if (j - 1 >= 0 && getWay(arr, i, j - 1, m, n,stack)) {
                    stack.push("("+i+","+j+")");
                    return true;
                } else {
                    arr[i][j] = 3;
                    return false;
                }
            } else {// 2说明 走过了 没必要走，3说明走过了没走通
                return false;

            }
        }
    }
}
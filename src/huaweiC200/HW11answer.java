package huaweiC200;
import java.util.LinkedList;
import java.util.Scanner;

public class HW11answer {
    private static final Scanner in = new Scanner(System.in).useDelimiter("[,\\n]");

    public static void main(String[] args) {
        int n = in.nextInt();
        String[][] matrix = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = in.next();
            }
        }
        String target = in.next();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                LinkedList<Integer[]> path = new LinkedList<>();
                if (dfs(i, j, 0, path, n, matrix, target)) {
                    printPath(path);
                    return;
                }
            }
        }

        System.out.println("N");
    }

    private static boolean dfs(int i, int j, int k, LinkedList<Integer[]> path,
                               int n, String[][] matrix, String target) {
        if (i < 0 || i >= n || j < 0 || j >= n ||
                !target.substring(k, k + 1).equals(matrix[i][j])) {
            return false;
        }

        path.add(new Integer[] {i, j});
        if (path.size() == target.length()) {
            return true;
        }

        String tmp = matrix[i][j];
        matrix[i][j] = null;

        boolean res = dfs(i - 1, j, k + 1, path, n, matrix, target)
                || dfs(i + 1, j, k + 1, path, n, matrix, target)
                || dfs(i, j - 1, k + 1, path, n, matrix, target)
                || dfs(i, j + 1, k + 1, path, n, matrix, target);

        if (!res) {
            matrix[i][j] = tmp;
            path.removeLast();
        }

        return res;
    }

    private static void printPath(LinkedList<Integer[]> path) {
        StringBuilder result = new StringBuilder();
        for (Integer[] pos : path) {
            result.append(pos[0]).append(",").append(pos[1]).append(",");
        }
        System.out.println(result.substring(0, result.length() - 1));
    }
}



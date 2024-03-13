package LC;

public class LC85最大矩形 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int res = 0;
        // 代表宽度
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = j == 0 ? 1 : dp[i][j - 1] + 1;
                    int width = dp[i][j];
                    for (int m = i; m >= 0 && matrix[m][j] == '1'; m--) {
                        width = Math.min(width, dp[m][j]);
                        res = Math.max(res, width * (i - m + 1));
                    }
                }
            }
        }
        return res;
    }

}

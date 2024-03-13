package LC;

public class LC48旋转图像 {
    public void rotate(int[][] matrix) {
        int[][] temp=new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                temp[j][matrix.length-1-i]=matrix[i][j];
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j]=temp[i][j];
            }
        }
    }
}

package mianshi;

public class MS3 {
    public static void main(String[] args) {
        int[][] matrix={{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);


    }

    public static void rotate(int[][] matrix) {
         int[][] temp=new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                temp[j][matrix.length-1-i]=matrix[i][j];
            }
        }
       matrix=temp;
/*        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j]=temp[i][j];
            }
        }*/
        System.out.println();


    }

}

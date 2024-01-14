package huaweiC200;

import java.util.Scanner;

public class HW44 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int row = in.nextInt();
            int column = in.nextInt();
            int[][] matrix=new int[row][column];
            for (int i = 0; i <row ; i++) {
                for (int j = 0; j <column ; j++) {
                    matrix[i][j]=in.nextInt();
                }
            }
            int total=in.nextInt();
            int[] count=new int[1000];
            for (int i = 0; i < total; i++) {
                count[in.nextInt()]++;
            }
            int left=0;
            int right=0;
            int min=Integer.MAX_VALUE;
            while (right<column){
                for (int i = 0; i < row; i++) {
                    int num=matrix[i][right];
                    if(count[num]>0){
                        count[num]--;
                        total--;
                    }else {
                        count[num]--;
                    }
                }
                while (total==0){
                    min=Math.min(min,right-left+1);
                    for (int i = 0; i < row; i++) {
                        int num=matrix[i][left];
                        if(count[num]<0){

                            count[num]++;
                        }else {
                            total++;
                            count[num]++;

                        }
                    }
                    left++;
                }
                right++;
            }
            if(min==Integer.MAX_VALUE){
                System.out.println(-1);
            }else {
                System.out.println(min);
            }
        }


    }
}

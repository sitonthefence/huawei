package huaweiC200;

import java.util.Scanner;

public class HW44TWO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int row = in.nextInt();
        int column = in.nextInt();
        int[][] matrix=new int[row][column];
        for (int i = 0; i <row ; i++) {
            for (int j = 0; j <column ; j++) {
                matrix[i][j]=in.nextInt();
            }
        }
        int total=in.nextInt();
        int [] count=new int[1000];
        for (int i = 0; i < total; i++) {
            count[in.nextInt()]++;
        }
        int left=0;
        int right=0;
        int min=Integer.MAX_VALUE;
        while (right<column){
            for (int i = 0; i <row ; i++) {
                int temp = matrix[i][right];
                if(count[temp]>0) total--;
                count[temp]--;

            }
            while (total==0){
                if(right-left+1<min){
                    min=right-left+1;
                }
                for (int i = 0; i <row ; i++) {
                    int temp=matrix[i][left];
                    if(count[temp]>=0)  total++;
                    count[temp]++;
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

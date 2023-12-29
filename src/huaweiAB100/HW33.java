package huaweiAB100;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HW33 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int length = in.nextInt();
            int[][] arr=new int[length][3];
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < 3; j++) {
                    arr[i][j]=in.nextInt();
                }
            }
            int sum=0;
            int row0MinIndex=-1;
            if(arr[0][0]<arr[0][1]){
                if (arr[0][0]<arr[0][2]){
                    row0MinIndex=0;
                }
            }
            if(arr[0][1]<arr[0][0]){
                if (arr[0][1]<arr[0][2]){
                    row0MinIndex=1;
                }
            } else {
                row0MinIndex = 2;
            }
            List<Integer> list=new ArrayList<>();
            list.add(row0MinIndex);
            int min=arr[0][row0MinIndex];
            for (int i = 1; i <length; i++) {
                list.add(getMinIndex(arr, list.get(i-1),i));
                min=min+arr[i][list.get(i)];
            }
            System.out.println(min);
        }
    }
    public static  int getMinIndex(int[][] arr,int frontMinIndex,int row){
        int MinIndex=-1;
           if(frontMinIndex==0){
               int rowMin=Math.min(arr[row][1],arr[row][2]);
               MinIndex=arr[row][1]==rowMin? 1:2;
           }else if(frontMinIndex==1){
               int rowMin=Math.min(arr[row][0],arr[row][2]);
               MinIndex=arr[row][0]==rowMin? 0:2;
           }else {
               int rowMin=Math.min(arr[row][0],arr[row][1]);
               MinIndex=arr[row][0]==rowMin? 0:1;
           }
           return MinIndex;
    }
}

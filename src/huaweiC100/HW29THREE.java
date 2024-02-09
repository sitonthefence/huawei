package huaweiC100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class HW29THREE {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int minAverageLost = Integer.parseInt(in.nextLine());
        int[] arr = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] preSum=new int[arr.length+1];
        for (int i = 1; i <preSum.length ; i++) {
            preSum[i]=preSum[i-1]+arr[i-1];
        }

        List<int[]> result=new ArrayList<>();
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i; j <arr.length ; j++) {
                if(preSum[j+1]-preSum[i]<=minAverageLost*(j-i+1)){
                    int currentLength=j-i+1;
                    if(currentLength>max){
                        max=currentLength;
                        result=new ArrayList<>();
                        result.add(new int[]{i,j});
                    }else if(currentLength==max){
                        result.add(new int[]{i,j});
                    }
                }

            }

        }
        if(result.size()==0){
            System.out.println("NULL");
        }

        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i)[0]+"-"+result.get(i)[1]+" ");
        }






    }
    public static int getSum( int[] arr,int start,int end){
        int sum=0;
        for (int i = start; i <=end ; i++) {
            sum+=arr[i];
        }

       return sum;
    }

}

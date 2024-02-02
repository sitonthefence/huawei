package huaweiC100;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HW29TWO {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int minAverageLost = Integer.valueOf(in.nextLine());
        String source = in.nextLine();
        String[] split = source.split(" ");
        int[] arr = new int[split.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.valueOf(split[i]);
        }
        int[] preSum=new int[arr.length+1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i]=preSum[i-1]+arr[i-1];
        }
        List<int[]> result=new ArrayList<>();
        int maxLength=Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int currentLost=preSum[j+1]-preSum[i];
                int currentLength=j-i+1;
                if(currentLost<=minAverageLost*currentLength){
                    if(currentLength == maxLength){
                        result.add(new int[]{i,j});
                    }else if(currentLength>maxLength){
                        maxLength=currentLength;
                        result=new ArrayList<>();
                        result.add(new int[]{i,j});
                    }

                }
            }

        }
        if(result.size()==0){
            System.out.println("NULL");
            return;
        }
        for (int[] ints : result) {
            System.out.print(ints[0]+"-"+ints[1]+" ");
        }

    }
}

package huaweiAB100;

import java.util.Scanner;

public class HW54TWO {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String source = in.nextLine();
            String[] split = source.split(",");
            int max=Integer.MIN_VALUE;
            for (int i = 0; i < split.length-1; i++) {
                for (int j = i+1; j <split.length ; j++) {
                    int result = (j-i)
                            * findMin(split,i,j);
                    max=Math.max(max,result);
                }
            }
            System.out.println(max);
        }
    }
    public static int findMin( String[] split,int left,int right){
             int min=Integer.MAX_VALUE;
        for (int i = left; i <=right ; i++) {
            Integer integer = Integer.valueOf(split[i]);
            min=Math.min(min,integer);
        }
        return min;
    }
}

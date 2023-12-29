package huaweiAB100;

import java.util.Scanner;

public class HW71 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String source = in.nextLine();
            String[] split = source.split(",");
            int max=0;
            for (int i = 0; i < split.length; i++) {
                if (Integer.valueOf(split[i])!=1){
                    max=Math.max(getInstance(split,i),max);
                }
            }
            System.out.println(max);
        }
    }
    public static int getInstance(String[] arr ,int index){
        if (index==0||index==arr.length-1){
            return 0;
        }
        int left=0;
        int right=0;
        for (int i = index-1; i >=0 ; i--) {
            if(Integer.valueOf(arr[i])==1){
                left=i;
                break;
            }
        }
        for (int i = index+1; i <arr.length ; i++) {
            if(Integer.valueOf(arr[i])==1){
                right=i;
                break;
            }
        }
        return Math.min(index-left,right-index);
    }

}

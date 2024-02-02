package huaweiC200;

import java.util.Arrays;
import java.util.Scanner;

public class HW7TWO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-->0){
            int length = in.nextInt();
            int arr[] =new int[length];
            for (int i = 0; i < length; i++) {
                arr[i]=in.nextInt();
            }
            Arrays.sort(arr);
            System.out.println(getNum(arr,0));
        }



    }
    public static int getNum(int arr[],int index){
        int result=0;
        for (int i = 0; i <arr.length-2 ; i++) {
            int x=arr[i];
            if(arr[i]==0) continue;

            for (int j = i+1; j < arr.length-1; j++) {
                int y=arr[j];
                if(arr[j]==0) continue;

                for (int k = j+1; k <arr.length ; k++) {
                    int z=arr[k];
                    if(arr[k]==0) continue;

                    if(x*x+y*y==z*z) {
                        arr[i]=arr[j]=arr[k]=0;
                        result=Math.max(result,getNum(arr,index+1)+1);
                       arr[i]=x;
                       arr[j]=y;
                       arr[k]=z;
                    }

                }
            }
        }
        return result;



    }
}

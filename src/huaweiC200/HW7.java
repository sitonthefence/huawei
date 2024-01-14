package huaweiC200;

import java.util.Arrays;
import java.util.Scanner;

public class HW7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-->0){
            int N = in.nextInt();
            int arr[] =new int[N];
            for (int i = 0; i < N; i++) {
                arr[i]=in.nextInt();
            }
            //要排序，原因?
            Arrays.sort(arr);
            System.out.println(getCount(arr, 0));
        }
    }
     public static int getCount(int arr[],int index){
        int result=0;
         for (int i = index; i < arr.length-2; i++) {
             int x=arr[i];
             if(arr[i]==0) continue;
             for (int j = i+1; j < arr.length-1; j++) {
                 int y=arr[j];
                 if(arr[j]==0) continue;
                 for (int k = j+1; k < arr.length ; k++) {
                     int z=arr[k];
                     if(arr[k]==0) continue;
                    if(arr[i]*arr[i]+arr[j]*arr[j]==arr[k]*arr[k]){
                        arr[i]=arr[j]=arr[k]=0;
                        result=Math.max(result,getCount(arr,index+1)+1);
                        arr[i]=x;arr[j]=y;arr[k]=z;
                        if (result==3){
                            return result;
                        }
                    }
                 }
             }
         }
         return  result;
     }
}

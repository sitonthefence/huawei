package huaweiC100;

import java.util.Scanner;

public class HW28 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String source = in.next();
            char[] arr = source.toCharArray();
            for (int i = 0; i < arr.length-1; i++) {
                char min='\uffff';
                int index=-1;
                for (int j =arr.length-1; j >=i+1 ; j--) {
                      if(arr[j]<min){
                          min=arr[j];
                          index=j;
                      }
                }
               if(index!=-1&&arr[i]>arr[index]){
                   char temp=arr[index];
                   arr[index]=arr[i];
                   arr[i]=temp;
                   break;
               }
            }
            for (char c : arr) {
                System.out.print(c);
            }

        }
    }
}

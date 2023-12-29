package huaweiAB200;

import java.util.ArrayDeque;
import java.util.Scanner;

public class HW60 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String source = in.nextLine();
        String[] split = source.split(" ");
       int[] arr=new int[split.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=Integer.valueOf(split[i]);
            if(arr[i]==0){
                System.out.println(-1);
                return;
            }
        }
        ArrayDeque<Integer> arrayDeque=new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            boolean status=true;
            while (status&&arr[i]<0&&!arrayDeque.isEmpty()&&arrayDeque.peekLast()>0){
                status=arrayDeque.peekLast()<-arr[i];
                if(arrayDeque.peekLast()<=-arr[i]){
                    arr[i]=arr[i]+arrayDeque.pollLast();
                }else {
                    arrayDeque.offerLast(arrayDeque.pollLast()+arr[i]);
                }
            }
            if(status){
                arrayDeque.offerLast(arr[i]);
            }
        }


            System.out.println(arrayDeque.size());






        }






}

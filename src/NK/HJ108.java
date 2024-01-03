package NK;

import java.util.Scanner;

public class HJ108 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int temp=Math.max(a,b);


        while(temp%a!=0||temp%b!=0){
          temp++;
        }
        System.out.println(temp);


    }






}

package NK;

import java.util.Scanner;

public class HJ91 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int m = in.nextInt();
            int n = in.nextInt();
            System.out.println(f(m,n));

        }

    }

    public static int f(int m,int n){

        if(m==0||n==0){
            return 1;
        }
        return   f(m-1,n)+f(m,n-1);

    }
}

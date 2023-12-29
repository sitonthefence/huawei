package huaweiAB100;

import java.util.Scanner;

public class HW12 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int source = in.nextInt();
            System.out.println(f(source));
        }


    }

    private static int f(int source) {
      if (source==0||source==1){
          return 1;
        }
      if (source==2){
          return 1;

      }
      return f(source-1)+f(source-3);


    }
}

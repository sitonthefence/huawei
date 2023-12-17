package NK;

import java.util.Scanner;

public class HJ107 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextDouble()){
            double source = in.nextDouble();
            double num=source>0? source: -source;
            double tempt=0;
      while(tempt*tempt*tempt<num){
           tempt++;
      }
      double left=tempt-1;
      double right=tempt;

     double middle=(left+right)/2;

      while (right-left>0.1){


        if(middle*middle*middle<num){
            left=middle;
        }else if (middle*middle*middle>num){
              right=middle;}

          else {
            if(num<0){
                middle=-middle;
            }
            System.out.println(String.format("%.1f",middle));
        }
          middle=(left+right)/2;

        }
            if(source<0){
                middle=-middle;
            }
            System.out.println(String.format("%.1f",middle));

        }


    }

}

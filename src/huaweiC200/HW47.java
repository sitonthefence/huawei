package huaweiC200;

import java.util.Scanner;

public class HW47 {
    static  class Fraction{
        int fa;
        int ch;
        public Fraction() {
        }

        public Fraction(int fa, int ch) {
            this.fa = fa;
            this.ch = ch;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String source = in.nextLine();
            int i=0;
            while (i<source.length()){



                if()




            }








        }



    }
    public static int maxNum(int x,int y){
        while (y!=0){
            int temp=y;
            y=x%y;
            x=temp;
        }
        return x;

    }
}

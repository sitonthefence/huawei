package NK;

import java.util.Scanner;

public class HJ61 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int appleNum=in.nextInt();
            int plateNum = in.nextInt();
            System.out.println(f(appleNum, plateNum));
        }
    }
    public static  int  f(int appleNum,int plateNum){
        if(appleNum==1||plateNum==1){
            return 1;
        }
        if (appleNum==0||plateNum==0){
            return 1;
        }
        if(appleNum<plateNum){
            return f(appleNum,appleNum);
        }
        else {

            return  f(appleNum,plateNum-1)+f(appleNum-plateNum,plateNum);
        }



    }




}

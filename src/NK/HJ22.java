package NK;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HJ22 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> list=new ArrayList<>();
        while(in.hasNextInt()){
            int i = in.nextInt();
            if(i==0){
                break;
            }
            int result=0;
            while ((i/3)!=0){
                result=i/3+result;
                i=i-i/3*3+i/3;
            }
            if(i==2){
                result++;
            }
            list.add(result);
        }
        for (Integer temp:
             list) {
            System.out.println(temp);

        }



    }

}

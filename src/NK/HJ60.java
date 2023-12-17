package NK;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HJ60 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int source = in.nextInt();
            List<Integer> list=new ArrayList<>();
            list.add(1);
            list.add(2);
            for(int i=3;i<source;i++){ //小于n的 素数
                int flag=0;
                for (int j=2;j<i;j++){
                    if(i%j==0){
                       flag=1;
                     break;
                    }
                }
                if (flag==0){
                    list.add(i);
                }
            }
            int min=Integer.MAX_VALUE;
            for (int i = 0; i < list.size()-1; i++) {
                for (int j = i; j <list.size() ; j++) {
                    if (list.get(i)+list.get(j)==source){

                        min=Math.min(min,list.get(j)-list.get(i));
                    }

                }
            }
            System.out.println((source-min)/2);
            System.out.println((source+min)/2);


        }

    }


}

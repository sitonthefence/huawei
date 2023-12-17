package NK;

import java.util.Scanner;

public class HJ6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
       while (in.hasNext()){
           long source = in.nextLong();
            long i=2;
            while (source!=1){
                if(source%i==0){
                    System.out.print(i+" ");
                    source=source/i;
                }else {
                    if(i>Math.sqrt(source)){
                      i=source;
                    }else {
                        i++;
                    }
                }

           }
       }
    }
}

package huaweiAB100;

import java.util.Scanner;

public class HW49 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            StringBuilder targetReverse = new StringBuilder(in.next()).reverse();
            StringBuilder sourceReverse = new StringBuilder(in.next()).reverse();

            int index=0;
            for (int i = 0; i < targetReverse.length(); i++) {
                boolean flag=false;
                for (int j = index; j < sourceReverse.length(); j++) {
                    if(targetReverse.charAt(i)==sourceReverse.charAt(j)){
                       index=j+1;
                        flag=true;

                        if(i==targetReverse.length()-1){
                            System.out.println(sourceReverse.length()-1-j);
                        }
                        break;
                    }
                }
                if (flag==false){
                    System.out.println(-1);
                    break;

                }



            }

        }
    }

}

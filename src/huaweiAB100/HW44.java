package huaweiAB100;

import java.util.Scanner;

public class HW44 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String source = in.nextLine();
            String[] split = source.split("[a-zA-Z]+");
            int max=0;
            for (int i = 0; i < split.length; i++) {
                int left=0;
                int right=0;
              while (right<split[i].length()-1){
                   for (int j = 1; j < split[i].length(); j++) {
                      if(split[i].charAt(right)>split[i].charAt(j)){
                          max=Math.max(right-left+1,max);
                          left=right+1;
                          right=left;

                      }else {
                          right++;
                      }
                  }
                  if (split[i].charAt(split[i].length()-1)>=split[i].charAt(split[i].length()-2)){
                       max=Math.max(split[i].length()-left,max);

                   }

               }

          }
            System.out.println(max);





            }




        }


    }


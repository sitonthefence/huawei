package NK;

import java.lang.annotation.ElementType;
import java.util.Scanner;
import java.util.regex.Pattern;

public class HJ87 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int total = 0;
            String source = in.nextLine();
            if (source.length() <= 4) {
                total += 5;
            } else if (source.length() >= 5 && source.length() <= 7) {
                total += 10;
            } else {
                total += 25;
            }
            Pattern compile1 = Pattern.compile("[a-z]");
            Pattern compile2 = Pattern.compile("[A-Z]");
            if (compile1.matcher(source).find() == true && compile2.matcher(source).find() == true) {
                total += 20;
            } else if ((compile1.matcher(source).find() == true ^ compile2.matcher(source).find() == true)) {
                total += 10;
            }

            int num1=0;
             for(int i=0;i<source.length();i++){
                 if((int)source.charAt(i)>='0'&&(int)source.charAt(i)<='9') {
                     num1++;
                 }
             }
             if(num1==1){
                 total+=10;
             }else if(num1>1){
                 total+=20;
             }

            int num2=0;
            for(int i=0;i<source.length();i++){
                if((int)source.charAt(i)>='!'&&(int)source.charAt(i)<='/'
                        ||(int)source.charAt(i)>=':'&&(int)source.charAt(i)<='@'
                        ||(int)source.charAt(i)>='['&&(int)source.charAt(i)<='`'
                        ||(int)source.charAt(i)>='{'&&(int)source.charAt(i)<='~') {
                    num2++;
                }
            }
            if(num2==1){
                total+=10;
            }else if(num2>1){
                total+=25;
            }

            Pattern compile7 = Pattern.compile("[a-zA-Z]");
            Pattern compile8 = Pattern.compile("[0-9]");
            Pattern compile9 = Pattern.compile("\\W");
            Pattern compile10 = Pattern.compile("[a-z]");
            Pattern compile11 = Pattern.compile("[A-Z]");
            if (compile7.matcher(source).find() == true && compile8.matcher(source).find() == true && compile9.matcher(source).find() == false) {
                total += 2;
            } else if (compile10.matcher(source).find() ^ compile11.matcher(source).find() == true && compile8.matcher(source).find() == true
                    && compile9.matcher(source).find() == true) {
                total += 3;
            } else if (compile10.matcher(source).find() && compile11.matcher(source).find() == true && compile8.matcher(source).find() == true
                    && compile9.matcher(source).find() == true) {
                total += 5;
            }
            if (total >= 90) {
                System.out.println("VERY_SECURE");
            } else if (total >= 80) {
                System.out.println("SECURE");
            } else if (total >=70) {
                System.out.println("VERY_STRONG");
            } else if (total >= 60) {
                System.out.println("STRONG");
            }else if (total >= 50) {
                System.out.println("AVERAGE");
            }else if (total >= 25) {
                System.out.println("WEAK");
            }else {
                System.out.println("VERY_WEAK");
            }


        }


    }
}

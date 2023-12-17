package NK;

import java.util.Scanner;

public class HJ106 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String source = scanner.nextLine();
            char[] chars = source.toCharArray();
            for (int i=0;i<(chars.length/2);i++){
                char temp=chars[i];
                chars[i]=chars[chars.length-i-1];
                chars[chars.length-i-1]=temp;

            }
            System.out.println(chars);


        }


    }



}

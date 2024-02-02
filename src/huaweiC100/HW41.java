package huaweiC100;


import java.util.Scanner;

public class HW41 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String source = in.next();
            String replace1 = source.replace(",", "");
            String replace2 = replace1.replace("111", "");
            int Car3 = (replace1.length() - replace2.length())/3;
            String replace3 = replace2.replace("11", "");
            int Car2=(replace2.length()-replace3.length())/2;
            String replace4 = replace3.replace("1", "");
            int Car1=replace3.length()-replace4.length();
            System.out.println(Car1 + Car2 + Car3);

        }
    }
}

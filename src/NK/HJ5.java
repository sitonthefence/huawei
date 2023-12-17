package NK;

import java.util.Scanner;

//坐标偏移
public class HJ5
{
    public static void main(String[] args) {
        Scanner str=new Scanner(System.in);
        while (str.hasNext()){
            String next = str.next();
            String substring = next.substring(2);
            Integer target = Integer.valueOf(substring, 16);
            System.out.println(target);
        }
    }
}

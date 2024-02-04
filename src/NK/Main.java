package NK;
import java.util.Scanner;

public class Main{

    public static int res = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        handle( m, true);

        System.out.println(res);
    }

    public static void handle(int x, Boolean isA){

        if(x < 7){
            //小于7则游戏结束了
            return;
        }

        if(x == 7){
            //此时B抢到7则加1
            if(!isA)
                res ++;
            return;
        }

        if(isA && x - 7 <3){
            //A选择的值与7相差不到3，则B能抢到
            res ++;
            return;
        }
        //根据题意报的数只能相差1或者2
        handle( x - 1, !isA);
        handle(x - 2, !isA);
    }

}
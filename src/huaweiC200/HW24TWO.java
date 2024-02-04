package huaweiC200;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class HW24TWO {
    // 输入输出处理
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] roomTimes = new int[n][2];
        for (int i = 0; i < n; i++) {
            roomTimes[i][0] = sc.nextInt();
            roomTimes[i][1] = sc.nextInt();
        }

        int[][] res = new HW24TWO ().merge(roomTimes);
        for (int[] time : res) {
            System.out.println(time[0] + " " + time[1]);
        }
    }

    // 本题实际考试时会核心代码模式，无需处理输入输出，只需要写出merge方法实现即可
    public int[][] merge(int[][] roomTimes) {
        List<int[]> answer=new ArrayList<>();
        Arrays.sort(roomTimes,(a,b)->a[0]-b[0]);
        int preLeft=roomTimes[0][0];
        int preRight=roomTimes[0][1];
        for (int i = 1; i <roomTimes.length ; i++) {
            int curLeft=roomTimes[i][0];
            int curRight=roomTimes[i][1];
            if(curLeft<=preRight){
                preRight=Math.max(preRight,curRight);
            }else {
                answer.add(new int[]{preLeft,preRight});
                preLeft=curLeft;
                preRight=curRight;

            }
        }
        answer.add(new int[]{preLeft,preRight});
        return answer.toArray(new int[0][]);


    }
}



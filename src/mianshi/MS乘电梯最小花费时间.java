package mianshi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MS乘电梯最小花费时间 {


    public static void main(String[] args) {
        //处理输入
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<n;i++) {
            list.add(in.nextInt());
        }
        //降序排序
        list.sort((o1,o2) -> o2.compareTo(o1));
        System.out.println(cal_time(n, k, 0, list));
        return;
    }

    public static int cal_time(int n, int k, int index, List<Integer> list) {
        if (n <= k) {
            return (list.get(index)-1) * 2;
        } else {
            return cal_time(k, k, index, list) + cal_time(n - k, k, index + k, list);
        }
    }

}
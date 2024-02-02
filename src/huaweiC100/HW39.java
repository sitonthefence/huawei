package huaweiC100;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class HW39 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
            int M = in.nextInt();
            Set<Integer> set=new TreeSet<>();
            for (int i = 0; i < M; i++) {
                int tmp=in.nextInt();
                if(tmp<0||tmp>1000){
                    System.out.println(-1);
                  return;
                }
                set.add(tmp);
            }
            int N = in.nextInt();
            //判断
            if(set.size()<2*N||N<0){
                System.out.println(-1);
                return;
            }
            LinkedList<Integer> list = new LinkedList<>(set);
            int sum=0;
            for (int i = 0; i < N; i++) {
                sum+=list.get(i)+list.get(list.size()-1-i);
            }
            System.out.println(sum);


        }

}

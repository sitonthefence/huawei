package huaweiC200;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HW10TWO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String source = in.next();
        int[] num=new int[source.length()];
        for (int i = 0; i < num.length; i++) {
            num[i]=source.charAt(i)-'0';
        }
        int k = in.nextInt();
        ArrayDeque<Integer> deque=new ArrayDeque<>();
        for (int i = 0; i < num.length; i++) {
            while (!deque.isEmpty()&&k>0&&num[i]< deque.peekLast()){
                deque.pollLast();
                k--;
            }
            deque.add(num[i]);
        }
        while (k>0){
            deque.pollLast();
            k--;
        }
        while (!deque.isEmpty()&&deque.peekFirst()==0){
            deque.pollFirst();
        }
        if(deque.size()==0){
            System.out.println(0);
            return;
        }
        List<Integer> ans=new ArrayList<>();
        while (!deque.isEmpty()){
            ans.add(deque.pollFirst());
        }
        for (Integer an : ans) {
            System.out.print(an);
        }





    }


}

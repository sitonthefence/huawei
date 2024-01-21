package huaweiC200;

import java.util.ArrayDeque;
import java.util.Scanner;

public class HW61 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String source1 = in.next();
        String[] split1 = source1.split(",");
        int[] input=new int[split1.length];
        for (int i = 0; i < input.length; i++) {
            input[i]=Integer.valueOf(split1[i]);
        }
        String source2 = in.next();
        String[] split2 = source2.split(",");
        int[] output=new int[split2.length];
        for (int i = 0; i < output.length; i++) {
            output[i]=Integer.valueOf(split2[i]);
        }
        ArrayDeque<Integer> deque=new ArrayDeque<>();
        StringBuilder stringBuilder=new StringBuilder();
        int index=0;
        for (int ball : input) {
            deque.offerLast(ball);
            while (!deque.isEmpty()){
                if(output[index]==deque.peekFirst()){
                    deque.pollFirst();
                    stringBuilder.append("L");
                    index++;

                }else if(output[index]==deque.peekLast()){
                    deque.pollLast();
                    stringBuilder.append("R");
                    index++;
                }else {
                 break;
                }
            }
        }
        if(deque.isEmpty()){
            System.out.println(stringBuilder);
        }else{
            System.out.println("NO");
        }
    }
}

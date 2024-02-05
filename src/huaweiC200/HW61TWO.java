package huaweiC200;

import java.util.*;

public class HW61TWO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] input = Arrays.stream(in.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int[] output = Arrays.stream(in.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> deque=new ArrayDeque<>();
        List<String> ans=new ArrayList<>();
        int index=0;
        for (int i : input) {
            deque.offerLast(i);
            while (!deque.isEmpty()){
                if(output[index]==deque.peekFirst()){
                    deque.pollFirst();
                    ans.add("L");
                    index++;
                }else if(output[index]==deque.peekLast()){
                    deque.pollLast();
                    ans.add("R");
                    index++;
                }else {
                    break;
                }
            }
        }
        if(ans.size()==input.length){
            ans.forEach(System.out::print);
        }else {
            System.out.println("NO");

        }

    }

}

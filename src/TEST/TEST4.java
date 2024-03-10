package TEST;

import java.util.ArrayDeque;

public class TEST4 {
    public static void main(String[] args) {
        int[] num=new int[]{8,2,4,4,4,9,5,2,5,8,8,0,8,6,9,1,1,6,3,5,1,2,6,6,0,4,8,6,0,3,2,8,7,6,5,1,7,0,3,4,8,3,5,9,0,4,0,1,0,5,9,2,0,7,0,2,1,0,8,2,5,1,2,3,9,7,4,7,0,0,1,8,5,6,7,5,1,9,9,3,5,0,7,5};
        boolean[] used=new boolean[num.length];
        ArrayDeque<int[]> deque=new ArrayDeque<>();
        deque.add(new int[]{0,num[0]});
        used[0]=true;
        while (!deque.isEmpty()){
            int[] ints = deque.pollLast();
            int index=ints[0];
            int step=ints[1];
            for (int i = 1; (i <=step)&&(index+i<num.length) ; i++) {
                deque.offerLast(new int[]{index+i,num[index+i]});
                used[index+i]=true;
            }
        }
        System.out.println(used[num.length-1]);


    }
}

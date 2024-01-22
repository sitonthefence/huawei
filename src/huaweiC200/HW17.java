package huaweiC200;

import java.util.*;

public class HW17 {
    static class NumCount{
        int num;
        int count;
        public NumCount(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
            String source1 = in.nextLine();
            String[] split1 = source1.split(" ");
            int[] nums=new int[split1.length];
            for (int i = 0; i < nums.length; i++) {
                nums[i]=Integer.valueOf(split1[i]);
            }
           int[] map=new int[split1.length+1];
            for (int i = 0; i < map.length-1; i++) {
                map[in.nextInt()]=i/3;
            }
            for (int i = 0; i < nums.length; i++) {
                nums[i]=map[ nums[i]];
            }
        Map<Integer, List<NumCount>>  block=new HashMap<>();
        LinkedList<NumCount> deque=new LinkedList<>();
        for (int num : nums) {
            if(deque.isEmpty()||deque.peekLast().num!=num){
                 deque.add(new NumCount(num,1));
                 block.putIfAbsent(num,new ArrayList<>());
                 block.get(num).add(deque.peekLast());

            }else {
                     deque.peekLast().count++;
            }
        }
        int adjustCount=0;
        while (!deque.isEmpty()){
            NumCount first = deque.pollFirst();
            if(first.count==0||first.count==3){
                continue;
            }
            if(deque.size()==0){
                break;
            }
            NumCount second = deque.peekFirst();
            while (second.count==0){
                deque.pollFirst();
                second=deque.peekFirst();
            }
            if(first.num==second.num){
                second.count+= first.count;
                continue;
            }
            if(first.count==2){
                adjustCount++;
                block.get(first.num).forEach(temp->temp.count=0);

            }else {
                if(block.get(first.num).size()==3){
                    adjustCount+=2;
                    block.get(first.num).forEach(temp->temp.count=0);

                }else {
                    adjustCount++;
                    block.get(first.num).forEach(temp->temp.count=3);
                }

            }

        }
        System.out.println(adjustCount);
    }
}

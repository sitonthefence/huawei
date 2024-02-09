package huaweiC200;

import java.util.*;

public class HW17TWO {
    static class NumCount{
        int num;
        int count=1;

        public NumCount(int num) {
            this.num = num;
        }
    }
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int[] nums = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] numMap=new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            numMap[in.nextInt()]=i/3;
        }
          nums=Arrays.stream(nums).map(t->numMap[t]).toArray();
        Map<Integer, List<NumCount>> map=new HashMap<>();
        LinkedList<NumCount> deque=new LinkedList<>();
        for (int num : nums) {
            if(deque.isEmpty()||deque.peekLast().num!=num){
                NumCount numCount = new NumCount(num);
                deque.add(numCount);
                map.putIfAbsent(num,new ArrayList<>());
                map.get(num).add(numCount);
            }else {
                deque.peekLast().count++;
            }
        }
        int adjustNum=0;
        while (!deque.isEmpty()){
            NumCount first = deque.pollFirst();
            if(first.count==0||first.count==3){
                continue;
            }
            if(deque.size()==0){
                break;
            }
            NumCount second = deque.peekFirst();
            while (second.count==0) {
                deque.pollFirst();
                second=deque.peekFirst();

            }
            //是count合并
            if(first.num==second.num){
                second.count+=first.count;
                continue;
            }
            if(first.num==2){
                adjustNum++;
                map.get(first.num).forEach(t->t.count=0);

            }else {
                 if(map.get(first.num).size()==3){
                     adjustNum+=2;
                     map.get(first.num).forEach(t->t.count=0);

                 }else {
                     adjustNum++;
                     map.get(first.num).forEach(t->t.count=3);
                 }
            }

        }
        System.out.println(adjustNum);







    }



}

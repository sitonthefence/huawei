package LC;

import java.util.Stack;

public class LC739每日温度 {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack=new Stack<>();
        int[] result=new int[temperatures.length];

            for (int i = 0; i < temperatures.length; i++) {
                while (!stack.isEmpty()&&temperatures[i]>temperatures[stack.peek()]){
                    result[stack.pop()]=i;
                }
             stack.push(i);
        }
            int[] answer=new int[temperatures.length];
        for (int i = 0; i <answer.length ; i++) {
            if(result[i]!=0){
                answer[i]=result[i]-i;
            }

        }

            return answer;
    }




}

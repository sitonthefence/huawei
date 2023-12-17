package NK;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NC60 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param numbers int整型一维数组
     * @param target int整型
     * @return int整型一维数组
     */

    public static void main(String[] args) {
        int [] a={3,2,4};
        int[] b = twoSum1(a, 6);
        for (int temp:
             b) {
            System.out.println(temp);
        }
    }



    public static int[] twoSum (int[] numbers, int target) {
        int [] a=new int[2];
         for(int i=0;i<numbers.length-1;i++ ){
             for (int j = i+1; j < numbers.length; j++) {
                  if (numbers[i]+numbers[j]==target){
                      a[0]=i+1;
                      a[1]=j+1;
                      return a;
                  }
             }
         }
        return a;
    }
    public static int[] twoSum1 (int[] numbers, int target) {
       int [] result={-1,-1};
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<numbers.length;i++){
            if(map.get(target-numbers[i])!=null){
                result[0]=map.get(target-numbers[i])+1;
                result[1]=i+1;
               return result;
            }else {
                map.put(numbers[i], i);
            }
        }
        return result;


    }







}

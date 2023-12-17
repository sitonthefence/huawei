package huawei100;

import java.util.*;

public class HW3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            Integer color = Integer.valueOf(in.nextLine());
            String source = in.nextLine();
            String[] split = source.split("\\s");
            int max=Integer.MIN_VALUE;
            Map<Integer,Integer> map=new HashMap<>();
            for (int i = 0; i < split.length; i++) {
                if(Integer.valueOf(split[i])==0){
              max=Math.max(getInstance(split,i,color),max);
               map.put(i,getInstance(split,i,color));
                }
            }
            List<Integer> list=new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if(entry.getValue()==max){
                    list.add(entry.getKey());
                }
            }
            list.sort((o1,o2)->{return Math.abs(o1-split.length/2)-Math.abs(o2-split.length/2);});
            System.out.println(list.get(0));
        }
    }
    public static int getInstance(String[] split,int index,int color){
            int left=0;
            int right= split.length-1;
          if(index!=0){
              for (int i = index-1; i >=0 ; i--) {
                  if(Integer.valueOf(split[i])!=color){

                      left=i+1;
                      break;
                  }
              }
          }
          if(index!=split.length-1){
              for (int i = index+1; i <split.length ; i++) {

                  if (Integer.valueOf(split[i]) != color) {

                      right = i - 1;
                      break;
                  }
              }

          }
               if(right-left>=5){
                   return 0;
            }else {
                   return right-left+1;

        }











    }


}

package huawei100;

import java.util.*;

public class HW58 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String source1 = in.next();
            String source2 = in.next();
            Map<Integer, Integer> map = new LinkedHashMap<>();
            for (int i = 3; i <= 14; i++) {
                map.put(i, 4);
            }
            String[] split1 = source1.split("-");
            for (String s : split1) {
                if (s.matches("[0-9]+")) {
                    map.put(Integer.valueOf(s), map.get(Integer.valueOf(s)) - 1);
                } else if (s.equals("J")) {
                    map.put(11, map.get(11) - 1);
                } else if (s.equals("Q")) {
                    map.put(12, map.get(12) - 1);
                } else if (s.equals("K")) {
                    map.put(13, map.get(13) - 1);
                } else if (s.equals("A")) {
                    map.put(14, map.get(14) - 1);
                }
            }
            String[] split2 = source2.split("-");
            for (String s : split2) {
                if (s.matches("[0-9]+")) {
                    map.put(Integer.valueOf(s), map.get(Integer.valueOf(s)) - 1);
                } else if (s.equals("J")) {
                    map.put(11, map.get(11) - 1);
                } else if (s.equals("Q")) {
                    map.put(12, map.get(12) - 1);
                } else if (s.equals("K")) {
                    map.put(13, map.get(13) - 1);
                } else if (s.equals("A")) {
                    map.put(14, map.get(14) - 1);
                }
            }
          List<Integer> list=new ArrayList<>();
            Set<Integer> integers = map.keySet();
            for (Integer integer : integers) {
                if(map.get(integer)!=0){
                    list.add(integer);
                }
            }
      //      System.out.println(list);
            int left=0;
            int right=0;
            int max=Integer.MIN_VALUE;
            int maxLeft=0;
            int maxRight=0;
            for (int i = 1; i <list.size() ; i++) {
                if(list.get(i)-list.get(right)>1){
                    if(right-left+1>=max){
                        maxRight=right;
                        maxLeft=left;
                        max=right-left+1;
                    }
                    left=right+1;
                    right=left;
                }else {
                    right++;
                }

            }
            if(list.get(list.size()-1)-list.get(list.size()-2)==1){
                if(right-left+1>=max){
                    maxRight=right;
                    maxLeft=left;
                    max=right-left+1;
                }
            }
            if(max<5){
                System.out.println("NO-CHAIN");
                continue;
            }
            StringBuilder stringBuilder=new StringBuilder();
            for (int i = left; i <= right; i++) {
              if(list.get(i)==11){
                  stringBuilder.append("J").append("-");
              }else if(list.get(i)==12) {
                  stringBuilder.append("Q").append("-");
              }else if(list.get(i)==13) {
                  stringBuilder.append("K").append("-");
              }
              else if(list.get(i)==14) {
                  stringBuilder.append("A").append("-");
              }else {
                  stringBuilder.append(list.get(i)).append("-");
              }

            }
            System.out.println(stringBuilder.substring(0, stringBuilder.length() - 1));


        }
    }
}


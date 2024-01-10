package huaweiC200;

import java.util.*;

public class HW24 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String source = in.next();
            source = source.substring(1, source.length() - 1);
            String[] split = source.split("\\],\\[");
            Set<Integer> set=new TreeSet<>();
            for (int i = 0; i < split.length; i++) {
                for (int j = 0; j < split[i].length(); j++) {
                    if(split[i].startsWith("[")){
                        split[i]=split[i].substring(1,split[i].length());
                    }
                    if (split[i].endsWith("]")){
                        split[i]=split[i].substring(0,split[i].length()-1);
                    }
                    String[] split1 = split[i].split(",");
                    int a=Integer.valueOf(split1[0]);
                    int b=Integer.valueOf(split1[1]);
                    for (int k = a; k <=b ; k++) {
                      set.add(k);
                    }
                }
            }
              List<Integer> list=new ArrayList<>(set);
            list.add(26);
              int left=0;
              int right=0;
              StringBuilder stringBuilder=new StringBuilder();
              stringBuilder.append("[");
            for (int i = 1; i <list.size() ; i++) {
                if(list.get(i)-list.get(right)>1){
                    stringBuilder.append("["+list.get(left)+","+list.get(right)+"]");
                    left=i;
                }
                right++;
            }
            stringBuilder.append("]");
            System.out.println(stringBuilder);
            }
        }
    }


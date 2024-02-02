package huaweiAB100;

import java.util.*;
//注意 一个字符串比较 要用equal

public class HW50 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
            String source = in.nextLine();
            List<List<String>> lists=new ArrayList<>();
            String[] split = source.split(" ");
            if(split.length>999){
                System.out.println("ERROR");
                return;
            }
            for (int i = 0; i < split.length; i++) {
                String[] split1 = split[i].split("/");
                List<String> list=new ArrayList<>();
                if(Integer.valueOf(split1[0])<=0||Integer.valueOf(split1[0])>999){
                    System.out.println("ERROR");
                    return;
                }
                list.add(split1[0]);

                list.add(split1[1]);
                lists.add(list);
            }
            if(lists.get(0).get(1).equals("Y")){
                System.out.println("ERROR");
                return;
            }
            List<String> listA=new ArrayList<>();
            List<String> listB=new ArrayList<>();

          listA.add(lists.get(0).get(0));
          lists.get(0).add("A");
            for (int i =1 ; i <split.length ; i++) {
                if(lists.get(i).get(1).equals("Y")&&lists.get(i-1).get(2).equals("A")){
                   listA.add(String.valueOf(lists.get(i).get(0)));
                    lists.get(i).add("A");
                }else if(lists.get(i).get(1).equals("Y")&&lists.get(i-1).get(2).equals("B")){
                    listB.add(String.valueOf(lists.get(i).get(0)));
                    lists.get(i).add("B");
                }else if(lists.get(i).get(1).equals("N")&&lists.get(i-1).get(2).equals("A")){
                    listB.add(String.valueOf(lists.get(i).get(0)));
                    lists.get(i).add("B");

                }else {
                    listA.add(String.valueOf(lists.get(i).get(0)));
                    lists.get(i).add("A");
                }
            }
            Collections.sort(listA,(a,b)->Integer.valueOf(a)-Integer.valueOf(b));
            if(listB.size()==0){
                for (int i = 0; i < listA.size(); i++) {
                    System.out.print(listA.get(i)+" ");
                }
                return;
            }
        Collections.sort(listB,(a,b)->Integer.valueOf(a)-Integer.valueOf(b));
            if(Integer.valueOf(listA.get(0))<Integer.valueOf(listB.get(0))){
                for (int i = 0; i < listA.size(); i++) {
                    System.out.print(listA.get(i)+" ");
                }
                System.out.println();
                for (int i = 0; i < listB.size(); i++) {
                    System.out.print(listB.get(i)+" ");
                }
            }else {
                for (int i = 0; i < listB.size(); i++) {
                    System.out.print(listB.get(i)+" ");
                }
                System.out.println();
                for (int i = 0; i < listA.size(); i++) {
                    System.out.print(listA.get(i)+" ");
                }
            }

        }


}

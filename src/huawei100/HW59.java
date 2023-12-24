package huawei100;

import java.util.*;

public class HW59 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            Map<String,Integer> map=new HashMap<>();
            map.put("3",3);
            map.put("4",4);
            map.put("5",5);
            map.put("6",6);
            map.put("7",7);
            map.put("8",8);
            map.put("9",9);
            map.put("10",10);
            map.put("J",11);
            map.put("Q",12);
            map.put("K",13);
            map.put("A",14);
            map.put("2",-1);
            String source = in.nextLine();
            String[] split = source.split(" ");



            Arrays.sort(split,((o1, o2) -> map.get(o1)-map.get(o2)));


            int left=0;
            int right=0;
            int max=0;
            List<List<Integer>> list=new ArrayList<>();
            for (int i = 1; i <split.length ; i++) {
                if(map.get(split[i])-map.get(split[right])>1){
                    if(right-left+1>max){
                        max=right-left+1;
                        list.clear();
                        List<Integer> path=new LinkedList<>();
                        path.add(left);
                        path.add(right);
                        list.add(path);
                    }else if(right-left+1==max){
                        List<Integer> path=new LinkedList<>();
                        path.add(left);
                        path.add(right);
                        list.add(path);
                    }
                    left=right+1;
                    right=left;
                }else {
                    right++;
                }

            }
            if(map.get(split[split.length-1])-map.get(split[split.length-2])==1){
                if(right-left+1>max){
                    max=right-left+1;
                    list.clear();
                    List<Integer> path=new LinkedList<>();
                    path.add(left);
                    path.add(right);
                    list.add(path);
                }else if(right-left+1==max){
                    List<Integer> path=new LinkedList<>();
                    path.add(left);
                    path.add(right);
                    list.add(path);
                }
            }
            System.out.println(list);

    /*        for (int i = 0; i < list.size(); i++) {
                for (int j= 0; j < list.get(i).size(); i++) {
                    System.out.print(list.get(i).get(j)+" ");

                }
                System.out.println();
            }*/

        }

    }
}

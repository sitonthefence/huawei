package huaweiC200;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class HW48TWO {
    static List<LinkedList<Integer>> result;
    static  LinkedList<Integer> path;
   static   int[] arr1;
   static boolean[] used;
   static int max=0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] split1 = in.nextLine().split(" ");
         arr1=new int[split1.length];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i]=Integer.parseInt(split1[i]);
        }

        String[] split2 = in.nextLine().split(" ");
        List<Integer> list2=new ArrayList<>();
        for (int i = 0; i < split2.length; i++) {
            list2.add(Integer.parseInt(split2[i]));
        }
        result=new ArrayList<>();
        path=new LinkedList<>();
        used=new boolean[arr1.length];
        dfs();
        int answer=0;
        for (int i = 0; i < result.size(); i++) {
            int count = compare(result.get(i), list2);

            if(count>max){
                max=count;
                answer=1;
            }else if(count==max) {
                answer++;
            }

        }
        System.out.println(answer);



    }
    public  static void dfs (){
        if(path.size()==arr1.length){
            result.add(new LinkedList<>(path));
            return;
        }
        for (int i = 0; i <arr1.length ; i++) {
            if(used[i]) continue;
            used[i]=true;
            path.add(arr1[i]);
            dfs();
            path.pollLast();
            used[i]=false;
        }


    }


    public static int compare(List<Integer> list1,List<Integer> list2){
      int count=0;
        for (int i = 0; i < list1.size(); i++) {
            if(list1.get(i)>list2.get(i)){
                count++;
            }
        }
        return count;


    }




}

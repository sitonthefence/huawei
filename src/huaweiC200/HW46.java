package huaweiC200;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class HW46 {
   static List<Pair> list=new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();

        for (int i = 0; i < length; i++) {
            String state = in.next();
            String[] split = state.split("=");
            if(split[0].equals("REQUEST")){
                requestMemory(Integer.parseInt(split[1]));
            }else {
              releaseMemory(Integer.parseInt(split[1]));

            }
        }
    }
    public static void requestMemory(int request){
        if(request==0){
            System.out.println("error");
            return;
        }
        if(list.size()==0&&request<=100){
            list.add(new Pair(0,request-1));
            System.out.println(0);
            return;
        }
        if(list.size()==0&&request>100){
            System.out.println("error");
            return;
        }
        //这个要写
        int index=-1;
        int currentLength;
        for (int i = 0; i < list.size(); i++) {

            if(i==0){
                currentLength=list.get(0).left;
                if(currentLength>=request){
                    list.add(new Pair(0,request-1));
                    Collections.sort(list,(o1,o2)->o1.left-o2.left);
                    System.out.println(0);
                    return;
                }
           }else {
                currentLength=list.get(i).left-list.get(i-1).right-1;
                if(currentLength>=request){
                    index=list.get(i-1).right+1;
                    list.add(new Pair(index,list.get(i-1).right+request));
                    Collections.sort(list,(o1,o2)->o1.left-o2.left);
                    System.out.println(index);
                    return;
                }
            }


        }
        currentLength=99-list.get(list.size()-1).right;
        if(currentLength>=request){
            index=list.get(list.size()-1).right+1;
            //注意
            list.add(new Pair(index,list.get(list.size()-1).right+request));
            Collections.sort(list,(o1,o2)->o1.left-o2.left);
            System.out.println(index);
            return;
        }
        System.out.println("error");

    }
    public  static void releaseMemory(int release){
       boolean flag=false;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).left==release){
                list.remove(i);
                flag=true;
            }

        }
        if(!flag){
            System.out.println("error");
        }



    }

    static class Pair{
        int left;
        int right;

        public Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }




}

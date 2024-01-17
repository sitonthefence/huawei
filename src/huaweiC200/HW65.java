package huaweiC200;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class HW65 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String source = in.next();
            ArrayList<LinkedList<Integer>> map=new ArrayList<>();
            for (int i = 0; i <8; i++) {
                LinkedList<Integer> list=new LinkedList<>();
                map.add(list);
            }
            map.get(0).add(-1);
            int status=0;
            int maxLength=0;
            for (int i = 0; i < 2*source.length(); i++) {
                 if(source.charAt(i%source.length())=='l'){
                 status^=0b100;
                 }else if(source.charAt(i%source.length())=='o'){
                     status^=0b010;
                 }else if(source.charAt(i%source.length())=='x'){
                     status^=0b001;
                 }
                 if(i<source.length()){
                     map.get(status).add(i);
                 }
                 while (!map.get(status).isEmpty()){
                     if((i-map.get(status).peekFirst())>source.length()){
                         map.get(status).pollFirst();
                     }else {
                         maxLength = Math.max(maxLength, i - map.get(status).peekFirst());
                         //不能省略；
                         break;
                     }
                 }
            }
            System.out.println(maxLength);
        }
    }
}

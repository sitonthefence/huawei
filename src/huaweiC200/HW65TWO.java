package huaweiC200;

import java.util.*;

public class HW65TWO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String source = in.next();
        Map<Integer, LinkedList<Integer>> map=new HashMap<>();
        for (int i = 0; i < 8; i++) {
            map.put(i,new LinkedList<>());
        }
        map.get(0).add(-1);
        int status=0;
        int max=Integer.MIN_VALUE;
        for (int i = 0; i <2*source.length() ; i++) {
            if(source.charAt(i%source.length())=='l'){
                status^=0b001;
            }else if(source.charAt(i%source.length())=='o'){
                status^=0b010;
            }else if(source.charAt(i%source.length())=='x'){
                status^=0b100;
            }
            map.get(status).add(i);
            while (map.get(status).size()>=1){
                int curLength = map.get(status).peekLast() - map.get(status).peekFirst();
                if(curLength<=source.length()){
                    if(curLength>max){
                        max=curLength;
                    }
                    break;
                }else {
                    map.get(status).pollFirst();
                }
            }

        }
        System.out.println(max);







    }
}

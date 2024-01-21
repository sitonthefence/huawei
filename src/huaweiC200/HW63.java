package huaweiC200;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class HW63 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int seatNum = in.nextInt();
            in.nextLine();
            String source = in.nextLine();
            String[] split = source.substring(1, source.length() - 1).split(", ");
            Integer[] seatOrLeave=new Integer[split.length];
            for (int i = 0; i < seatOrLeave.length; i++) {
                seatOrLeave[i]=Integer.valueOf(split[i]);
            }
            List<Integer> person=new ArrayList<>();
            int index=-1;

            for (Integer status : seatOrLeave) {
                if(status<0){
                    person.remove(Integer.valueOf(-status));
                    continue;
                }
                //注意
                if(person.size()==seatNum){
                    index=-1;
                    continue;
                }
                if(person.size()==0){
                    person.add(0);
                    index=0;
                }else if(person.size()==1){
                    person.add(seatNum-1);
                    index=seatNum-1;
                }else {
                    int maxDistance=Integer.MIN_VALUE;
                    Collections.sort(person);
                    for (int i = 0; i < person.size()-1; i++) {
                         int length=person.get(i+1)- person.get(i);
                        if(length>1){
                            int distance=length/2-1;
                            if(distance>maxDistance){
                                maxDistance=distance;
                                index= person.get(i)+distance+1;
                            }
                        }
                    }
                    if(person.get(person.size()-1)!=seatNum-1){
                          int distance=seatNum-1-person.get(person.size()-1)-1;
                        if(distance>maxDistance){

                            index= person.get(person.size()-1)+distance+1;
                        }

                    }
                   person.add(index);

                }

            }
            System.out.println(index);

        }


    }
}

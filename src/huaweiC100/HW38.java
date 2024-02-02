package huaweiC100;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HW38 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()){
            int CpuSpeed = in.nextInt();
            int seconds = in.nextInt();
            List<Integer> list=new ArrayList<>();
            for (int i = 0; i < seconds; i++) {
                list.add(in.nextInt());
            }
            int currentUndoTask=0;
            int time=0;
            for (int i = 0; i < seconds; i++) {

                if(currentUndoTask+list.get(i)-CpuSpeed>0){
                    currentUndoTask=currentUndoTask+list.get(i)-CpuSpeed;
                }else {
                    currentUndoTask=0;
                }
                time++;
            }
            while (currentUndoTask>0){

                currentUndoTask=currentUndoTask-CpuSpeed;
                time++;

            }
            System.out.println(time);



        }


    }
}

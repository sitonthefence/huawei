package huaweiC100;

import java.util.Scanner;

public class HW36TWO {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = Integer.valueOf(in.nextLine());
        String[][] records=new String[length][];
        for (int i = 0; i < length; i++) {
             records[i]=in.nextLine().split(" ");
        }
        for (int i = 0; i < length; i++) {
            System.out.println(getResult(records[i]));
        }
    }
    public  static  boolean getResult(String[] record){
        String preRecord="";
        int absentRecord=0;
        int presentRecord=0;
        for (int i = 0; i < record.length; i++) {
            if(i>=7){
                if(record[i-7].equals("present")) presentRecord--;
            }
            String currentRecord=record[i];
            if (currentRecord.equals("absent")){
                absentRecord++;
                if(absentRecord>1){
                    return false;
                }
            }else if(currentRecord.equals("late")||currentRecord.equals("leaveearly")){
                if(preRecord.equals("late")||preRecord.equals("leaveearly")){
                    return false;
                }
            }else {
                presentRecord++;
            }
            int days = Math.min(i + 1, 7);
            if((days-presentRecord)>3){
                return false;
            }
            preRecord=currentRecord;
        }
        return true;

    }

}

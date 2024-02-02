package huaweiC100;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HW36 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            int length = Integer.valueOf(in.nextLine());
            List<List<String>> list=new ArrayList<>();
            for (int i = 0; i < length; i++) {
                List<String> path=new ArrayList<>();
                String source = in.nextLine();
                String[] split = source.split(" ");
                for (int j = 0; j < split.length; j++) {
                    path.add(split[j]);
                }
                list.add(path);

            }
            for (int i = 0; i < length; i++){
                int count =0;
                boolean flag=true;
                for (int j = 0; j < list.get(i).size(); j++) {
                    if(list.get(i).get(j).equals("absent")){
                        count++;
                    }
                    if(count>1){
                        flag=false;
                        break;
                    }
                }
                if(flag==true){
                    for (int j = 1; j <list.get(i).size(); j++) {
                        if((list.get(i).get(j).equals("late")||list.get(i).get(j).equals("leaveearly"))&&
                                (list.get(i).get(j-1).equals("late")||list.get(i).get(j-1).equals("leaveearly"))
                        ){
                            flag=false;
                            break;
                        }
                    }
                }

                if(flag==true){
                    List<Integer> temp=new ArrayList<>();
                    for (int j = 0; j < list.get(i).size(); j++) {
                        if(list.get(i).get(j).equals("present")){
                            temp.add(1);
                        }
                    }
                    if(temp.size()>=7){
                        for (int j = 0; j < temp.size()-6; j++) {
                            int sum=0;
                            for (int k = 0; k < 7; k++) {
                                sum+=temp.get(j+k);
                            }
                            if (sum>3){
                               flag=false;
                            }
                        }
                    }else {
                        int sum=0;
                        for (int j = 0; j < temp.size(); j++) {
                            sum+=temp.get(j);
                        }
                        if (sum>3){
                         flag=false;
                        }
                    }

                }
                System.out.print(flag+" ");
            }
        }
    }
}

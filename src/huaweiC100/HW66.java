package huaweiC100;

import java.util.*;

public class HW66 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String source = in.nextLine();
        String[] split = source.split("\\W");
        List<Long> numList=new LinkedList<>();
        for (int i = 0; i < split.length; i++) {
           numList.add(Long.parseLong(split[i]));
        }
        String[] split1 = source.split("\\w");
        List<String> operatorList=new ArrayList<>();
        for (int i = 0; i < split1.length; i++) {
            if(!split1[i].equals("")){
                operatorList.add(split1[i]);
            }

        }
        for (int i = 0; i < operatorList.size(); i++) {
             if (operatorList.get(i).equals("$")){
                long x=numList.get(i);
                 long y = numList.get(i + 1);
                 long z=3*x+y+2;
                 operatorList.remove(i);
                 numList.set(i,z);
                 numList.remove(i+1);
                 i--;
             }
        }
        for (int i = 0; i < numList.size()-1; i++) {
            long x = numList.get(0);
            long y = numList.get(1);
            long z=2*x+3*y+4;
            numList.set(0,z);
            numList.remove(1);
            i--;
        }
        System.out.println(numList.get(0));


    }
}

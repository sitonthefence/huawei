package huawei100;

import java.util.*;

public class HW19 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String source = in.nextLine();
            String[] split = source.split(";");
            String vars = split[split.length - 3];
            String[] varsSplit = vars.split(",");
            String aims = split[split.length - 2];
            String[] aimsSplit = aims.split(",");
            String limits = split[split.length - 1];
            String[] limitsSplit = limits.split(",");
           List<Integer> list=new LinkedList<>();
            boolean flag=true;
            for (int i = 0; i < split.length-3; i++) {
                List<Double> expressionList=new ArrayList<>();
                String expression = split[i];
                String[] expressionSplit = expression.split(",");
                for (int j = 0; j < expressionSplit.length; j++) {
                    expressionList.add(Double.valueOf(expressionSplit[j]));
                }
                Double value=CalculateValue(expressionList,varsSplit);
                Double target=Double.valueOf(aimsSplit[i]);
                String limit=limitsSplit[i];
                boolean compareResult = compareResult( value, target, limit);
                if (compareResult==false){
                    flag=false;
                }
                int sub= (int) Math.floor(Math.abs(value-target));
                list.add(sub);
            }
            System.out.print(flag+" ");
            list.sort(Comparator.reverseOrder());
            System.out.println(list.get(0));

        }
    }

    private static double CalculateValue(List<Double> expressionList, String[] varsSplit) {
            double result=0;
        for (int i = 0; i < expressionList.size(); i++) {
            result=expressionList.get(i)*Double.valueOf(varsSplit[i])+result;
        }
        return result;
    }
    private static boolean compareResult(Double value,Double target,String limit){
         if(limit.equals(">=")){
             return value>=target;
         }else if(limit.equals(">")){
             return value>target;
         }else if(limit.equals("<=")){
             return value<=target;
         }else{
            return value<target;
        }
    }

}

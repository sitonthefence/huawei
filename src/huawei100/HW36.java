package huawei100;



import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class HW36 {

    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int length = in.nextInt();
            int total = in.nextInt();
            List<LinkedList<Integer>> list=new LinkedList<>();
            for (int i = 0; i < total; i++) {
                LinkedList<Integer> tmp=new LinkedList<>();
                list.add(tmp);
                String source = in.next();
                String[] split = source.split(",");
                for (int j = 0; j < split.length; j++) {
                    tmp.add(Integer.valueOf(split[j]));
                }
            }
            StringBuilder stringBuilder=new StringBuilder();
            int index=0;
            while (list.size()>0){
                LinkedList<Integer> temp = list.get(index);
                for (int i = 0; i <length ; i++) {
                    if (temp.isEmpty()){
                        list.remove(temp);
                        index--;
                        break;
                    }
                    Integer integer = temp.removeFirst();
                    stringBuilder.append(integer).append(",");
                }
                if(index<list.size()-1){
                    index++;
                }else {
                    index=0;
                }
            }
            stringBuilder.substring(0,stringBuilder.length()-1);
            System.out.println(stringBuilder);

            }

        }
    }


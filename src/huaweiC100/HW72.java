package huaweiC100;

import java.util.*;

public class HW72 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int N = in.nextInt();
            int M = in.nextInt();
            int [] arr=new int[N];
            int [] test=new int[M];
            for (int i = 0; i < arr.length; i++) {
                arr[i]=in.nextInt();
            }
            in.nextLine();
            for (int i = 0; i < M; i++) {
                String line = in.nextLine();
                String[] split = line.split(" ");
                for (int j = 0; j < split.length; j++) {
                  test[i]=test[i]+arr[Integer.valueOf(split[j])-1];
                }
            }
            Map<Integer,Integer> map=new HashMap<>();
            for (int i = 0; i < M; i++) {
                map.put(i+1,test[i]);
            }
            LinkedList<Map.Entry<Integer, Integer>> list = new LinkedList<>(map.entrySet());
            Collections.sort(list,((o1, o2) -> o2.getValue()- o1.getValue()));
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).getKey());
            }


        }
    }
}

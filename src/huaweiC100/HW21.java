package huaweiC100;

import java.util.*;

public class HW21 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int[][] g=new int[m][n];
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <n ; j++) {
                g[i][j]=in.nextInt();
            }
        }
        Map<Integer, List<int[]>> map=new HashMap<>();
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <n ; j++) {
                if(g[i][j]==0){
                    continue;
                }
                if(map.containsKey(g[i][j])){
                    int[] tmp=new int[2];
                    tmp[0]=i;
                    tmp[1]=j;
                    map.get(g[i][j]).add(tmp);
                }else {
                    List<int[]> list=new ArrayList<>();
                    int[] tmp=new int[2];
                    tmp[0]=i;
                    tmp[1]=j;
                    list.add(tmp);
                    map.put(g[i][j],list);
                }
            }
        }
        int MaxArea=0;
        for (List<int[]> value : map.values()) {
           MaxArea=Math.max(MaxArea,getArea(value));
        }
        System.out.println(MaxArea);

    }
    public static int getArea( List<int[]> list){
            int leftMin=list.get(0)[0];
            int leftMax=list.get(0)[0];
            int rightMin=list.get(0)[1];
            int rightMax=list.get(0)[1];
        for (int i =1; i < list.size(); i++) {
            leftMin=Math.min(leftMin,list.get(i)[0]);
            leftMax=Math.max(leftMax,list.get(i)[0]);
            rightMin=Math.min(rightMin,list.get(i)[1]);
            rightMax=Math.max(rightMax,list.get(i)[1]);
        }
        return (leftMax-leftMin+1)*(rightMax-rightMin+1);


    }


}

package LC;

import java.util.ArrayList;
import java.util.Arrays;

public class LC57插入区间 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
         int[][] newArray=new int[intervals.length+1][2];
        for (int i = 0; i < intervals.length; i++) {
            newArray[i][0]=intervals[i][0];
            newArray[i][1]=intervals[i][1];
        }
        newArray[intervals.length][0]=newInterval[0];
        newArray[intervals.length][1]=newInterval[1];

        Arrays.sort(newArray,(a,b)->a[0]-b[0]);
        ArrayList<int[]> result=new ArrayList<>();
        int preX=newArray[0][0];
        int preY=newArray[0][1];
        for (int i = 1; i <newArray.length ; i++) {
            int curX=newArray[i][0];
            int curY=newArray[i][1];
            if(curX<=preY){
                preY=Math.max(preY,curY);
            }else {
                result.add(new int[]{preX,preY});
                preX=curX;
                preY=curY;
            }
        }
        result.add(new int[]{preX,preY});
        return result.toArray(new int[0][]);







    }



}

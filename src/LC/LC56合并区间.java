package LC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC56合并区间 {
    public int[][] merge(int[][] intervals) {
        List<int[]> result=new ArrayList<>();
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int preX=intervals[0][0];
        int preY=intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int curX=intervals[i][0];
            int curY=intervals[i][1];
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

package NC37;

import java.util.*;





public class NC37 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param intervals Interval类ArrayList
     * @return Interval类ArrayList
     */
    public ArrayList<Interval> merge (ArrayList<Interval> intervals) {
        ArrayList<Interval> result=new ArrayList<>();
        if(intervals==null||intervals.size()==0){
            return result;
        }

        Collections.sort(intervals,(a,b)->
                {
                    if(a.start==b.start){
                        return a.end-b.end;
                    }else {
                        return a.start-b.start;
                    }

                }
        );
        int preStart=intervals.get(0).start;
        int preEnd=intervals.get(0).end;

        for (int i = 1; i <intervals.size() ; i++) {
            int curStart=intervals.get(i).start;
            int curEnd=intervals.get(i).end;
            if(curStart>preEnd){
                result.add(new Interval(preStart,preEnd));
                preStart=curStart;
                preEnd=curEnd;
            }else {
                preEnd=Math.max(preEnd,curEnd);
            }
        }
        result.add(new Interval(preStart,preEnd));
        return result;
    }

    static class Interval {
        int start;
        int end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
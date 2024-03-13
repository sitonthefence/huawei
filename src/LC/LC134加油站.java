package LC;

public class LC134加油站 {
    public int canCompleteCircuit(int[] gas, int[] cost){
        int allGas=0;
        int allCost=0;
        for (int i = 0; i < gas.length; i++) {
            allGas+=gas[i];
            allCost+=cost[i];
        }
        if(allGas<allCost) return  -1;
        int start=0;
        int tank=0;
        for (int i = 0; i < gas.length; i++) {
            tank+=gas[i]-cost[i];
            if(tank<0){
                start=i+1;
                tank=0;

            }
        }
        return start;



    }
}

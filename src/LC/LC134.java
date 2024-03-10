package LC;

public class LC134 {
    public static void main(String[] args) {
        canCompleteCircuit(new int[]{2,3,4}, new int[]{3,4,3});
    }
    public static int canCompleteCircuit(int[] gas, int[] cost) {


        int ans=-1;
        for (int i = 0; i <gas.length ; i++) {
           int curGas=0;
            boolean flag=true;
            for (int j = 0; j < gas.length  ; j++) {
                int cur = (i + j) % gas.length;
                curGas+=gas[cur];
                if(curGas<cost[cur]){
                  flag=false;
                  break;
                }else {
                    curGas-=cost[cur];
                }

            }
            if(flag){
                ans=i;
                break;
            }

        }
        return ans;


    }
}

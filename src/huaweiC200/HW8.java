package huaweiC200;


import java.util.Arrays;
import java.util.Scanner;

public class HW8 {
    //n和m要区分 n是行
    static int n;
    static int m;
    static int k;
    public static  int[][] matrix;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        k = in.nextInt();
        matrix=new int[n][m];
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j]=in.nextInt();
                max=Math.max(matrix[i][j],max);
            }
        }
        int target=max;
        //left我认为从0开始
        int left=0;
        int right=target;
        while (left<right){
            int mid=(left+right)/2;
            if(check(mid)){
                target=mid;
                right=mid;
            }else {
                left=mid+1;
            }
        }
        System.out.println(target);
    }
    public static boolean check(int kth){
        int count=0;
        int[] matcher=new int[m];
        Arrays.fill(matcher,-1);
        for (int i = 0; i < n; i++) {
            //当心
            boolean[] used=new boolean[m];
            if(dfs(kth,matcher,used,i)){
                count++;
            }
        }
        return count>=n-k+1;
    }
    public static boolean dfs(int kth,int[] matcher,boolean[] used,int i){
        for (int j = 0; j < m; j++) {
            if(!used[j]&&matrix[i][j]<=kth){
                used[j]=true;
                //matcher[j]==-1
                if(matcher[j]==-1||dfs(kth,matcher,used,matcher[j])){
                    matcher[j]=i;
                    return true;
                }
            }
        }
        return false;
    }
}

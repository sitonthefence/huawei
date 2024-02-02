package huaweiC200;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class HW66 {
    static int[][] password;

    static boolean[][] visited;
    static int M;
    static int[] nums;
    static LinkedList<int[]> path;
    static List <LinkedList<int[]>> result;
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        nums=new int[N];
        for (int i = 0; i < N; i++) {
            nums[i]=in.nextInt();
        }

        M = in.nextInt();
        password=new int[M][M];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                password[i][j]=in.nextInt();
            }
        }
        visited=new boolean[M][M];
        path=new LinkedList<>();
        result=new ArrayList<>();
        for (int i = 0; i <M ; i++) {
            for (int j = 0; j <M ; j++) {
                if(dfs(i,j,0)){
                    for (int[] ints : result.get(0)) {
                        System.out.print(ints[0]+" "+ints[1]+" ");
                    }
                    return;
                }

            }
        }
        System.out.println("error");
    }
    public  static boolean dfs(int i,int j,int index){
        if (path.size()==nums.length){
            result.add(new LinkedList<>(path));
            return true;
        }
        if(i<0||j<0||i>=M||j>=M||visited[i][j]||nums[index]!=password[i][j]){
            return false;
        }

        visited[i][j]=true;
        path.offerLast(new int[]{i,j});

        boolean result = dfs(i-1, j, index + 1) || dfs(i, j-1, index + 1) ||
                dfs(i, j + 1, index + 1) || dfs(i + 1, j, index+1);
        visited[i][j]=false;
        path.pollLast();
        return result;

    }


}
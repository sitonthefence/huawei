package huaweiC200;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class HW66TWO {
   static int[] article;
   static int[][] password;
   static List<LinkedList<int []>> result;
    static  LinkedList<int []> path;


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int articleLength = in.nextInt();
         article=new int[articleLength];
        for (int i = 0; i < articleLength; i++) {
            article[i]=in.nextInt();
        }
        int N = in.nextInt();
        password=new int[N][N];
        for (int i = 0; i <password.length ; i++) {
            for (int j = 0; j <password[0].length ; j++) {
                password[i][j]=in.nextInt();
            }
        }
        result=new ArrayList<>();
        path=new LinkedList<>();
        for (int i = 0; i < password.length; i++) {
            for (int j = 0; j < password[0].length; j++) {
                boolean[][] used=new boolean[password.length][password.length];
                if(dfs(i,j,0,used)){
                    LinkedList<int[]> path = result.get(0);
                    for (int[] ints : path) {
                        System.out.print(ints[0]+" ");
                        System.out.print(ints[1]+" ");

                    }
                    return;
                }


            }

        }
        System.out.println("error");
    }
    public static boolean dfs(int i,int j,int index,boolean used[][]){
        if(path.size()==article.length){
            result.add(new LinkedList<>(path));
            return true;
        }

        if(i<0||j<0||i>= password.length||j>= password[0].length||used[i][j]||article[index]!=password[i][j]){
            return false;
        }
        path.add(new int[]{i,j});

        used[i][j]=true;
        boolean result = dfs(i - 1, j, index + 1, used)
                ||dfs(i, j - 1, index + 1, used)
                ||dfs(i, j + 1, index + 1, used)
                ||dfs(i + 1, j, index + 1, used);
        path.pollLast();
        used[i][j]=false;
        return result;
    }

}

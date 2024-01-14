package huaweiC200;


import java.util.ArrayList;
import java.util.LinkedList;

import java.util.List;
import java.util.Scanner;

public class HW11 {
   static boolean  flag;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int length = in.nextInt();
            char[][] arr=new char[length][length];
            for (int i = 0; i < length; i++) {
                String source = in.next();
                String[] split = source.split(",");
                for (int j = 0; j < length; j++) {
                    arr[i][j]=split[j].charAt(0);
                }
            }
            String target = in.next();
            boolean[][] used=new boolean[length][length];
            LinkedList<int[]> path;
            List<LinkedList<int[]>> result=new ArrayList<>();
            for (int i = 0; i <length ; i++) {
                for (int j = 0; j < length; j++) {
                    path=new LinkedList<>();
                        dfs(arr, target,0,used,path,i,j,result);
                 if(flag){
                     StringBuilder stringBuilder=new StringBuilder();
                     for (int[] pair : result.get(0)) {
                         stringBuilder.append(pair[0]+","+pair[1]+",");
                     }
                     String substring = stringBuilder.substring(0, stringBuilder.length() - 1);
                     System.out.println(substring);
                     return;
                 }
                }
            }
                System.out.println("N");
            }
    }
    public static void dfs(char[][] arr, String target,int index,boolean[][] used,LinkedList<int[]> path,int i,int j,  List<LinkedList<int[]>> result){
        if(path.size()==target.length()){
            result.add(new LinkedList<>(path));
            flag=true;
            return;
        }
        if(i<0||j<0||i>=arr.length||j>=arr[0].length||used[i][j]){
            return;
        }

            if (arr[i][j]==target.charAt(index)){
                int[] temp=new int[ ]{i,j};
                path.offerLast(temp);
                    //used在dfs之间
                    used[i][j]=true;
                dfs(arr, target,index+1,used,path,i+1,j,result);
                dfs(arr, target,index+1,used,path,i-1,j,result);
                dfs(arr, target,index+1,used,path,i,j+1,result);
                dfs(arr, target,index+1,used,path,i,j-1,result);
                    used[i][j]=false;
                path.pollLast();

        }
    }



}

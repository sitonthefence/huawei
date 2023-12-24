package huawei200;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class HW20 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int n = in.nextInt();
            int k = in.nextInt();
            List<LinkedList<Integer>> result=new ArrayList<>();
            LinkedList<Integer> path=new LinkedList<>();
            boolean[] used=new boolean[n+1];
            backtracking(result,path,n,used);
            for (int i = 0; i < result.get(k-1).size(); i++) {
                System.out.print(result.get(k-1).get(i));
            }
        }
    }
    public static void backtracking( List<LinkedList<Integer>> result, LinkedList<Integer> path,
                                     int n,boolean[] used){

        if(path.size()==n){
            result.add(new LinkedList<>(path));
            return;
        }
        for (int i = 1; i <=n ; i++) {
            if(!used[i]){
              path.offerLast(i);
              used[i]=true;
              backtracking(result,path,n,used);
              path.pollLast();
              used[i]=false;
            }
        }

    }





}

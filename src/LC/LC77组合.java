package LC;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LC77组合 {
    public static void main(String[] args) {
        List<List<Integer>> combine = combine(4, 2);
        System.out.println(combine);

    }
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result=new ArrayList<>();
        Deque<Integer> path=new ArrayDeque<>();
        if(k>n||n<1){
            return result;
        }
        backtracking( n,  k, 0, path, result);
        return result;
    }

    public static void backtracking(int n, int k, int begin, Deque<Integer> path,List<List<Integer>> result){
           if(path.size()==k){
               result.add(new ArrayList<>(path));
               return;
           }
           //每个叶子节点相当于一个for循环
        for (int i = begin; i <=n ; i++) {
            path.offerLast(i);
            backtracking(n,k,i+1,path,result);
            path.pollLast();
        }
    }


}

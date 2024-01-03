package huaweiC100;

import java.util.*;

public class HW65 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int length = in.nextInt();
            //
            PriorityQueue<int[]> queue=new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
            List<Node> trees=new ArrayList<>();
            for (int i = 0; i < length; i++) {
                int value = in.nextInt();
                queue.add(new int[]{value,i});
                //注意 不能写0
                trees.add(new Node(value,-1,-1));
            }
            int temp=length-1;
            while (queue.size()!=1){
                int[] poll1 = queue.poll();
                int a=poll1[0];
                int left=poll1[1];
                int[] poll2 = queue.poll();
                int b = poll2[0];
                int right = poll2[1];
                temp++;
                queue.add(new int[]{a+b,temp});
                //不能写饭 left和right代表索引
                trees.add(new Node(a+b,left,right));
            }
            //队列里面的一个元素不需要处理
            List<Node> result=new ArrayList<>();
            dfs(trees.size()-1,result,trees);
            for (int i = 0; i < result.size(); i++) {
                System.out.print(result.get(i).val+" ");
            }
        }


    }
    public static void dfs(int index,List<Node> result,List<Node> trees){
          if(index==-1){
              return;
          }
          dfs(trees.get(index).left,result,trees);
           result.add(trees.get(index));
           dfs(trees.get(index).right,result,trees);



    }

}
class Node{
    int val;
    int left;
    int right;

    public Node(int val, int left, int right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }
}

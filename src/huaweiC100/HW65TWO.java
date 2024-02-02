package huaweiC100;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class HW65TWO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        PriorityQueue<Node> deque=new PriorityQueue<>((o1,o2)->{
            if(o1.value==o2.value){
                return o1.height- o2.height;
            }else {
             return    o1.value-o2.value;
            }
        });
        for (int i = 0; i <length; i++) {
            Node node = new Node(in.nextInt(), 0, null, null);
            deque.add(node);
        }
        while (deque.size()>1){
            Node left = deque.poll();
            Node right = deque.poll();
            int value=left.value+ right.value;
            int height= right.height+1;
            deque.add(new Node(value,height,left,right));
        }
        Node root = deque.poll();
        List<Integer> result=new ArrayList<>();
        dfs(root,result);
        for (Integer integer : result) {
            System.out.print(integer+" ");
        }

    }
    static void dfs(Node node, List<Integer> result){
 /*       if(node.left!=null){
            dfs(node.left,result);
        }
        result.add(node.value);
        if(node.right!=null){
            dfs(node.right,result);
        }*/
        if(node==null){
            return;
        }
        dfs(node.left,result);
        result.add(node.value);
        dfs(node.right,result);


    }

   static class Node{
        int value;
        int height;
        Node left;
        Node right;

       public Node(int value, int height, Node left, Node right) {
           this.value = value;
           this.height = height;
           this.left = left;
           this.right = right;
       }
   }
}

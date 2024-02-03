package huaweiC200;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HW2THREE {
    static char[] postArray;
    static char[] midArray;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        postArray = in.next().toCharArray();
        midArray = in.next().toCharArray();
        Node root = dfs(0, postArray.length, 0, midArray.length);
        List<Character> result=new ArrayList<>();
        ArrayDeque<Node> deque=new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()){
            Node fa = deque.pollFirst();
            result.add(fa.value);
            if(fa.left!=null){
                deque.add(fa.left);
            }
            if(fa.right!=null){
                deque.add(fa.right);
            }
        }
        for (Character character : result) {
            System.out.print(character);
        }

    }
    public static Node dfs(int l1,int r1,int l2,int r2){
        if(l1==r1){
            return null;
        }
        char midNum=postArray[r1-1];

        int mid=-1;
        for (int i = 0; i < postArray.length; i++) {
            if(midNum==midArray[i]){
                mid=i;
                break;
            }
            }
        Node node=new Node(midNum);
        node.left=dfs(l1,l1+mid-l2,l2,mid);
        node.right=dfs(l1+mid-l2,r1-1,mid+1,r2);
        return node;



    }


    static class Node{
        Character value;
        Node left;
        Node right;

        public Node(Character value) {
            this.value = value;
        }
    }

}

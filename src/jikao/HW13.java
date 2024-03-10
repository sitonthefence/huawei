package jikao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class HW13 {
    static int[] midArray;
    static int[] preArray;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
       midArray = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
       preArray = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Node node = buildTree(0, midArray.length, 0, preArray.length);
        List<Integer> list=new ArrayList<>();
        dfs(list,node);
       list.forEach(t-> System.out.print(t+" "));

    }
    public static void dfs(List<Integer> list,  Node node){
        if(node==null){
            return;
        }
        dfs(list,node.left);
        list.add(node.sum);
        dfs(list,node.right);


    }



    public static Node buildTree(int l1,int r1,int l2,int r2){
        if(l2==r2){
            return null;
        }
        int midNum=preArray[l2];
        int mid=-1;
        for (int i = 0; i < midArray.length; i++) {
           if(i>=l1&&i<r1&&midArray[i]==midNum&&compare(l1,l2,i)){
               mid=i;
               break;
           }
        }
        Node node = new Node(midNum);
        node.left=buildTree(l1,mid,l2+1,mid-l1+l2+1);
        node.right=buildTree(mid+1,r1,mid-l1+l2+1,r2);
        node.sum=(node.left==null?0:node.left.sum+node.left.val)+
                (node.right==null?0:node.right.sum+node.right.val);
        return node;


    }
    public static boolean compare(int l1,int l2,int mid){
        int[] a = Arrays.copyOfRange(midArray, l1, mid);
        Arrays.sort(a);
        int[] b = Arrays.copyOfRange(preArray, l2 + 1, mid - l1 + l2 + 1);
        Arrays.sort(b);
        for (int i = 0; i < a.length; i++) {
            if(a[i]!=b[i]){
                return false;
            }
        }
        return true;
    }



    static class Node{
        int val;
        int sum;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

}

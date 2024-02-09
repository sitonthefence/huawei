package huaweiC200;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class HW20TWO {
    static int[] midArray;
    static int[] preArray;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        midArray=Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        preArray=Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Node root = buildTree(0, midArray.length, 0, preArray.length);

        LinkedList<Integer>result=new LinkedList<>();
        dfs(result,root);
        result.forEach(t-> System.out.print(t+" "));




    }
    public static Node buildTree(int l1,int r1,int l2,int r2){
        if(l2==r2) return null;
        int midNumber=preArray[l2];
        int mid=-1;
        for (int i = 0; i <midArray.length ; i++) {
            if(i>=l1&&i<r1&&midArray[i]==midNumber&&compare(l1,l2,i)){
                mid=i;
                break;
            }
        }
        Node node = new Node(midNumber);
        node.left=buildTree(l1,mid,l2+1,mid-l1+l2+1);
        node.right=buildTree(mid+1,r1,mid-l1+l2+1,r2);
        node.sum=(node.left==null?0:node.left.val+node.left.sum)+
                (node.right==null?0:node.right.val+node.right.sum);
        return node;
    }
    public static void dfs(LinkedList<Integer>result, Node node){
        if(node==null){
            return;
        }
        dfs(result,node.left);
        result.add(node.sum);
        dfs(result,node.right);


    }
    public static boolean compare(int l1,int l2,int mid){
        int[] a = Arrays.copyOfRange(midArray, l1, mid);
        int[] b = Arrays.copyOfRange(preArray, l2 + 1, mid - l1 + l2 + 1);
        Arrays.sort(a);
        Arrays.sort(b);

        for (int i = 0; i < a.length; i++) {
            if(a[i]!=b[i]){
                return false;
            }

        }
        return true;


    }


    static class  Node{
        int val;
        int sum;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }
}

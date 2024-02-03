package huaweiC200;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HW20 {
    static int[] midArray;
    static int[] preArray;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] split1 = in.nextLine().split(" ");
      midArray=new int[split1.length];
        for (int i = 0; i < midArray.length; i++) {
            midArray[i]=Integer.parseInt(split1[i]);
        }
        String[] split2 = in.nextLine().split(" ");
        preArray=new int[split2.length];
        for (int i = 0; i < preArray.length; i++) {
            preArray[i]=Integer.parseInt(split2[i]);
        }
        Node root = buildTree(0, midArray.length, 0, preArray.length);
        List<Integer> result=new ArrayList<>();
        tri(root,result);
        for (Integer integer : result) {
            System.out.println(integer+" ");
        }



    }
    public static void tri(Node node,List<Integer> result){
        if(node==null){
            return;
        }
        result.add(node.sum);
        tri(node.left,result);
        tri(node.right,result);


    }
    public static Node buildTree(int l1,int r1,int l2,int r2){
        if(l2==r2){
            return null;
        }
        int midNUmber=preArray[0];
        int mid=-1;
        for (int i = 0; i < midArray.length; i++) {
            if(midArray[i]==midNUmber){
                mid=i;
                break;
            }

        }
        Node node = new Node(mid);
        node.left=buildTree(l1,mid,l2+1,mid-l1+l2+1);
        node.right=buildTree(mid+1,r1,mid-l1+l2+1,r2);



        node.sum=(node.left==null?0:(node.left.value+node.left.sum))+
                (node.right==null?0:(node.right.value+node.right.sum));


        return node;
    }



    static class Node{
        int value;
        int sum;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }
}

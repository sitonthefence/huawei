package huaweiC200;

import java.util.Scanner;

public class HW19TWO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        int[] arr=new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=in.nextInt();
        }
        Node root=new Node(arr[0]);
        for (int i = 1; i <arr.length; i++) {
            buildTree(root,arr,i);
        }
        System.out.println(getHeight(root));


    }
    public static void buildTree( Node node,int[] arr,int index){
        if(arr[index]<node.value-500){
            if(node.left==null){
                node.left=new Node(arr[index]);
            }else {
                buildTree(node.left,arr,index);
            }



        }else if(arr[index]>node.value+500){

            if(node.right==null){
                node.right=new Node(arr[index]);
            }else {
                buildTree(node.right,arr,index);
            }

        }else {
            if(node.mid==null){
                node.mid=new Node(arr[index]);
            }else {
                buildTree(node.mid,arr,index);
            }
        }


    }
    static public int getHeight(Node node){
        if(node==null){
            return 0;
        }
        return Math.max(Math.max(getHeight(node.left),getHeight(node.right)),getHeight(node.mid))+1;



    }








    static class Node{
        int value;
        Node left;
        Node mid;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }
}

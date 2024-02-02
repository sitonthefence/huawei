package huaweiC100;

import java.util.Scanner;

public class HW49TWO {

   static class Node{
       int value;
       Node left;
       Node right;

       public Node(int value) {
           this.value = value;
       }

       public Node(int value, Node left, Node right) {
           this.value = value;
           this.left = left;
           this.right = right;
       }
   }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] split = in.nextLine().split(" ");
        int[] arr =new int[split.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=Integer.valueOf(split[i]);
        }
        Node root=new Node(arr[0]);
        Node node = buildTree(0, arr);
        System.out.println(time(node));

    }
    public static Node  buildTree(int index,int arr[]){

         Node node=new Node(arr[index]);
//有问题
         if(2*index+1<arr.length&&arr[2*index+1]!=-1){
             node.left=buildTree(2*index+1,arr);
         }
        if(2*index+2<arr.length&&arr[2*index+2]!=-1){
            node.right=buildTree(2*index+2,arr);
        }
        return node;
 /*       if(index>=arr.length||arr[index]==-1){
         return null;
        }
        Node node=new Node(arr[index]);
        node.left=buildTree(2*index+1,arr);
        node.right=buildTree(2*index+2,arr);
        return node;*/
    }
    public static int time(Node node){
              if(node==null){
                  return 0;
              }
        return Math.max(time(node.left),time(node.right))+node.value;
    }
}

package huaweiC200;

import java.util.Scanner;

public class HW19 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        int[] arr=new int[length];
        in.nextLine();
        String source = in.nextLine();

        String[] split = source.split(" ");
        for (int i = 0; i < arr.length; i++) {
           arr[i]=Integer.valueOf(split[i]);
        }
        TriNode root=new TriNode(arr[0]);
        for (int i = 1; i < arr.length; i++) {
             buildTree(root,arr[i]);
        }
        System.out.println(getMaxHeight(root));

    }
    public static void buildTree(TriNode node,int value){
            if(value<node.value-500){
                if(node.left==null){
                    node.left=new TriNode(value);
                    return;
                }
                buildTree(node.left,value);
            }else if(value>node.value+500){
                if(node.right==null){
                    node.right=new TriNode(value);
                    return;
                }
                buildTree(node.right,value);
            }else {
               if(node.middle==null){
                   node.middle=new TriNode(value);
                   return;
               }
               buildTree(node.middle,value);
            }
    }
    public  static int getMaxHeight(TriNode node){
          if(node==null){
              return 0;
          }
          return Math.max(Math.max(getMaxHeight(node.left),getMaxHeight(node.right)),getMaxHeight(node.middle))+1;
    }

}
class TriNode{
    int value;
    TriNode left;
    TriNode middle;
    TriNode right;

    public TriNode(int value) {
        this.value = value;
    }
}
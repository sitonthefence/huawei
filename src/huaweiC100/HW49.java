package huaweiC100;

import java.util.Scanner;

public class HW49 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String source = in.nextLine();
            String[] split = source.split(" ");
            int[] nums=new int[split.length];

            for (int i = 0; i < split.length; i++) {
                   nums[i]=Integer.valueOf(split[i]);
            }
            NodeC nodeC = buildTree(nums, 0);
            System.out.println(getMax(nodeC));
        }


    }
    public static NodeC buildTree(int[] nums,int index){
        if(index>=nums.length||nums[index]==-1){
            return null;
        }
      NodeC node =new NodeC(nums[index]);
        node.left=buildTree(nums,2*index+1);
        node.right=buildTree(nums,2*index+2);
        return node;
    }
    public static int getMax(NodeC node){
        if(node==null){
            return 0;
        }
        return  Math.max(getMax(node.left),getMax(node.right))+node.value;
    }
}
class NodeC{
    int value;
    NodeC left;
    NodeC right;

    public NodeC() {
    }

    public NodeC(int value) {
        this.value = value;
    }

    public NodeC(int value, NodeC left, NodeC right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public NodeC getLeft() {
        return left;
    }

    public void setLeft(NodeC left) {
        this.left = left;
    }

    public NodeC getRight() {
        return right;
    }

    public void setRight(NodeC right) {
        this.right = right;
    }
}


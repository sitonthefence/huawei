package huaweiC200;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HW2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            char[] postOrder = in.next().toCharArray();
            char[] inOrder = in.next().toCharArray();
            TreeNode treeNode = buildTree(postOrder, 0, postOrder.length,
                    inOrder, 0, inOrder.length);
            List<Character> result=new ArrayList<>();
            traversal(treeNode,result);
            for (Character character : result) {
                System.out.print(character);
            }
        }
    }
    public static TreeNode buildTree(char[] postOrder,int leftPostOrder,int rightPostOrder,
                            char[] inOrder,int leftInOrder,int  rightInOrder){
        if(leftPostOrder==rightPostOrder){
            return null;
        }
        char middle=postOrder[rightPostOrder-1];
        int middleIndex=-1;
        for (int i = leftInOrder; i <rightInOrder ; i++) {
            if (inOrder[i]==middle){
                middleIndex=i;
                break;
            }
        }
        TreeNode node=new TreeNode(middle);

        node.left=buildTree(postOrder,leftPostOrder,leftPostOrder+middleIndex-leftInOrder,inOrder,leftInOrder,middleIndex);
        node.right=buildTree(postOrder,leftPostOrder+middleIndex-leftInOrder,rightPostOrder-1,inOrder,middleIndex+1,rightInOrder);
        return node;
    }

    public static void  traversal(TreeNode treeNode, List<Character> result){
        ArrayDeque<TreeNode> deque=new ArrayDeque<>();
        deque.add(treeNode);
        while (!deque.isEmpty()){
            TreeNode treeNode1 = deque.pollFirst();
            result.add(treeNode1.value);
            if(treeNode1.left!=null){
                deque.add(treeNode1.left);
            }
            if(treeNode1.right!=null){
                deque.add(treeNode1.right);
            }


        }



    }
}
class TreeNode{
    Character value;
    TreeNode left;
    TreeNode right;

    public TreeNode(Character value) {
        this.value = value;
    }
}

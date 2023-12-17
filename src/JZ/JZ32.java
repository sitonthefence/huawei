package JZ;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class JZ32 {
    public static void main(String[] args) {

    }
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res=new ArrayList<>();
        if(root==null){
            return res;
        }
        ArrayDeque<TreeNode> queue=new ArrayDeque<>();
        queue.offerLast(root);

        while (!queue.isEmpty()){
            TreeNode treeNode = queue.pollFirst();
             res.add(treeNode.val);
             if(treeNode.left!=null){
                 queue.offerLast(treeNode.left);
             }
            if(treeNode.right!=null){
                queue.offerLast(treeNode.right);
            }
        }
        return res;




    }


}

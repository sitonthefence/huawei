package LC;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class LC102二叉树的层序遍历 {



    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> resList = new ArrayList<>();

        if(root==null){
            return resList;
        }
        ArrayDeque<TreeNode> arrayDeque=new ArrayDeque<>();
        arrayDeque.offerLast(root);
        while (!arrayDeque.isEmpty()){

            List<Integer> result=new ArrayList<>();
            int size = arrayDeque.size();
            for (int i = 0; i <size; i++) {
                TreeNode treeNode = arrayDeque.pollFirst();
                result.add(treeNode.val);
                if(treeNode.left!=null){
                    arrayDeque.offerLast(treeNode.left);
                }
                if(treeNode.right!=null){
                    arrayDeque.offerLast(treeNode.right);
                }
            }
            resList.add(result);

        }

        return resList;

    }


}

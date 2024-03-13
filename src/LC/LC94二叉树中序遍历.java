package LC;

import java.util.ArrayList;
import java.util.List;

public class LC94二叉树中序遍历 {
    List<Integer> result=new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        dfs(root);
        return result;
    }
    public void dfs(TreeNode root){
        if(root==null){
            return;
        }
        dfs(root.left);
        result.add(root.val);
        dfs(root.right);

    }
}

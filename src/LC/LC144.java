package LC;

import java.util.ArrayList;
import java.util.List;

public class LC144 {
    List<Integer> result=new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        dfs(root);
        return result;
    }
    public void dfs(TreeNode root ){
        if(root==null){
            return;
        }
        result.add(root.val);
        dfs(root.left);
        dfs(root.right);

    }



}
class TreeNode {
int val;
 TreeNode left;
 TreeNode right;
TreeNode() {}
 TreeNode(int val) { this.val = val; }
 TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
     this.left = left;
      this.right = right;
   }
 }
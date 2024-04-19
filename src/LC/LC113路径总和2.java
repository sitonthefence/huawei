package LC;

import java.util.ArrayList;

import java.util.List;

public class LC113路径总和2 {
   static class TreeNode {
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

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, targetSum, path, result);
        return result;
    }

    private void dfs(TreeNode node, int targetSum, List<Integer> path, List<List<Integer>> result) {
        if (node == null)
            return;

        path.add(node.val);
        targetSum -= node.val;

        if (node.left == null && node.right == null && targetSum == 0) {
            result.add(new ArrayList<>(path));
        }

        dfs(node.left, targetSum, path, result);
        dfs(node.right, targetSum, path, result);

        // 在返回上一层之前，需要将当前节点从路径中移除
        path.remove(path.size() - 1);

    }





}

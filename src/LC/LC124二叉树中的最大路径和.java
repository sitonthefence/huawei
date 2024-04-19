package LC;

public class LC124二叉树中的最大路径和 {
    int maxSum = Integer.MIN_VALUE; // 用于记录最大路径和

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // 递归计算左右子树的最大贡献值
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // 计算当前节点为根节点的最大路径和
        int priceNewPath = node.val + leftGain + rightGain;

        // 更新最大路径和的值
        maxSum = Math.max(maxSum, priceNewPath);

        // 返回当前节点的最大贡献值
        return node.val + Math.max(leftGain, rightGain);
    }
}

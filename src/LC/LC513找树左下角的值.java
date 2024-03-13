package LC;

import java.util.ArrayDeque;

public class LC513找树左下角的值 {
    public int findBottomLeftValue(TreeNode root) {
        ArrayDeque<TreeNode> deque=new ArrayDeque<>();
        deque.offerLast(root);
        int result=0;
        while (!deque.isEmpty()){
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = deque.pollFirst();
                if(i==0)  result=treeNode.val;
                if(treeNode.left!=null){
                    deque.offerLast(treeNode.left);
                }
                if(treeNode.right!=null){
                    deque.offerLast(treeNode.right);
                }

            }

        }
        return result;


    }
}

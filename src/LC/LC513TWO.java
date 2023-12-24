package LC;

public class LC513TWO {
    public int Deep=-1;
    public int value=0;

    public int findBottomLeftValue(TreeNode root) {
        value=root.val;
        findBottomLeftValue(root,0);
        return value;

    }
    public void findBottomLeftValue(TreeNode root,int deep){
        if(root==null){
            return;
        }
        if (root.left==null&&root.right==null){
            if(deep>Deep){
                Deep=deep;
                value=root.val;
            }

        }
        findBottomLeftValue(root.left,deep+1);
        findBottomLeftValue(root.right,deep+1);

    }




}

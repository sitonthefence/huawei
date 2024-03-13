package LC;

public class LC226翻转二叉树 {
    public TreeNode invertTree(TreeNode root) {
        if(root!=null){
            swapNode(root);
            invertTree(root.left);
            invertTree(root.right);

        }
        return root;


    }

    public  void  swapNode(TreeNode root){

        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;


    }

}

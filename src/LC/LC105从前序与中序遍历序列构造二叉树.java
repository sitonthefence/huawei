package LC;

import java.util.*;

public class LC105从前序与中序遍历序列构造二叉树 {
    Map<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //利用HashMapMap，以便查找节点的位置
        //利用中序遍历将树分成左右子树
        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i],i);
        return helper(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }
    private TreeNode helper(int[] pre, int[] in, int preL, int preR, int inL, int inR){
        if (preL>preR)  //数组左边值大于右边值说明是无效数组，如果preL==preR说明左子树只有一个节点
            return null;
        TreeNode root=new TreeNode(pre[preL]);//前序遍历的第一个节点就是根节点
        int preRootVal=pre[preL]; //前序遍历的第二个节点就是左子树的开始节点pre_second_node
        int inMid=map.get(preRootVal); //中序遍历节点pre_second_node出现位置（在数组in中的索引）
        int inLeftNum=inMid-inL; //中序遍历数组的左子树节点的个数
            /*
                前序左子树的范围说明:
                    从前序的第一个节点是根节点所以我们从第二个开始，到第一个节点+中序确定的左子树个数结束 preL+1 , preL+inLeftNum
                前序右子树的范围说明:
                    从前序的第一个节点+中序确定的左子树节点个数+1开始，到前序的最后一个位置结束 preL+inLeftNum+1,preR
                中序左子树的范围说明:
                    从中序的第一个节点开始，到前序第二个的节点在中序中出现的位置-1结束（中序根节点的前一个） inL,inMid-1
                中序右子树的范围说明:
                    从前序的第二个的节点在中序中出现的位置+1开始，到中序的最后一个位置结束 inMid+1,inR

                前序左子树的范围[preL+1 , preL+inLeftNum] 中序左子树的范围[inL , inMid-1]
                前序右子树的范围[preL+inLeftNum+1 , preR] 中序右子树的范围[inMid+1 , inR]
            */
        root.left=helper(pre,in,preL+1,preL+inLeftNum,inL,inMid-1);//递归构建左子树
        root.right=helper(pre,in,preL+inLeftNum+1,preR,inMid+1,inR);//递归构建右子树
        return root;
    }


}

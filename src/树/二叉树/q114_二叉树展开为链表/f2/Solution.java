package 树.二叉树.q114_二叉树展开为链表.f2;

import 树.二叉树.TreeNode;

/**
 * @ClassName : Solution
 * @Description :
 * @Author : zph
 * @Date: 2020-07-18 21:36
 * @Version : V1.0
 */
public class Solution {

    /**
     * @return void
     * @Title flatten
     * @Description 改造版本后序遍历 递归
     * 而 6 5 4 3 2 1 的遍历顺序其实变形的后序遍历，遍历顺序是右子树->左子树->根节点。
     * @Author zph
     * @Date 2020/7/18 21:50
     * @Param [root]
     */
    private TreeNode pre=null;
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right=pre;
        root.left=null;
        pre=root;
    }
    

}

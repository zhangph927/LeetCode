package 树.二叉搜索树.q1038_从二叉搜索树到更大和树;

import 树.二叉搜索树.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName : Solution
 * @Description :1038. 从二叉搜索树到更大和树
 * 给出二叉 搜索 树的根节点，该二叉树的节点值各不相同，修改二叉树，使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 *
 * 提醒一下，二叉搜索树满足下列约束条件：
 *
 * 节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。
 * 左右子树也必须是二叉搜索树。
 *
 *
 * 示例：
 *
 *
 *
 * 输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
 * 输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 *
 *
 * 提示：
 *
 * 树中的节点数介于 1 和 100 之间。
 * 每个节点的值介于 0 和 100 之间。
 * 给定的树为二叉搜索树。
 * @Author : zph
 * @Date: 2020-09-21 23:35
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title bstToGst
     * @Description 反序中序遍历
     * @Author zph
     * @Date 2020/9/21 23:40
     * @Param [root]
     * @return 树.二叉搜索树.TreeNode
     */
    public TreeNode bstToGst(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur=root;
        int sum=0;
        while (cur!=null||!stack.isEmpty()){
            if(cur!=null){
                stack.offerLast(cur);
                cur=cur.right;
            }else {
                cur = stack.pollLast();
                sum+=cur.val;
                cur.val=sum;
                cur=cur.left;
            }

        }
        return root;
    }

}

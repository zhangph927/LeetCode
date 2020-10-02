package 树.二叉搜索树.q235_二叉搜索树的最近公共祖先.f1;

import 树.二叉搜索树.TreeNode;

import javax.swing.table.TableRowSorter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : Solution
 * @Description :235. 二叉搜索树的最近公共祖先
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 *
 *
 *
 *
 *
 * 示例 1:
 *
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * 示例 2:
 *
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 输出: 2
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 *
 *
 * 说明:
 *
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉搜索树中。
 * @Author : zph
 * @Date: 2020-09-27 23:13
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title lowestCommonAncestor
     * @Description 两次遍历
     * @Author zph
     * @Date 2020/9/27 23:28
     * @Param [root, p, q]
     * @return 树.二叉搜索树.TreeNode
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        List<TreeNode> pPath = getPath(root, p);
        List<TreeNode> qPath = getPath(root, q);
        int pLen=pPath.size();
        int qLen=qPath.size();
        TreeNode ans=null;
        for(int i=0;i<pLen&&i<qLen;i++){
            if(pPath.get(i)==qPath.get(i)){
                ans= pPath.get(i);
            }else {
                break;
            }

        }
        return ans;
    }

    private List<TreeNode> getPath(TreeNode root, TreeNode target){

        List<TreeNode> path = new ArrayList<>();
        TreeNode node=root;
        while (node!=target){
            path.add(node);
            if(node.val<target.val){
                node=node.right;
            }else {
                node=node.left;
            }
        }
        path.add(node);
        return path;
    }


}

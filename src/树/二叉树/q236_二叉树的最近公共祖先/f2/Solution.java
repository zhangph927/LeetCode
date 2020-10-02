package 树.二叉树.q236_二叉树的最近公共祖先.f2;

import 树.二叉树.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName : Solution
 * @Description :236. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 *
 *
 *
 *
 * 示例 1:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 *
 *
 * 说明:
 *
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 * @Author : zph
 * @Date: 2020-09-28 00:02
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title lowestCommonAncestor
     * @Description 存储父节点
     * @Author zph
     * @Date 2020/9/28 0:09
     * @Param [root, p, q]
     * @return 树.二叉树.TreeNode
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        while (p!=null){
            visited.add(p.val);
            p=parentMap.get(p.val);
        }
        while (q!=null){
            if(visited.contains(q.val)){
                return q;
            }
            q=parentMap.get(q.val);
        }

        return null;


    }

    private Map<Integer,TreeNode> parentMap=new HashMap<>();
    private Set<Integer> visited=new HashSet<>();
    private void dfs(TreeNode root) {
        if(root.left!=null){
            parentMap.put(root.left.val,root);
            dfs(root.left);
        }
        if(root.right!=null){
            parentMap.put(root.right.val,root);
            dfs(root.right);
        }
    }
}

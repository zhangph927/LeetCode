package 树.二叉树.q257_二叉树的所有路径.f1;

import 树.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : Solution
 * @Description :257. 二叉树的所有路径
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 * @Author : zph
 * @Date: 2020-09-05 23:12
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title binaryTreePaths
     * @Description 深度遍历
     * @Author zph
     * @Date 2020/9/5 23:13
     * @Param [root]
     * @return java.util.List<java.lang.String>
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        constructPaths(root,"",res);
        return res;
    }

    private void constructPaths(TreeNode root,String path,List<String> res){
        if(root!=null){
            StringBuffer buffer = new StringBuffer(path);
            buffer.append(root.val);
            if(root.left==null&&root.right==null){
                res.add(buffer.toString());
            }else {
                buffer.append("->");
                constructPaths(root.left,buffer.toString(),res);
                constructPaths(root.right,buffer.toString(),res);
            }


        }

    }
}

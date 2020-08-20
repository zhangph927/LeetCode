package 树相关.二叉搜索树.q1382_将二叉搜索树变平衡.f1;

import 树相关.二叉搜索树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : Solution
 * @Description :1382. 将二叉搜索树变平衡
 * 给你一棵二叉搜索树，请你返回一棵 平衡后 的二叉搜索树，新生成的树应该与原来的树有着相同的节点值。
 *
 * 如果一棵二叉搜索树中，每个节点的两棵子树高度差不超过 1 ，我们就称这棵二叉搜索树是 平衡的 。
 *
 * 如果有多种构造方法，请你返回任意一种。
 *
 *
 *
 * 示例：
 *
 *
 *
 * 输入：root = [1,null,2,null,3,null,4,null,null]
 * 输出：[2,1,3,null,null,null,4]
 * 解释：这不是唯一的正确答案，[3,1,4,null,2,null,null] 也是一个可行的构造方案。
 *
 *
 * 提示：
 *
 * 树节点的数目在 1 到 10^4 之间。
 * 树节点的值互不相同，且在 1 到 10^5 之间。
 * @Author : zph
 * @Date: 2020-08-18 17:36
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title balanceBST
     * @Description 中序遍历
     * @Author zph
     * @Date 2020/8/18 17:39
     * @Param [root]
     * @return 树相关.二叉搜索树.TreeNode
     */
    public TreeNode balanceBST(TreeNode root) {

        List<Integer> inOrderList = new ArrayList<>();
        //中序遍历生成列表
        inOrder(root,inOrderList);

        //根据列表构造平衡二叉搜索树
        TreeNode newTree = buildTree(inOrderList, 0, inOrderList.size() - 1);

        return newTree;

    }

    private TreeNode buildTree(List<Integer> inOrderList,int start,int end){
        if(start>end){
            return null;
        }
        int mid=start+(end-start)/2;
        TreeNode root=new TreeNode(inOrderList.get(mid));
        root.left=buildTree(inOrderList,start,mid-1);
        root.right=buildTree(inOrderList,mid+1,end);
        return root;

    }


    /**
     * @Title inOrder
     * @Description 中序遍历生成列表
     * @Author zph
     * @Date 2020/8/18 17:54
     * @Param [root, inOrderList]
     * @return void
     */
    private void inOrder(TreeNode root,List<Integer> inOrderList){
        if(root!=null){
            inOrder(root.left,inOrderList);
            inOrderList.add(root.val);
            inOrder(root.right,inOrderList);
        }
    }


}

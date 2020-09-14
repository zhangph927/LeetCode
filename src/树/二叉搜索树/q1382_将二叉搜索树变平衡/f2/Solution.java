package 树.二叉搜索树.q1382_将二叉搜索树变平衡.f2;

import 树.二叉搜索树.TreeNode;

import java.util.*;

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
     * @Description 二叉树旋转 手撕AVL
     * @Author zph
     * @Date 2020/8/18 17:39
     * @Param [root]
     * @return 树相关.二叉搜索树.TreeNode
     */
    public TreeNode balanceBST(TreeNode root) {
        if (root == null){
            return null;
        }
        // node节点的高度缓存
        Map<TreeNode,Integer> nodeHeight = new HashMap<>();
        TreeNode newRoot = null;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        // 先序遍历插入（其实用哪个遍历都行）
        while(node != null || !stack.isEmpty()){
            if (node != null){
                // 新树插入
                newRoot = insert(newRoot,node.val,nodeHeight);
                stack.push(node);
                node = node.left;
            }else {
                node = stack.pop();
                node = node.right;
            }
        }
        return newRoot;
    }

    /**
     * 新节点插入
     * @param root root
     * @param val 新加入的值
     * @param nodeHeight 节点高度缓存
     * @return 新的root节点
     */
    private TreeNode insert(TreeNode root,int val,Map<TreeNode,Integer> nodeHeight){
        if (root == null){
            root = new TreeNode(val);
            nodeHeight.put(root,1);// 新节点的高度
            return root;
        }
        TreeNode node = root;
        int cmp = val - node.val;
        if (cmp < 0){
            // 左子树插入
            node.left = insert(root.left,val,nodeHeight);
            // 如果左右子树高度差超过1，进行旋转调整
            if (nodeHeight.getOrDefault(node.left,0) - nodeHeight.getOrDefault(node.right,0) > 1){
                if (val > node.left.val){
                    // 插入在左孩子右边，左孩子先左旋
                    node.left = rotateLeft(node.left,nodeHeight);
                }
                // 节点右旋
                node = rotateRight(node,nodeHeight);
            }
        }else if (cmp > 0){
            // 右子树插入
            node.right = insert(root.right,val,nodeHeight);
            // 如果左右子树高度差超过1，进行旋转调整
            if (nodeHeight.getOrDefault(node.right,0) - nodeHeight.getOrDefault(node.left,0) > 1){
                if (val < node.right.val){
                    // 插入在右孩子左边，右孩子先右旋
                    node.right = rotateRight(node.right,nodeHeight);
                }
                // 节点左旋
                node = rotateLeft(node,nodeHeight);
            }
        }else {
            // 一样的节点，啥都没发生
            return node;
        }
        // 获取当前节点新高度
        int height =  getCurNodeNewHeight(node,nodeHeight);
        // 更新当前节点高度
        nodeHeight.put(node,height);
        return node;
    }

    /**
     * node节点左旋
     * @param node node
     * @param nodeHeight node高度缓存
     * @return 旋转后的当前节点
     */
    private TreeNode rotateLeft(TreeNode node,Map<TreeNode,Integer> nodeHeight){
        // ---指针调整
        TreeNode right = node.right;
        node.right = right.left;
        right.left = node;
        // ---高度更新
        // 先更新node节点的高度，这个时候node是right节点的左孩子
        int newNodeHeight = getCurNodeNewHeight(node,nodeHeight);
        // 更新node节点高度
        nodeHeight.put(node,newNodeHeight);
        // newNodeHeight是现在right节点左子树高度，原理一样，取现在right左右子树最大高度+1
        int newRightHeight = Math.max(newNodeHeight,nodeHeight.getOrDefault(right.right,0)) + 1;
        // 更新原right节点高度
        nodeHeight.put(right,newRightHeight);
        return right;
    }

    /**
     * node节点右旋
     * @param node node
     * @param nodeHeight node高度缓存
     * @return 旋转后的当前节点
     */
    private TreeNode rotateRight(TreeNode node,Map<TreeNode,Integer> nodeHeight){
        // ---指针调整
        TreeNode left = node.left;
        node.left = left.right;
        left.right = node;
        // ---高度更新
        // 先更新node节点的高度，这个时候node是right节点的左孩子
        int newNodeHeight = getCurNodeNewHeight(node,nodeHeight);
        // 更新node节点高度
        nodeHeight.put(node,newNodeHeight);
        // newNodeHeight是现在left节点右子树高度，原理一样，取现在right左右子树最大高度+1
        int newLeftHeight = Math.max(newNodeHeight,nodeHeight.getOrDefault(left.left,0)) + 1;
        // 更新原left节点高度
        nodeHeight.put(left,newLeftHeight);
        return left;
    }

    /**
     * 获取当前节点的新高度
     * @param node node
     * @param nodeHeight node高度缓存
     * @return 当前node的新高度
     */
    private int getCurNodeNewHeight(TreeNode node, Map<TreeNode,Integer> nodeHeight){
        // node节点的高度，为现在node左右子树最大高度+1
        return Math.max(nodeHeight.getOrDefault(node.left,0),nodeHeight.getOrDefault(node.right,0)) + 1;
    }



}

package 树相关.二叉搜索树.q109_有序链表转换二叉搜索树.f2;

import 树相关.二叉搜索树.TreeNode;
import 树相关.二叉搜索树.q109_有序链表转换二叉搜索树.ListNode;

/**
 * @ClassName : Solution
 * @Description :109. 有序链表转换二叉搜索树
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * <p>
 * 示例:
 * <p>
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 * <p>
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 * 通过次数55,757
 * @Author : zph
 * @Date: 2020-08-18 23:50
 * @Version : V1.0
 */
public class Solution {
    /**
     * @return 树相关.二叉搜索树.TreeNode
     * @Title sortedListToBST
     * @Description 分治 + 中序遍历优化
     * @Author zph
     * @Date 2020/8/18 23:52
     * @Param [head]
     */
    private ListNode globalHead;

    public TreeNode sortedListToBST(ListNode head) {

        globalHead = head;
        int length = getLength(head);

        return buildTree(0, length - 1);

    }

    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }
        return length;

    }

    private TreeNode buildTree(int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode();
        root.left = buildTree(left, mid - 1);
        root.val = globalHead.val;
        globalHead = globalHead.next;
        root.right = buildTree(mid + 1, right);
        return root;

    }


}

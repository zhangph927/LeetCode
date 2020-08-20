package 树相关.二叉搜索树.q109_有序链表转换二叉搜索树.f1;

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
     * @Description 分治
     * @Author zph
     * @Date 2020/8/18 23:52
     * @Param [head]
     */
    public TreeNode sortedListToBST(ListNode head) {


        return buildTree(head, null);

    }

    private TreeNode buildTree(ListNode left, ListNode right) {
        if (left == right) {
            return null;
        }
        ListNode mid = getMedian(left, right);
        TreeNode root = new TreeNode(mid.val);
        root.left = buildTree(left, mid);
        root.right = buildTree(mid.next, right);
        return root;

    }


    private ListNode getMedian(ListNode left, ListNode right) {
        ListNode fast = left;
        ListNode slow = left;
        while (fast != right && fast.next != right) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;


    }
}

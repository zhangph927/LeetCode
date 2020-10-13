package 链表.q148_排序链表.f1;

import 链表.q148_排序链表.ListNode;

/**
 * @ClassName : Solution
 * @Description :148. 排序链表
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 * <p>
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 * @Author : zph
 * @Date: 2020-08-07 12:37
 * @Version : V1.0
 */
public class Solution {
    /**
     * @return 排序算法.归并排序.q148_排序链表.ListNode
     * @Title sortList
     * @Description 归并排序（递归法）
     * @Author zph
     * @Date 2020/8/8 22:46
     * @Param [head]
     */
    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(temp);
        ListNode dummyHead = new ListNode(-1);
        ListNode tail = dummyHead;
        while (left != null && right != null) {
            if (left.val < right.val) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }
        tail.next=left!=null?left:right;
        return dummyHead.next;

    }
}

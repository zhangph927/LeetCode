package 链表.q61_旋转链表;

import 链表.ListNode;

import java.util.concurrent.Exchanger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName : Solution
 * @Description :61. 旋转链表
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 * <p>
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 * @Author : zph
 * @Date: 2020-09-16 01:04
 * @Version : V1.0
 */
public class Solution {

    /**
     * @return 链表.ListNode
     * @Title rotateRight
     * @Description 直觉
     * <p>
     * 链表中的点已经相连，一次旋转操作意味着：
     * <p>
     * 先将链表闭合成环
     * 找到相应的位置断开这个环，确定新的链表头和链表尾
     * @Author zph
     * @Date 2020/9/16 10:51
     * @Param [head, k]
     */
    public ListNode rotateRight(ListNode head, int k) {
        // base cases
        if (head == null) return null;
        if (head.next == null) return head;

        // close the linked list into the ring
        ListNode old_tail = head;
        int n;
        for (n = 1; old_tail.next != null; n++)
            old_tail = old_tail.next;
        old_tail.next = head;

        // find new tail : (n - k % n - 1)th node
        // and new head : (n - k % n)th node
        ListNode new_tail = head;
        for (int i = 0; i < n - k % n - 1; i++)
            new_tail = new_tail.next;
        ListNode new_head = new_tail.next;

        // break the ring
        new_tail.next = null;



        return new_head;
    }
}

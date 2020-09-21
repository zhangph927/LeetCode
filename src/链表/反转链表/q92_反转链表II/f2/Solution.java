package 链表.反转链表.q92_反转链表II.f2;

import 链表.ListNode;

/**
 * @ClassName : Solution
 * @Description :92. 反转链表 II
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 * @Author : zph
 * @Date: 2020-09-18 00:31
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title reverseBetween
     * @Description 迭代/双指针
     * @Author zph
     * @Date 2020/9/18 0:54
     * @Param [head, m, n]
     * @return 链表.ListNode
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode hd = new ListNode(0);  hd.next = head;
        ListNode prev = hd, last;
        for (int i = 0; i < m-1; ++i) {
            prev = prev.next;
        }
        last = prev.next;
        for (int i = m; i < n; ++i) {
            last = last.next;
        }
        reverse(prev, last);
        return hd.next;
    }

    private void reverse(ListNode prev, ListNode last) {
        ListNode pre = last.next, cur = prev.next, nxt;
        while (cur != last) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        cur.next = pre;
        prev.next = last;
    }



}

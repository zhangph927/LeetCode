package 链表.q143_重排链表.f3;

import 链表.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName : Solutio
 * @Description :143. 重排链表
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 *
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 *
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 * @Author : zph
 * @Date: 2020-09-19 18:12
 * @Version : V1.0
 */
public class Solution {


    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        Deque<ListNode> stack = new LinkedList<>();
        ListNode p = head;
        while (p != null) {
            stack.push(p);
            p = p.next;
        }
        int n = stack.size();
        int count = (n - 1) / 2;
        p = head;
        while (count != 0) {
            ListNode tmp = stack.pop();
            tmp.next = p.next;
            p.next = tmp;
            p = tmp.next;
            --count;
        }
        stack.pop().next = null;
    }



}

package 链表.q143_重排链表.f2;

import 链表.ListNode;

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


    /**
     * @Title reorderList
     * @Description TODO  暂时不理解
     * @Author zph
     * @Date 2020/9/19 23:01
     * @Param [head]
     * @return void
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode slow = head;
        ListNode fast = head;
        // 找中点 1 2 3 4 5 6
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // 翻转中点, 才用插入法 1 2 3 6 5 4
        ListNode pre = slow;
        ListNode cur = slow.next;
        //未断开翻转
        while (cur.next != null){
            ListNode tmp = cur.next;
            cur.next = tmp.next;
            tmp.next = pre.next;
            pre.next = tmp;
        }

        // 拼接 1 6 2 5 3 4
        ListNode p1 = head;
        ListNode p2 = slow.next;
        while (p1 != slow){
            // 建议大家这部分画图, 很容易理解的
            slow.next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
            p2 = slow.next;
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2=new ListNode(2);
        ListNode listNode3=new ListNode(3);
        ListNode listNode4=new ListNode(4);
        ListNode listNode5=new ListNode(5);
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        listNode4.next=listNode5;

        solution.reorderList(listNode1);


    }



}

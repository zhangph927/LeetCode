package 链表.q24_两两交换链表中的节点.f1;

import 链表.ListNode;

/**
 * @ClassName : Solution
 * @Description :24. 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * @Author : zph
 * @Date: 2020-09-18 23:19
 * @Version : V1.0
 */
public class Solution {

    /**
     * @Title swapPairs
     * @Description 递归
     * @Author zph
     * @Date 2020/9/18 23:23
     * @Param [head]
     * @return 链表.ListNode
     */
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode firstNode=head;
        ListNode secondNode=head.next;
        firstNode.next=swapPairs(secondNode.next);
        secondNode.next=firstNode;
        return secondNode;
    }

}

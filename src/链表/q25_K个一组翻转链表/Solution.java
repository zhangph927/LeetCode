package 链表.q25_K个一组翻转链表;

import 链表.ListNode;

/**
 * @ClassName : Solution
 * @Description :25. K 个一组翻转链表
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 *
 *
 * 示例：
 *
 * 给你这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 *
 *
 * 说明：
 *
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * @Author : zph
 * @Date: 2020-09-19 00:53
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title reverseKGroup
     * @Description 模拟翻转
     * @Author zph
     * @Date 2020/9/19 17:19
     * @Param [head, k]
     * @return 链表.ListNode
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next=head;
        ListNode pre=dummy;

        ListNode copyHead=head;
        while (copyHead!=null){
            ListNode tail=pre;
            //查看剩余部分长度是否大于等于k
            for(int i=0;i<k;i++){
                tail=tail.next;
                if(tail==null){
                    return dummy.next;
                }
            }
            ListNode nex=tail.next;

            ListNode[] reverse = reverse(copyHead, tail);
            copyHead=reverse[0];
            tail=reverse[1];
            //把子链表重新接回原链表
            pre.next=copyHead;
            tail.next=nex;

            pre=tail;
            copyHead=tail.next;
        }

        return dummy.next;
    }
    /**
     * @Title reverse
     * @Description 翻转子链表
     * @Author zph
     * @Date 2020/9/19 17:42
     * @Param [head, tail]
     * @return 链表.ListNode[]
     */
    private ListNode[] reverse(ListNode head,ListNode tail){
        ListNode pre=tail.next;
        ListNode cur=head;
        while (pre!=tail){
            ListNode temp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=temp;
        }
        return new ListNode[]{tail,head};
    }

}

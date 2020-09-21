package 链表.q86_分隔链表;

import 链表.ListNode;

import java.util.List;

/**
 * @ClassName : Solution
 * @Description :86. 分隔链表
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 *
 *
 * 示例:
 *
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 * @Author : zph
 * @Date: 2020-09-19 17:54
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title partition
     * @Description 双指针法
     * @Author zph
     * @Date 2020/9/19 18:02
     * @Param [head, x]
     * @return 链表.ListNode
     */
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        ListNode copyHead=head;
        ListNode p1=dummy1;
        ListNode p2=dummy2;
        while (copyHead!=null){
            if(copyHead.val<x){
                p1.next=copyHead;
                p1=p1.next;

            }else {
                p2.next=copyHead;
                p2=p2.next;
            }
            copyHead=copyHead.next;
        }
        p1.next=dummy2.next;
        p2.next=null;
        return dummy1.next;
    }
}

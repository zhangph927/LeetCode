package 链表.q82_删除排序链表中的重复元素II;

import 链表.ListNode;

/**
 * @ClassName : Solution
 * @Description :82. 删除排序链表中的重复元素 II
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 *
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 * @Author : zph
 * @Date: 2020-09-19 23:49
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title deleteDuplicates
     * @Description 双指针
     * @Author zph
     * @Date 2020/9/19 23:59
     * @Param [head]
     * @return 链表.ListNode
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode cur=dummy;
        while (cur.next!=null&&cur.next.next!=null){
            if(cur.next.val==cur.next.next.val){
                ListNode temp=cur.next;
                while (temp!=null&&temp.next!=null&&temp.val==temp.next.val){
                    temp=temp.next;
                }
                cur.next=temp.next;

            }else {
                cur=cur.next;
            }

        }

        return dummy.next;
    }
}

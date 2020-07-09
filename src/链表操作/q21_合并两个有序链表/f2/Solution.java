package 链表操作.q21_合并两个有序链表.f2;

import 链表操作.ListNode;

/**
 * @ClassName : Solution
 * @Description :21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 *
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * @Author : zph
 * @Date: 2020-07-08 21:01
 * @Version : V1.0
 */
public class Solution {



    /**
     * @Title mergeTwoLists
     * @Description 迭代
     * @Author zph
     * @Date 2020/7/8 21:16
     * @Param [l1, l2]
     * @return 链表操作.ListNode
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode pre=head;
        while (l1!=null&&l2!=null){
            if(l1.val<=l2.val){
                pre.next=l1;
                l1=l1.next;
            }else {
                pre.next=l2;
                l2=l2.next;
            }
            pre=pre.next;
        }
        pre.next=l1==null?l2:l1;
        return head.next;


    }


}

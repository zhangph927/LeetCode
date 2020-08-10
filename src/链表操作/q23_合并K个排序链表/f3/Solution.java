package 链表操作.q23_合并K个排序链表.f3;

import 链表操作.ListNode;

/**
 * @ClassName : Solution
 * @Description :23. 合并K个排序链表
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 * @Author : zph
 * @Date: 2020-08-07 18:00
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title mergeKLists
     * @Description 逐一合并两条链表递归版
     * @Author zph
     * @Date 2020/8/7 18:02
     * @Param [lists]
     * @return 链表操作.ListNode
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res=null;
        for(ListNode list: lists){
            res=merge2Lists(res,list);
        }
        return res;
    }
    private ListNode merge2Lists(ListNode list1,ListNode list2) {
       if(list1==null){
           return list2;
       }
       if(list2==null){
           return list1;
       }
       if(list1.val<list2.val){
           list1.next=merge2Lists(list1.next,list2);
           return list1;
       }
        list2.next=merge2Lists(list1,list2.next);
       return list2;

    }
}

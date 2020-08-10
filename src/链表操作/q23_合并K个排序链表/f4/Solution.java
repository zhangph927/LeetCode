package 链表操作.q23_合并K个排序链表.f4;

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
     * @Description 逐一合并两条链表迭代版
     * @Author zph
     * @Date 2020/8/7 18:02
     * @Param [lists]
     * @return 链表操作.ListNode
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0){
            return null;
        }
        return merge(lists,0,lists.length-1);
    }
    private ListNode merge(ListNode[] lists,int lo,int hi){
        if(lo==hi){
            return lists[lo];
        }
        int mid=lo+(hi-lo)/2;
        ListNode l1=merge(lists,lo,mid);
        ListNode l2=merge(lists,mid+1,hi);
        return merge2Lists(l1,l2);

    }
    private ListNode merge2Lists(ListNode list1,ListNode list2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode tail=dummyNode;
        while (list1!=null&&list2!=null){
            if(list1.val<list2.val){
                tail.next=list1;

                list1=list1.next;
            }else {
                tail.next=list2;
                list2=list2.next;
            }
            tail=tail.next;
        }
       tail.next= list1==null?list2:list1;
        return dummyNode.next;


    }
}

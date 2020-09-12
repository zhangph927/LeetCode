package 链表.q23_合并K个排序链表.f1;

import 链表.ListNode;

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
     * @Description K指针
     * @Author zph
     * @Date 2020/8/7 18:02
     * @Param [lists]
     * @return 链表操作.ListNode
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummyHead = new ListNode(-1);
        int length=lists.length;
        ListNode tail =dummyHead;
        while (true){
            ListNode minHead =null;
            int minPointer=-1;
            for(int i=0;i<length;i++){
                if(lists[i]==null){
                    continue;
                }
                if(minHead==null||minHead.val>lists[i].val){
                    minHead=lists[i];
                    minPointer=i;
                }
            }
            if(minPointer==-1){
                break;
            }
            tail.next=minHead;
            tail=tail.next;
            lists[minPointer]=lists[minPointer].next;
        }
        return dummyHead.next;


    }
}

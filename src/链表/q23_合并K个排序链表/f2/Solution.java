package 链表.q23_合并K个排序链表.f2;

import 链表.ListNode;

import java.util.PriorityQueue;
import java.util.Queue;

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
     * @Description 小顶堆
     * @Author zph
     * @Date 2020/8/7 18:02
     * @Param [lists]
     * @return 链表操作.ListNode
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummyHead = new ListNode(-1);
        Queue<ListNode> queue = new PriorityQueue<>((l1,l2)->l1.val-l2.val);
        for(ListNode node:lists){
            if (node!=null){
                queue.offer(node);
            }
        }
        ListNode tail =dummyHead;
        while (!queue.isEmpty()){
            ListNode minNode = queue.poll();
            tail.next=minNode;
            tail=tail.next;
            if(minNode.next!=null){
                queue.offer(minNode.next);
            }
        }
        return dummyHead.next;


    }
}

package 链表.q83_删除排序链表中的重复元素;


import 链表.ListNode;

/**
 * @ClassName : Solution
 * @Description :83. 删除排序链表中的重复元素
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 * @Author : zph
 * @Date: 2020-09-16 00:57
 * @Version : V1.0
 */
public class Solution {

    /**
     * @Title deleteDuplicates
     * @Description 直接法
     * @Author zph
     * @Date 2020/9/16 1:00
     * @Param [head]
     * @return 链表.ListNode
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current=head;
        while (current!=null&&current.next!=null){
            if(current.next.val==current.val){
                current.next=current.next.next;

            }else {
                current=current.next;
            }

        }
        return head;
    }
}

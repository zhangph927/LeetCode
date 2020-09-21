package 链表.q147_对链表进行插入排序;

import 链表.ListNode;

/**
 * @ClassName : Solution
 * @Description :147. 对链表进行插入排序
 * 对链表进行插入排序。
 *
 *
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 *
 *
 *
 * 插入排序算法：
 *
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *
 *
 * 示例 1：
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2：
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 * @Author : zph
 * @Date: 2020-09-20 00:00
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title insertionSortList
     * @Description 插入排序
     * @Author zph
     * @Date 2020/9/20 0:04
     * @Param [head]
     * @return 链表.ListNode
     */
    public ListNode insertionSortList(ListNode head) {
        if (head==null ||head.next==null)
            return head;
        ListNode pre=head,cur=head.next;           //使用前驱节点pre便于后续节点的删除操作
        ListNode dummy=new ListNode(0);         //建立一个头结点，便于链表的插入
        dummy.next=head;
        while (cur!=null){
            if (pre.val<cur.val){                   //前后节点已经有序，无需重排
                pre=cur;
                cur=cur.next;
            }
            else {
                ListNode p=dummy;
                while (p.next!=cur &&p.next.val<cur.val)
                    p=p.next;
                pre.next=cur.next;         //删除当前节点
                cur.next=p.next;          //将当前节点连接到对应位置
                p.next=cur;
                cur=pre.next;
            }
        }
        return dummy.next;
    }

}

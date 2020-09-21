package 链表.q24_两两交换链表中的节点.f2;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;
import sun.rmi.log.LogInputStream;
import 链表.ListNode;

/**
 * @ClassName : Solution
 * @Description :24. 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * @Author : zph
 * @Date: 2020-09-18 23:19
 * @Version : V1.0
 */
public class Solution {

    /**
     * @Title swapPairs
     * @Description 迭代
     * firstNode（即 A） 和 secondNode（即 B） 分别遍历偶数节点和奇数节点，即两步看作一步。
     * 交换两个节点：
     *
     *  firstNode.next = secondNode.next
     *  secondNode.next = firstNode
     * 还需要更新 prevNode.next 指向交换后的头。
     *
     * prevNode.next = secondNode
     * 迭代完成后得到最终的交换结果。
     *
     * @Author zph
     * @Date 2020/9/18 23:23
     * @Param [head]
     * @return 链表.ListNode
     */
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode dummy= new ListNode(-1);
        dummy.next=head;
        ListNode preNode=dummy;
        ListNode copyHead=head;
        while (copyHead!=null&&copyHead.next!=null){
            ListNode firstNode=copyHead;
            ListNode secondNode=copyHead.next;

            preNode.next=secondNode;
            firstNode.next=secondNode.next;
            secondNode.next=firstNode;

            preNode=firstNode;
            copyHead=firstNode.next;
        }
        return dummy.next;

    }

}

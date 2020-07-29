package 链表操作.q19_删除链表的倒数第N个节点.f2;

import 链表操作.ListNode;

/**
 * @ClassName : Solution
 * @Description :19. 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 * @Author : zph
 * @Date: 2020-07-26 18:41
 * @Version : V1.0
 */
public class Solution {

    /**
     * @Title removeNthFromEnd
     * @Description 一次遍历
     * @Author zph
     * @Date 2020/7/26 18:50
     * @Param [head, n]
     * @return 链表操作.ListNode
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy= new ListNode(-1);
        dummy.next=head;
        ListNode first=dummy;
        ListNode second=dummy;
        int length=n+1;
        for(int i=1; i<=length;i++ ){
            first=first.next;
        }

        while (first!=null){
            first=first.next;
            second=second.next;
        }
        second.next=second.next.next;
        return dummy.next;

    }
}

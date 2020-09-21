package 链表.反转链表.q92_反转链表II.f3;

import 链表.ListNode;

/**
 * @ClassName : Solution
 * @Description :92. 反转链表 II
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 * @Author : zph
 * @Date: 2020-09-18 00:31
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title reverseBetween
     * @Description 本题的反转链表把握好四个关键结点即可。
     *
     * 反转部分的原起点（即反转后的新终点）
     * 反转部分的原终点（即反转后的新起点）
     * 反转部分的前一个结点
     * 反转部分的后一个结点
     * 以1->2->3->4->5->NULL, m = 2, n = 4为例，这四个关键结点分别是：2、4、1、5。
     * 我们要做的就是将反转部分反转，然后把反转部分的前一个结点连接到新起点，
     * 将新终点连接到反转部分的后一个结点即可。
     * 即反转后，把1连接到4，2连接到5。
     *
     * 至于反转部分，我们用如下代码完成结点cur和结点pre的反转。
     *
     *
     * ListNode next = cur.next;
     * cur.next = pre;
     * pre = cur;
     * cur = next;
     * 上述操作都可以通过一次顺序遍历完成。
     *
     * @Author zph
     * @Date 2020/9/18 17:50
     * @Param [head, m, n]
     * @return 链表.ListNode
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        //虚拟头结点，为了得到反转原起点的前一个结点，以便连接反转后的新起点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode  copyHead = dummy;
        for(int i = 0; i < m - 1; i++)
            copyHead = copyHead.next; //用head表示反转原起点的前一个结点
        ListNode newtail = copyHead.next, pre = copyHead.next, cur = pre.next;
        for(int i = 0; i < n - m; i++)
        {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        } //反转完成后，新起点为pre，新终点为newtail
        newtail.next = cur; //将新终点与后面的链表连接
        copyHead.next = pre; //将反转原起点的前一个结点连接到反转后的新起点
        return dummy.next;
    }

    /**
     * @Title main
     * @Description 输入: 1->2->3->4->5->NULL, m = 2, n = 4
     * 输出: 1->4->3->2->5->NULL
     * @Author zph
     * @Date 2020/9/18 16:42
     * @Param [args]
     * @return void
     */
    public static void main(String[] args) {

        Solution solution = new Solution();
        ListNode head1=new ListNode(1);
        ListNode head2=new ListNode(2);
        ListNode head3=new ListNode(3);
        ListNode head4=new ListNode(4);
        ListNode head5=new ListNode(5);
        head1.next=head2;
        head2.next=head3;
        head3.next=head4;
        head4.next=head5;

        solution.reverseBetween(head1,2,4);

        System.out.println(head1);


    }

}

package 链表.反转链表.q206_反转链表.f1;

import 链表.ListNode;

/**
 * @ClassName : Solution
 * @Description :206. 反转链表
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * @Author : zph
 * @Date: 2020-07-08 20:36
 * @Version : V1.0
 */
public class Solution {
    /**
     * @return 链表操作.ListNode
     * @Title reverseList
     * @Description 迭代
     * @Author zph
     * @Date 2020/7/8 20:39
     * @Param [head]
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
    private String printList(ListNode node){
        StringBuffer buffer = new StringBuffer();
        while (node!=null){
            buffer.append(node.val);
            buffer.append("->");
            node= node.next;
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2=new ListNode(2);
        ListNode listNode3=new ListNode(3);
        ListNode listNode4=new ListNode(4);
        ListNode listNode5=new ListNode(5);
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        listNode4.next=listNode5;

        Solution solution= new Solution();
        String s1 = solution.printList(listNode1);
        System.out.println(s1);
        ListNode listNode = solution.reverseList(listNode1);
        String s2 = solution.printList(listNode);
        System.out.println(s2);


    }

}

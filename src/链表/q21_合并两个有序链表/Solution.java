package 链表.q21_合并两个有序链表;

import 链表.ListNode;

import java.util.concurrent.Semaphore;

/**
 * @ClassName : Solution
 * @Description :
 * @Author : zph
 * @Date: 2020-09-16 16:30
 * @Version : V1.0
 */
public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode head=dummy;
        while (l1!=null&&l2!=null){
            if(l1.val<l2.val){
                head.next=l1;
                l1=l1.next;
            }else {
                head.next=l2;
                l2=l2.next;
            }
            head=head.next;
        }
        head.next=l1!=null?l1:l2;
        return dummy.next;



    }


}

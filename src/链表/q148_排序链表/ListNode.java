package 链表.q148_排序链表;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int[] x) {
        val = x[0];
        int length = x.length;
        ListNode cur = this;
        for (int i = 1; i < length; i++) {
            cur.next = new ListNode(x[i]);
            cur = cur.next;
        }
    }

}

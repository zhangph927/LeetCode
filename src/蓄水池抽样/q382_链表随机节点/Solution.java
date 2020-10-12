package 蓄水池抽样.q382_链表随机节点;

import java.util.Random;

/**
 * @ClassName : Solution
 * @Description :382. 链表随机节点
 * 给定一个单链表，随机选择链表的一个节点，并返回相应的节点值。保证每个节点被选的概率一样。
 *
 * 进阶:
 * 如果链表十分大且长度未知，如何解决这个问题？你能否使用常数级空间复杂度实现？
 *
 * 示例:
 *
 * // 初始化一个单链表 [1,2,3].
 * ListNode head = new ListNode(1);
 * head.next = new ListNode(2);
 * head.next.next = new ListNode(3);
 * Solution solution = new Solution(head);
 *
 * // getRandom()方法应随机返回1,2,3中的一个，保证每个元素被返回的概率相等。
 * solution.getRandom();
 * @Author : zph
 * @Date: 2020-10-09 12:38
 * @Version : V1.0
 */
public class Solution {
    private ListNode root;
    public Solution(ListNode head) {
        this.root=head;
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int[] res = {-1};
        boolean isFull = false;
        int cut = 0;
        ListNode head = root;
        while (head!=null){
                cut++;
                if (!isFull) {
                    res[0] = head.val;
                    isFull = true;
                } else {
                    Random random = new Random();
                    int i1 = random.nextInt(cut);
                    if (i1 < 1) {
                        res[0] = head.val;
                    }
                }
                head=head.next;
        }
        return res[0];

    }
}

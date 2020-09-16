package 链表.环形链表.q142_环形链表II.f1;

import 链表.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName : Solution
 * @Description :142. 环形链表 II
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 说明：不允许修改给定的链表。
 *
 *
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 *
 * 示例 2：
 *
 * 输入：head = [1,2], pos = 0
 * 输出：tail connects to node index 0
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 *
 * 示例 3：
 *
 * 输入：head = [1], pos = -1
 * 输出：no cycle
 * 解释：链表中没有环。
 *
 *
 *
 *
 * 进阶：
 * 你是否可以不用额外空间解决此题？
 * @Author : zph
 * @Date: 2020-09-15 00:39
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title detectCycle
     * @Description 哈希表
     * @Author zph
     * @Date 2020/9/15 0:41
     * @Param [head]
     * @return 链表.ListNode
     */
        public ListNode detectCycle(ListNode head) {
            Set<ListNode> visited = new HashSet<>();
            ListNode node = head;
            while (node != null) {
                if (visited.contains(node)) {
                    return node;
                }
                visited.add(node);
                node = node.next;
            }

            return null;
        }

}

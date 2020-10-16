package 链表.q234_回文链表.f1;

import 链表.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : Solution
 * @Description :234. 回文链表
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * @Author : zph
 * @Date: 2020-10-15 00:28
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title isPalindrome
     * @Description 将值复制到数组中后用双指针法
     * @Author zph
     * @Date 2020/10/15 0:30
     * @Param [head]
     * @return boolean
     */
    public boolean isPalindrome(ListNode head) {
        List<Integer> vals = new ArrayList<>();

        // Convert LinkedList into ArrayList.
        ListNode currentNode = head;
        while (currentNode != null) {
            vals.add(currentNode.val);
            currentNode = currentNode.next;
        }

        // Use two-pointer technique to check for palindrome.
        int front = 0;
        int back = vals.size() - 1;
        while (front < back) {
            // Note that we must use ! .equals instead of !=
            // because we are comparing Integer, not int.
            if (!vals.get(front).equals(vals.get(back))) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }

}

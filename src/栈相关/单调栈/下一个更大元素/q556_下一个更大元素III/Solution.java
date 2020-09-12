package 栈相关.单调栈.下一个更大元素.q556_下一个更大元素III;

/**
 * @ClassName : Solution
 * @Description :556. 下一个更大元素 III
 * 给定一个32位正整数 n，你需要找到最小的32位整数，其与 n 中存在的位数完全相同，
 * 并且其值大于n。如果不存在这样的32位整数，则返回-1。
 *
 * 示例 1:
 *
 * 输入: 12
 * 输出: 21
 * 示例 2:
 *
 * 输入: 21
 * 输出: -1
 * @Author : zph
 * @Date: 2020-09-12 15:51
 * @Version : V1.0
 */
public class Solution {
    public int nextGreaterElement(int n) {
        char[] a = ("" + n).toCharArray();
        int i = a.length - 2;
        while (i >= 0 && a[i + 1] <= a[i]) {
            i--;
        }
        if (i < 0)
            return -1;
        int j = a.length - 1;
        while (j >= 0 && a[j] <= a[i]) {
            j--;
        }
        swap(a, i, j);
        reverse(a, i + 1);
        try {
            return Integer.parseInt(new String(a));
        } catch (Exception e) {
            return -1;
        }
    }
    private void reverse(char[] a, int start) {
        int i = start, j = a.length - 1;
        while (i < j) {
            swap(a, i, j);
            i++;
            j--;
        }
    }
    private void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}

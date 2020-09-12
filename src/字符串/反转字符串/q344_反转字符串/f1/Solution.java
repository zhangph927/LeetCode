package 字符串.反转字符串.q344_反转字符串.f1;

/**
 * @ClassName : Solution
 * @Description :344. 反转字符串
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 *
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 *
 *
 *
 * 示例 1：
 *
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * 示例 2：
 *
 * 输入：["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 * @Author : zph
 * @Date: 2020-08-30 23:48
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title reverseString
     * @Description 递归
     * @Author zph
     * @Date 2020/8/30 23:49
     * @Param [s]
     * @return void
     */
    public void reverseString(char[] s) {
        helper(s,0,s.length-1);

    }
    private void helper(char[] s,int left,int right){
        if(left>=right){
            return;
        }
        char temp=s[left];
        s[left++]=s[right];
        s[right--]=temp;
        helper(s,left,right);
    }
}

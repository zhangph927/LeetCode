package 动态规划.q剑指_Offer_46_把数字翻译成字符串.f2;

/**
 * @ClassName : Solution
 * @Description :剑指 Offer 46. 把数字翻译成字符串
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 *
 *
 * 示例 1:
 *
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *
 *
 * 提示：
 *
 * 0 <= num < 231
 * @Author : zph
 * @Date: 2020-07-18 19:30
 * @Version : V1.0
 */
public class Solution {

    /**
     * @Title translateNum
     * @Description 动态规划+滚动数组
     * @Author zph
     * @Date 2020/7/18 20:55
     * @Param [num]
     * @return int
     */
    public int translateNum(int num) {
        if(num<10){
            return 1;
        }
        char[] numChars = String.valueOf(num).toCharArray();
        int length=numChars.length;
        int first=1;
        int n=(numChars[0]-'0')*10+numChars[1]-'0';
        int second=(n>9&&n<26)?2:1;
        for(int i=2;i<length;i++){
            n=(numChars[i-1]-'0')*10+numChars[i]-'0';
            if(n>9&&n<26){
                int temp=second;
                second=first+second;
                first=temp;
            }else {
                first=second;
            }
        }
        return second;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        int i = solution.translateNum(21);
        System.out.println(i);

    }
}

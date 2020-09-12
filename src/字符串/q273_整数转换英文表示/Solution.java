package 字符串.q273_整数转换英文表示;

/**
 * @ClassName : Solution
 * @Description :273. 整数转换英文表示
 * 将非负整数转换为其对应的英文表示。可以保证给定输入小于 231 - 1 。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: "One Hundred Twenty Three"
 * 示例 2:
 *
 * 输入: 12345
 * 输出: "Twelve Thousand Three Hundred Forty Five"
 * 示例 3:
 *
 * 输入: 1234567
 * 输出: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * 示例 4:
 *
 * 输入: 1234567891
 * 输出: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 * @Author : zph
 * @Date: 2020-08-21 17:58
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title numberToWords
     * @Description 分治+递归
     * @Author zph
     * @Date 2020/8/21 18:16
     * @Param [num]
     * @return java.lang.String
     */
    private final String[] LESSTHAN = {"", "One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    private final String[] TENS = {"", "Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    private final String[] THOUSAND = {"", "Thousand", "Million", "Billion", "Trillion"};


    public String numberToWords(int num) {
        if(num==0){
            return "Zero";
        }
        int i=0;
        String ans="";
        // 将数字 3 位 3 位的拆分处理（即千位）
        while(num>0){
            if(num%1000!=0){
                ans=helper(num%1000)+THOUSAND[i]+" "+ans;
            }
            i++;
            num=num/1000;
        }
        return ans.trim();

    }

    private String helper(int num){
        if(num==0){
            return "";
        }else if(num<20){
            return LESSTHAN[num]+" ";
        }else if(num<100){
            return TENS[num/10]+" "+helper(num%10);
        }else {
            return LESSTHAN[num/100]+" Hundred "+helper(num%100);
        }
    }
}

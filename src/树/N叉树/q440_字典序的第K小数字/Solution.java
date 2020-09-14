package 树.N叉树.q440_字典序的第K小数字;

/**
 * @ClassName : Solution
 * @Description :440. 字典序的第K小数字
 * 给定整数 n 和 k，找到 1 到 n 中字典序第 k 小的数字。
 * <p>
 * 注意：1 ≤ k ≤ n ≤ 109。
 * <p>
 * 示例 :
 * <p>
 * 输入:
 * n: 13   k: 2
 * <p>
 * 输出:
 * 10
 * <p>
 * 解释:
 * 字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。
 * @Author : zph
 * @Date: 2020-07-19 21:21
 * @Version : V1.0
 */
public class Solution {

    public int findKthNumber(int n, int k) {
        int cur=1;
        int prefix=1;
        while(cur<k){
            int tmp=getCount(n,prefix);
            if(tmp+cur>k){
                prefix*=10;
                cur++;
            }else {
                prefix++;
                cur+=tmp;
            }

        }
        return prefix;
    }

    private int getCount(int n,int prefix){
        long cur=prefix;
        long next=cur+1;
        int count=0;
        while(cur<=n){
            count+=Math.min(n+1,next)-cur;
            cur*=10;
            next*=10;
        }
        return count;

    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int kthNumber = solution.findKthNumber(13, 2);
        System.out.println(kthNumber);


    }

}

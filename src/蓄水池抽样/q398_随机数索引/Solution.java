package 蓄水池抽样.q398_随机数索引;

import java.util.Random;

/**
 * @ClassName : Solution
 * @Description :398. 随机数索引
 * 给定一个可能含有重复元素的整数数组，要求随机输出给定的数字的索引。 您可以假设给定的数字一定存在于数组中。
 * <p>
 * 注意：
 * 数组大小可能非常大。 使用太多额外空间的解决方案将不会通过测试。
 * <p>
 * 示例:
 * <p>
 * int[] nums = new int[] {1,2,3,3,3};
 * Solution solution = new Solution(nums);
 * <p>
 * // pick(3) 应该返回索引 2,3 或者 4。每个索引的返回概率应该相等。
 * solution.pick(3);
 * <p>
 * // pick(1) 应该返回 0。因为只有nums[0]等于1。
 * solution.pick(1);
 * @Author : zph
 * @Date: 2020-10-09 12:38
 * @Version : V1.0
 */
public class Solution {
    private int[] nums;

    public Solution(int[] nums) {
        this.nums = nums;
    }

    public int pick1(int target) {
        int[] res={-1};// 因为返回一个数，可以将此题看作是 蓄水池为1 的蓄水池抽样问题
        //此时，蓄水池盛的水 就是 满足值等于target的 元素。
        boolean isFull = false;//用于判断 蓄水池是否已满
        int cnt = 0; //记录满足值等于target的元素数量
        for(int i=0;i < nums.length;i++){
            if(target == nums[i]){  //水来了。
                cnt++; //加一
                if(!isFull){
                    res[0]=i;
                    isFull = true;//如果蓄水池没有满 就直接放入，满了 将isFull设置为true.
                }else{
                    //如果蓄水池满了，那么新来的元素就要 随机替换蓄水池中的元素.
                    // 下面三行 就是蓄水池抽样的 代码框子，直接按条件套用即可.
                    Random random = new Random();
                    int j = random.nextInt(cnt);
                    if(j < 1) res[0] = i;
                }
            }

        }
        return res[0];
    }

    public int pick(int target) {
        int[] res = {-1};
        int length = nums.length;
        boolean isFull = false;
        int cut = 0;
        for (int i = 0; i < length; i++) {
            if (target == nums[i]) {
                cut++;
                if (!isFull) {
                    res[0] = i;
                    isFull = true;
                } else {
                    Random random = new Random();
                    int i1 = random.nextInt(cut);
                    if (i1 < 1) {
                        res[0] = i;
                    }
                }
            }
        }
        return res[0];

    }

}

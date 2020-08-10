package 排序算法.归并排序.q493_翻转对.f2;

import java.util.Arrays;

/**
 * @ClassName : Solution
 * @Description :493. 翻转对
 * 给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
 * <p>
 * 你需要返回给定数组中的重要翻转对的数量。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,2,3,1]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [2,4,3,5,1]
 * 输出: 3
 * 注意:
 * <p>
 * 给定数组的长度不会超过50000。
 * 输入数组中的所有数字都在32位整数的表示范围内。
 * @Author : zph
 * @Date: 2020-07-28 23:50
 * @Version : V1.0
 */
public class Solution {
    /**
     * @return int
     * @Title reversePairs
     * @Description 树状数组
     * @Author zph
     * @Date 2020/7/28 23:03
     * @Param [nums]
     */
    public int reversePairs(int[] nums) {
        int len = nums.length;
        int[] cop = Arrays.copyOf(nums, len);
        Arrays.sort(cop);
        //bit 树状数组中存储的是第1大到第n大里的数据已经遍历过的值的个数
        //比如最大的已经出现了那就给bit[1]++;
        int[] bit = new int[len + 1];
        int res = 0;
        for (int i = 0; i < len; i++) {
            //有多少个数是小于等于2 * nums[i] 的
            //防止溢出
            int size = midFind(cop, (long) 2 * nums[i]);
            //有多个数是大于2 * nums[i]的
            int bigNum = len - size;
            //查询之前bigNum数中1, bigNum 有几个已经被放进树状数组了
            res += query(bit, bigNum);
            //找到该数据的位置把数据放入数组中就是求得 nums[i] 是第几大的数，然后把该位置更新
            size = midFind(cop, nums[i] - 1);
            bigNum = len - size;
            update(bit, bigNum, 1);
        }
        return res;
    }

    /**
     * 找到数组内小于target的数字的个数
     * 第一个大于target的数字的索引就是该个数
     *
     * @param arr
     * @param target
     * @return
     */
    public int midFind(int[] arr, long target) {
        int l = 0;
        int r = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    /**
     * 更新树状数组的值
     *
     * @param bit
     * @param x
     * @param val
     */
    private void update(int[] bit, int x, int val) {
        if (x == 0) {
            return;
        }
        while (x < bit.length) {
            bit[x] += val;
            x += lowbit(x);
        }
    }

    /**
     * 查询树状数组的和
     *
     * @param bit
     * @param x
     * @return
     */
    private int query(int[] bit, int x) {
        int sum = 0;
        while (x > 0) {
            sum += bit[x];
            x -= lowbit(x);
        }
        return sum;
    }

    /**
     * 计算偏移
     *
     * @param x
     * @return
     */
    int lowbit(int x) {
        return x & (-x);
    }


    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] nums = {2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647};
        int i = solution.reversePairs(nums);
        System.out.println(i);
    }
}

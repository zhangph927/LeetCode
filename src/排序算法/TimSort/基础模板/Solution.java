package 排序算法.TimSort.基础模板;

import java.util.Arrays;

/**
 * @ClassName : Solution
 * @Description :
 * @Author : zph
 * @Date: 2020-07-25 23:06
 * @Version : V1.0
 */
public class Solution {



    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 1};
        //查询Arrays.sort源码TimSort.sort
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}

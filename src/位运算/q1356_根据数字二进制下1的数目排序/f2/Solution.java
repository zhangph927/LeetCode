package 位运算.q1356_根据数字二进制下1的数目排序.f2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName : Solution
 * @Description :1356. 根据数字二进制下 1 的数目排序
 * 给你一个整数数组 arr 。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
 * <p>
 * 如果存在多个数字二进制中 1 的数目相同，则必须将它们按照数值大小升序排列。
 * <p>
 * 请你返回排序后的数组。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [0,1,2,3,4,5,6,7,8]
 * 输出：[0,1,2,4,8,3,5,6,7]
 * 解释：[0] 是唯一一个有 0 个 1 的数。
 * [1,2,4,8] 都有 1 个 1 。
 * [3,5,6] 有 2 个 1 。
 * [7] 有 3 个 1 。
 * 按照 1 的个数排序得到的结果数组为 [0,1,2,4,8,3,5,6,7]
 * 示例 2：
 * <p>
 * 输入：arr = [1024,512,256,128,64,32,16,8,4,2,1]
 * 输出：[1,2,4,8,16,32,64,128,256,512,1024]
 * 解释：数组中所有整数二进制下都只有 1 个 1 ，所以你需要按照数值大小将它们排序。
 * 示例 3：
 * <p>
 * 输入：arr = [10000,10000]
 * 输出：[10000,10000]
 * 示例 4：
 * <p>
 * 输入：arr = [2,3,5,7,11,13,17,19]
 * 输出：[2,3,5,17,7,11,13,19]
 * 示例 5：
 * <p>
 * 输入：arr = [10,100,1000,10000]
 * 输出：[10,100,10000,1000]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 500
 * 0 <= arr[i] <= 10^4
 * @Author : zph
 * @Date: 2020-11-08 09:34
 * @Version : V1.0
 */
public class Solution {

    /**
     * @Title sortByBits
     * @Description 递推预处理
     * @Author zph
     * @Date 2020/11/8 9:50
     * @Param [arr]
     * @return int[]
     */
    public int[] sortByBits(int[] arr) {
        int[] bits = new int[10001];

        List<Integer> list = new ArrayList<>();
        for (int ar : arr) {
            list.add(ar);
        }

        for(int i=1;i<=10000;i++){
            bits[i]=bits[i>>1]+(i&1);
        }


        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (bits[o1] != bits[o2]) {
                    return bits[o1] - bits[o2];
                } else {
                    return o1 - o2;
                }
            }
        });
        int length = list.size();
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            res[i] = list.get(i);
        }
        return res;


    }


}

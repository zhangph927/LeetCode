package 堆或者队列.q347_前K个高频元素.f1;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @ClassName : Solution
 * @Description :347. 前 K 个高频元素
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 *
 * 提示：
 *
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * 你可以按任意顺序返回答案。
 * @Author : zph
 * @Date: 2020-09-07 23:38
 * @Version : V1.0
 */
public class Solution {
    
    /**
     * @Title topKFrequent
     * @Description 小顶推
     * @Author zph
     * @Date 2020/9/7 23:38
     * @Param [nums, k]
     * @return int[]
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        //定义小根堆，根据数字频率自小到大排序
        Queue<Integer> pq = new PriorityQueue<>(
                (v1,v2)->map.get(v1)-map.get(v2));

        map.forEach((num,cut)->{
            if(pq.size()<k){
                pq.offer(num);
            }else if(map.get(pq.peek())<cut){
                pq.poll();
                pq.offer(num);
            }
        });

        int [] res=new int[k];
        int i=0;
        for(int num:pq){
            res[i++]=num;
        }
        return res;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        int []nums = {1,1,1,2,2,3};
        int k = 2;
        int[] ints = solution.topKFrequent(nums, k);
        System.out.println(ints);

    }
}

package 递归.q面试题16_11跳水板;

/**
 * @ClassName : Solution
 * @Description :面试题 16.11. 跳水板
 * 你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
 *
 * 返回的长度需要从小到大排列。
 *
 * 示例：
 *
 * 输入：
 * shorter = 1
 * longer = 2
 * k = 3
 * 输出： {3,4,5,6}
 * 提示：
 *
 * 0 < shorter <= longer
 * 0 <= k <= 100000
 * @Author : zph
 * @Date: 2020-07-08 19:17
 * @Version : V1.0
 */
public class Solution {

    /**
     * @Title divingBoard
     * @Description 数学问题
     * @Author zph
     * @Date 2020/7/8 19:18
     * @Param [shorter, longer, k]
     * @return int[]
     */
    public int[] divingBoard(int shorter, int longer, int k) {
        if(k==0){
            return new int[0];
        }
        if(shorter==longer){
            return  new int []{shorter*k};
        }
        int[] res=new int[k+1];
        for(int i=0;i<=k;i++){
            res[i]=shorter*(k-i)+longer*i;
        }
        return  res;


    }
}

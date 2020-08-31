package 图.q753_破解保险箱.f1;

import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

/**
 * @ClassName : Solution
 * @Description :753. 破解保险箱
 * 有一个需要密码才能打开的保险箱。密码是 n 位数, 密码的每一位是 k 位序列 0, 1, ..., k-1 中的一个 。
 *
 * 你可以随意输入密码，保险箱会自动记住最后 n 位输入，如果匹配，则能够打开保险箱。
 *
 * 举个例子，假设密码是 "345"，你可以输入 "012345" 来打开它，只是你输入了 6 个字符.
 *
 * 请返回一个能打开保险箱的最短字符串。
 *
 *
 *
 * 示例1:
 *
 * 输入: n = 1, k = 2
 * 输出: "01"
 * 说明: "10"也可以打开保险箱。
 *
 *
 * 示例2:
 *
 * 输入: n = 2, k = 2
 * 输出: "00110"
 * 说明: "01100", "10011", "11001" 也能打开保险箱。
 *
 *
 * 提示：
 *
 * n 的范围是 [1, 4]。
 * k 的范围是 [1, 10]。
 * k^n 最大可能为 4096。
 *
 * @Author : zph
 * @Date: 2020-08-28 17:58
 * @Version : V1.0
 */
public class Solution {

    TreeSet<String> visited;
    StringBuilder res;
    public String crackSafe(int n, int k) {
        if(n == 1 && k == 1) return "0";
        visited = new TreeSet<>();
        res = new StringBuilder();
        //  从顶点 00..0 开始
        String start = String.join("", Collections.nCopies(n-1, "0"));;
        findEuler(start, k);

        res.append(start); // 回路添加最后的end顶点，end 就是 start
        return res.toString(); // return new String(res);
    }
    public void findEuler(String curv, int k){

        for(int i = 0; i < k; i ++){
            // 往顶点的 k 条出边检查，顶点加一条出边就是一种密码可能
            String nextv = curv + i;
            if(!visited.contains(nextv)){
                visited.add(nextv);
                findEuler(nextv.substring(1), k);
                res.append(i);
            }
        }
    }


    public static void main(String[] args) {
       int n = 2, k = 2;
        Solution solution = new Solution();
        String s = solution.crackSafe(n, k);
        System.out.println(s);


    }

}

package 哈希表.q771_宝石与石头;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName : Solution
 * @Description :771. 宝石与石头
 *  给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 *
 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 *
 * 示例 1:
 *
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3
 * 示例 2:
 *
 * 输入: J = "z", S = "ZZ"
 * 输出: 0
 * 注意:
 *
 * S 和 J 最多含有50个字母。
 *  J 中的字符不重复。
 *
 * @Author : zph
 * @Date: 2020-10-02 22:15
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title numJewelsInStones
     * @Description 哈希表
     * @Author zph
     * @Date 2020/10/2 22:15
     * @Param [J, S]
     * @return int
     */
    public int numJewelsInStones(String J, String S) {
        if(J==null||J.length()==0||S==null||S.length()==0){
            return 0;
        }
        char[] jChars = J.toCharArray();
        char[] sChars = S.toCharArray();
        int jLen=jChars.length;
        int sLen=sChars.length;
        Set<Character> set = new HashSet<>();
        for(int i=0;i<jLen;i++){
            set.add(jChars[i]);
        }
        int count=0;
        for(int i=0;i<sLen;i++){
            if(set.contains(sChars[i])){
                count++;
            }
        }
        return count;
    }
}

package 位运算.q187_重复的DNA序列.f1;

import java.util.*;

/**
 * @ClassName : Solution
 * @Description :187. 重复的DNA序列
 * 所有 DNA 都由一系列缩写为 A，C，G 和 T 的核苷酸组成，例如：“ACGAATTCCG”。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
 *
 * 编写一个函数来查找目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
 *
 *
 *
 * 示例：
 *
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC", "CCCCCAAAAA"]
 * @Author : zph
 * @Date: 2020-10-25 18:46
 * @Version : V1.0
 */
public class Solution {




    /**
     * @Title findRepeatedDnaSequences
     * @Description 线性时间窗口切片 + HashSet
     * @Author zph
     * @Date 2020/10/25 18:56
     * @Param [s]
     * @return java.util.List<java.lang.String>
     */
    public List<String> findRepeatedDnaSequences(String s) {
        int length=s.length();
        int L=10;
        int start=0;
        int end=length-L+1;
        Set<String> seet = new HashSet<>();
        Set<String> output = new HashSet<>();

        for(int i=0;i<end;i++){
            String sub=s.substring(i,i+L);
            if(seet.contains(sub)){
                output.add(sub);
            }
            seet.add(sub);

        }
        return new ArrayList<>(output);

    }
}

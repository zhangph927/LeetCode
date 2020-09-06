package 回溯法.分割回文串.q131_分割回文串.f1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @ClassName : Solution
 * @Description :131. 分割回文串
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 * @Author : zph
 * @Date: 2020-09-03 18:05
 * @Version : V1.0
 */
public class Solution {

    /**
     * @Title partition
     * @Description 回溯
     * @Author zph
     * @Date 2020/9/5 19:09
     * @Param [s]
     * @return java.util.List<java.util.List<java.lang.String>>
     */
    public List<List<String>> partition(String s){
        List<List<String>> res = new ArrayList<>();
        if(s==null||s.length()==0){
            return res;
        }
        Deque<String> path = new ArrayDeque<>();
        int length=s.length();


        backTracking(s,length,0,path,res);
        return res;

    }

    /**
     * @Title backTracking
     * @Description TODO
     * @Author zph
     * @Date 2020/9/5 19:11
     * @Param [s, length 长度, start 开始位置, path 路径, res 结果]
     * @return void
     */
    private void backTracking(String s,int length,int start,Deque<String> path,List<List<String>> res){

        if(start==length){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=start;i<length;i++){
            //判断
            if(!checkPalindrome(s,start,i)){
                continue;
            }

            path.addLast(s.substring(start,i+1));
            backTracking(s,length,i+1,path,res);

            path.removeLast();


        }


    }


    private boolean checkPalindrome(String s,int left,int right){
        while (left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

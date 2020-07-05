package 数组操作.q5452_判断能否形成等差数列;

import java.util.Arrays;

/**
 * @ClassName : Solution
 * @Description :
 * @Author : zph
 * @Date: 2020-07-05 19:40
 * @Version : V1.0
 */
public class Solution {

    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int length=arr.length;
        int d=arr[1]-arr[0];
        int flag=-1;
        for(int i=1;i<length;i++){
            if(arr[i]!=arr[0]+i*d){
                flag=1;
                break;
            }

        }
        return  flag==-1;

    }




}

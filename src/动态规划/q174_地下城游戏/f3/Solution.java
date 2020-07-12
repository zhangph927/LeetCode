package 动态规划.q174_地下城游戏.f3;

/**
 * @ClassName : Solution
 * @Description :174. 地下城游戏
 * 一些恶魔抓住了公主（P）并将她关在了地下城的右下角。地下城是由 M x N 个房间组成的二维网格。我们英勇的骑士（K）最初被安置在左上角的房间里，他必须穿过地下城并通过对抗恶魔来拯救公主。
 * <p>
 * 骑士的初始健康点数为一个正整数。如果他的健康点数在某一时刻降至 0 或以下，他会立即死亡。
 * <p>
 * 有些房间由恶魔守卫，因此骑士在进入这些房间时会失去健康点数（若房间里的值为负整数，则表示骑士将损失健康点数）；其他房间要么是空的（房间里的值为 0），要么包含增加骑士健康点数的魔法球（若房间里的值为正整数，则表示骑士将增加健康点数）。
 * <p>
 * 为了尽快到达公主，骑士决定每次只向右或向下移动一步。
 * <p>
 * <p>
 * <p>
 * 编写一个函数来计算确保骑士能够拯救到公主所需的最低初始健康点数。
 * <p>
 * 例如，考虑到如下布局的地下城，如果骑士遵循最佳路径 右 -> 右 -> 下 -> 下，则骑士的初始健康点数至少为 7。
 * <p>
 * -2 (K)	-3	3
 * -5	-10	1
 * 10	30	-5 (P)
 * <p>
 * <p>
 * 说明:
 * <p>
 * 骑士的健康点数没有上限。
 * <p>
 * 任何房间都可能对骑士的健康点数造成威胁，也可能增加骑士的健康点数，包括骑士进入的左上角房间以及公主被监禁的右下角房间。
 * @Author : zph
 * @Date: 2020-07-12 21:21
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title calculateMinimumHP
     * @Description dfs
     * @Author zph
     * @Date 2020/7/12 21:52
     * @Param [dungeon]
     * @return int
     */
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        memo=new int[m+1][n+1];
        return dfs(dungeon,m,n,0,0);
    }

    int[][] memo;
    private int dfs(int[][] dungeon,int m,int n,int i,int j){
        if(i==m-1&&j==n-1){
            return Math.max(1-dungeon[i][j],1);
        }
        if(memo[i][j]>0){
            return memo[i][j];
        }
        int min=0;
        if(i==m-1){
            min= Math.max(dfs(dungeon,m,n,i,j+1)-dungeon[i][j],1);
        }else if(j==n-1){
            min= Math.max(dfs(dungeon,m,n,i+1,j)-dungeon[i][j],1);
        }else {
            min= Math.max(
                    Math.min(dfs(dungeon,m,n,i+1,j),
                            dfs(dungeon,m,n,i,j+1))-dungeon[i][j],
                    1);
        }
        memo[i][j]=min;
        return memo[i][j];
    }





    public static void main(String[] args) {
        Solution solution = new Solution();


        int[][] nums={{-2,-3,3},
                {-5,-10,1},
                {10,30,-5}};
        int i = solution.calculateMinimumHP(nums);
        System.out.println(i);



    }


}

package 图.q841_钥匙和房间.f1;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : Solution
 * @Description :841. 钥匙和房间
 * 有 N 个房间，开始时你位于 0 号房间。每个房间有不同的号码：0，1，2，...，N-1，并且房间里可能有一些钥匙能使你进入下一个房间。
 *
 * 在形式上，对于每个房间 i 都有一个钥匙列表 rooms[i]，每个钥匙 rooms[i][j] 由 [0,1，...，N-1] 中的一个整数表示，其中 N = rooms.length。 钥匙 rooms[i][j] = v 可以打开编号为 v 的房间。
 *
 * 最初，除 0 号房间外的其余所有房间都被锁住。
 *
 * 你可以自由地在房间之间来回走动。
 *
 * 如果能进入每个房间返回 true，否则返回 false。
 *
 * 示例 1：
 *
 * 输入: [[1],[2],[3],[]]
 * 输出: true
 * 解释:
 * 我们从 0 号房间开始，拿到钥匙 1。
 * 之后我们去 1 号房间，拿到钥匙 2。
 * 然后我们去 2 号房间，拿到钥匙 3。
 * 最后我们去了 3 号房间。
 * 由于我们能够进入每个房间，我们返回 true。
 * 示例 2：
 *
 * 输入：[[1,3],[3,0,1],[2],[0]]
 * 输出：false
 * 解释：我们不能进入 2 号房间。
 * 提示：
 *
 * 1 <= rooms.length <= 1000
 * 0 <= rooms[i].length <= 1000
 * 所有房间中的钥匙数量总计不超过 3000。
 * @Author : zph
 * @Date: 2020-09-01 00:02
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title canVisitAllRooms
     * @Description 深度遍历
     * @Author zph
     * @Date 2020/9/1 0:02
     * @Param [rooms]
     * @return boolean
     */
   boolean[] vis;
   int num;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int length=rooms.size();
         num=0;
        vis=new boolean[length];

        dfs(rooms,0);
        return num==length;


    }

    private void dfs(List<List<Integer>> rooms,int i){
        vis[i]=true;
        num++;
        for(int it:rooms.get(i)){
            if(!vis[it]){
                dfs(rooms,it);

            }

        }

    }




    public static void main(String[] args) {

        Solution solution = new Solution();
        List<List<Integer>> rooms=new ArrayList<>();
        List<Integer> room1=new ArrayList<>();
        room1.add(1);
        room1.add(3);
        List<Integer> room2=new ArrayList<>();
        room2.add(3);
        room2.add(0);
        room2.add(1);
        List<Integer> room3=new ArrayList<>();
        room3.add(2);
        List<Integer> room4=new ArrayList<>();
        room4.add(0);
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        rooms.add(room4);

        boolean b = solution.canVisitAllRooms(rooms);

        System.out.println(b);

    }



}

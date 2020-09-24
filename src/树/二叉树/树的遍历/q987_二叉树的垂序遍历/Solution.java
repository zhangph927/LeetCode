package 树.二叉树.树的遍历.q987_二叉树的垂序遍历;

import 树.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName : Solution
 * @Description :987. 二叉树的垂序遍历
 * 给定二叉树，按垂序遍历返回其结点值。
 * <p>
 * 对位于 (X, Y) 的每个结点而言，其左右子结点分别位于 (X-1, Y-1) 和 (X+1, Y-1)。
 * <p>
 * 把一条垂线从 X = -infinity 移动到 X = +infinity ，每当该垂线与结点接触时，我们按从上到下的顺序报告结点的值（ Y 坐标递减）。
 * <p>
 * 如果两个结点位置相同，则首先报告的结点值较小。
 * <p>
 * 按 X 坐标顺序返回非空报告的列表。每个报告都有一个结点值列表。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：[3,9,20,null,null,15,7]
 * 输出：[[9],[3,15],[20],[7]]
 * 解释：
 * 在不丧失其普遍性的情况下，我们可以假设根结点位于 (0, 0)：
 * 然后，值为 9 的结点出现在 (-1, -1)；
 * 值为 3 和 15 的两个结点分别出现在 (0, 0) 和 (0, -2)；
 * 值为 20 的结点出现在 (1, -1)；
 * 值为 7 的结点出现在 (2, -2)。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：[1,2,3,4,5,6,7]
 * 输出：[[4],[2],[1,5,6],[3],[7]]
 * 解释：
 * 根据给定的方案，值为 5 和 6 的两个结点出现在同一位置。
 * 然而，在报告 "[1,5,6]" 中，结点值 5 排在前面，因为 5 小于 6。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树的结点数介于 1 和 1000 之间。
 * 每个结点值介于 0 和 1000 之间。
 * @Author : zph
 * @Date: 2020-09-22 00:32
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title verticalTraversal
     * @Description 记录坐标
     * @Author zph
     * @Date 2020/9/22 0:34
     * @Param [root]
     * @return java.util.List<java.util.List < java.lang.Integer>>
     */
    List<Location> locations;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        locations=new ArrayList<>();
        dfs(root,0,0);
        Collections.sort(locations);
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        int prev= locations.get(0).x;
        for(Location location: locations){
            if(location.x!=prev){
                prev=location.x;
                result.add(new ArrayList<>());
            }
            result.get(result.size()-1).add(location.val);

        }
        return result;


    }

    private void dfs(TreeNode root,int x,int y){
        if(root==null){
            return;
        }
        locations.add(new Location(x,y,root.val));
        dfs(root.left,x-1,y+1);
        dfs(root.right,x+1,y+1);
    }



    class Location implements Comparable<Location>{
        int x;
        int y;
        int val;
        Location(int x,int y,int val){
            this.x=x;
            this.y=y;
            this.val=val;
        }

        @Override
        public int compareTo(Location that) {
            if(this.x!=that.x){
                return Integer.compare(this.x,that.x);
            }else if(this.y!=that.y){
                return Integer.compare(this.y,that.y);
            }else {
                return Integer.compare(this.val,that.val);
            }
        }
    }
}



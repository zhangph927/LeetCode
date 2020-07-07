package 广度优先BFS.q863_二叉树中所有距离为K的结点.f1;

import 广度优先BFS.TreeNode;

import java.util.*;

/**
 * @ClassName : Solution
 * @Description :863. 二叉树中所有距离为 K 的结点
 * 给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。
 *
 * 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
 *
 *
 *
 * 示例 1：
 *
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
 * 输出：[7,4,1]
 * 解释：
 * 所求结点为与目标结点（值为 5）距离为 2 的结点，
 * 值分别为 7，4，以及 1
 *
 *
 *
 * 注意，输入的 "root" 和 "target" 实际上是树上的结点。
 * 上面的输入仅仅是对这些对象进行了序列化描述。
 *
 *
 * 提示：
 *
 * 给定的树是非空的。
 * 树上的每个结点都具有唯一的值 0 <= node.val <= 500 。
 * 目标结点 target 是树上的结点。
 * 0 <= K <= 1000.
 * @Author : zph
 * @Date: 2020-07-07 22:31
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title distanceK
     * @Description 广度优先遍历（层次遍历）方便理解 设置父节点 深度优先遍历需要设置标记位
     * @Author zph
     * @Date 2020/7/7 23:55
     * @Param [root, target, K]
     * @return java.util.List<java.lang.Integer>
     */
   private Map<TreeNode,TreeNode>  parentMap=new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        if(root==null||target==null){
            return res;
        }
        //防止重复遍历
       Set<TreeNode> nodeSet=new HashSet<>();
       Queue<TreeNode>  queue=new LinkedList<>();
       //设置父节点
        setParent(root,null);
        //作为新的根节点
        queue.offer(target);
        nodeSet.add(target);
        while (!queue.isEmpty()&&K>0){
            int size = queue.size();
            K--;
            while (size>0){
                TreeNode poll =Objects.requireNonNull( queue.poll());
                if(poll.left!=null&&!nodeSet.contains(poll.left)){
                    nodeSet.add(poll.left);
                    queue.offer(poll.left);
                }
                if(poll.right!=null&&!nodeSet.contains(poll.right)){
                    nodeSet.add(poll.right);
                    queue.offer(poll.right);
                }
                TreeNode parent = parentMap.get(poll);
                if(parent!=null&&!nodeSet.contains(parent)){
                    nodeSet.add(parent);
                    queue.offer(parent);
                }
                size--;
            }
        }
        while (!queue.isEmpty()){
          res.add(queue.poll().val);
        }
        return  res;
    }

    private void setParent(TreeNode root,TreeNode parent){
        if(root==null){
            return;
        }
        parentMap.put(root,parent);
        if(root.left!=null){
           setParent(root.left,root);
        }
        if(root.right!=null){
            setParent(root.right,root);
        }
    }
}

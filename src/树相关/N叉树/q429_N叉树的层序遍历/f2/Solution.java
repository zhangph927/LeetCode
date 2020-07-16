package 树相关.N叉树.q429_N叉树的层序遍历.f2;

import 树相关.N叉树.q429_N叉树的层序遍历.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName : Solution
 * @Description :429. N叉树的层序遍历
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 * <p>
 * 例如，给定一个 3叉树 :
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 返回其层序遍历:
 * <p>
 * [
 * [1],
 * [3,2,4],
 * [5,6]
 * ]
 * <p>
 * <p>
 * 说明:
 * <p>
 * 树的深度不会超过 1000。
 * 树的节点总数不会超过 5000。
 * @Author : zph
 * @Date: 2020-07-14 23:20
 * @Version : V1.0
 */
public class Solution {
    private List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> levelOrder(Node root) {
        if(root==null){
            return res;
        }
        traveseNode(root,0);
        return res;


    }
    private void traveseNode(Node root,int level){
        if(res.size()<=level){
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        for(Node node:root.children){
            traveseNode(node,level+1);
        }

    }
}

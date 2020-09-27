package 树.二叉搜索树.q501_二叉搜索树中的众数;

import 树.二叉搜索树.TreeNode;

import java.util.*;

/**
 * @ClassName : Solution1
 * @Description :
 * @Author : zph
 * @Date: 2020-09-25 00:17
 * @Version : V1.0
 */
public class Solution1 {

    List<Integer> resList= new ArrayList<>();
    int current;
    int count;
    int maxCount;

    public int[] findMode(TreeNode root) {
        inOrderTraversal(root);
       int[] nums= new int[resList.size()];
       int length=resList.size();
       for(int i=0;i<length;i++){
           nums[i]=resList.get(i);
       }
       return nums;

    }

    private void inOrderTraversal(TreeNode root){
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node=root;
        while (node!=null||!stack.isEmpty()){
            if (node!=null){
                stack.offerLast(node);
                node=node.left;
            }else {
                node = stack.pollLast();
                //数据处理
                int nodeValue=node.val;
                if(nodeValue==current){
                    count++;
                }else{
                    count=1;
                    current=nodeValue;
                }
                if(maxCount==count){
                    resList.add(nodeValue);
                }else if(count>maxCount){
                    resList.clear();
                    resList.add(nodeValue);
                    maxCount=count;
                }
                node=node.right;
            }


        }


    }
}

package 树.二叉搜索树.q99_恢复二叉搜索树.f1;

import 树.二叉搜索树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : Solution
 * @Description :99. 恢复二叉搜索树
 * 二叉搜索树中的两个节点被错误地交换。
 *
 * 请在不改变其结构的情况下，恢复这棵树。
 *
 * 示例 1:
 *
 * 输入: [1,3,null,null,2]
 *
 *    1
 *   /
 *  3
 *   \
 *    2
 *
 * 输出: [3,1,null,null,2]
 *
 *    3
 *   /
 *  1
 *   \
 *    2
 * 示例 2:
 *
 * 输入: [3,1,4,null,null,2]
 *
 *   3
 *  / \
 * 1   4
 *    /
 *   2
 *
 * 输出: [2,1,4,null,null,3]
 *
 *   2
 *  / \
 * 1   4
 *    /
 *   3
 * 进阶:
 *
 * 使用 O(n) 空间复杂度的解法很容易实现。
 * 你能想出一个只使用常数空间的解决方案吗？
 * @Author : zph
 * @Date: 2020-08-08 21:45
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title recoverTree
     * @Description 显式中序遍历
     * @Author zph
     * @Date 2020/8/8 21:46
     * @Param [root]
     * @return void
     */
    public void recoverTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        int[] nums = findTwoSwapped(list);
        recover(root,2,nums[0],nums[1]);

    }

    private void inorder(TreeNode root, List<Integer> list){
        if(root==null){
            return;
        }
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
    private int[] findTwoSwapped(List<Integer> list){
        int length=list.size();
        int x=-1;
        int y=-1;
        for(int i=0;i<length-1;i++){
            if(list.get(i+1)<list.get(i)){
                y=list.get(i+1);
                if(x==-1){
                    x=list.get(i);
                }else {
                    break;
                }

            }

        }
        return new int[]{x,y};
    }

    private void recover(TreeNode root,int count,int x,int y){
        if(root!=null){
            if(root.val==x||root.val==y){
                root.val=root.val==x?y:x;
                count--;
                if(count==0){
                    return;
                }

            }
            recover(root.right,count,x,y);
            recover(root.left,count,x,y);

        }

    }
}

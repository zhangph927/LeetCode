package 树.二叉树.填充每个节点的下一个右侧节点指针.q117_填充每个节点的下一个右侧节点指针II.f2;

import 树.二叉树.填充每个节点的下一个右侧节点指针.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName : Solution
 * @Description :117. 填充每个节点的下一个右侧节点指针 II
 * 给定一个二叉树
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 *
 *
 * 进阶：
 *
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 *
 *
 * 示例：
 *
 *
 *
 * 输入：root = [1,2,3,4,5,null,7]
 * 输出：[1,#,2,3,#,4,5,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
 *
 *
 * 提示：
 *
 * 树中的节点数小于 6000
 * -100 <= node.val <= 100
 *
 * @Author : zph
 * @Date: 2020-09-28 23:32
 * @Version : V1.0
 */
public class Solution {


    /**
     * @Title connect
     * @Description 使用已建立的 \rm nextnext 指针
     * @Author zph
     * @Date 2020/10/1 20:44
     * @Param [root]
     * @return 树.二叉树.填充每个节点的下一个右侧节点指针.Node
     */
    Node last=null;

    Node nextLast=null;

    public Node connect(Node root) {
        if(root==null){
            return root;
        }
        Node start=root;
        while (start!=null){
            last=null;
            nextLast=null;
            for(Node p=start;p!=null;p=p.next){
                if(p.left!=null){
                    handler(p.left);
                }
                if(p.right!=null){
                    handler(p.right);
                }
            }
            start=nextLast;

        }




        return root;
    }

    private void  handler(Node p){
        if(last!=null){
            last.next=p;
        }
        if(nextLast==null){
            nextLast=p;
        }
        last=p;
    }

}

package 树.二叉树.各种遍历汇总;


import 树.二叉树.TreeNode;

import java.util.*;

/**
 * Created by ryder on 2017/5/2.
 * <p>
 * four types(seven implements)
 * preorder(recursively,iteratively)
 * inorder(recursively,iteratively)
 * postorder(recursively,iteratively)
 * and levelorder
 * <p>
 * 输入某二叉树的前序遍历和中序遍历的结果，
 * 请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
 * 则重建二叉树并返回。
 */
public class P54_TraversalOfBinaryTree {
    public static List<Integer> preorderRecursively(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            list.add(root.val);
            list.addAll(preorderRecursively(root.left));
            list.addAll(preorderRecursively(root.right));
        }
        return list;
    }

    public static List<Integer> inorderRecursively(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            list.addAll(inorderRecursively(root.left));
            list.add(root.val);
            list.addAll(inorderRecursively(root.right));
        }
        return list;
    }

    public static List<Integer> postorderRecursively(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            list.addAll(postorderRecursively(root.left));
            list.addAll(postorderRecursively(root.right));
            list.add(root.val);
        }
        return list;
    }

    public static List<Integer> preorderIteratively(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        //the stack top is always the father node of cur
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                list.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop().right;
            }
        }
        return list;
    }

    public static List<Integer> inorderIteratively(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        //the stack top is always the father node of cur
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                list.add(stack.peek().val);
                cur = stack.pop().right;
            }
        }
        return list;
    }

    public static List<Integer> postorderIteratively(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        //prevVisited is the node visited just before,which is used to distinguish whether
        //the the right node had visited or not(like a flag)
        TreeNode prevVisited = null;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {

               /* cur = stack.peek().right;
                if (cur != null && cur != prevVisited) {
                    stack.push(cur);
                    cur = cur.left;
                } else {
                    prevVisited = stack.pop();
                    list.add(prevVisited.val);
                    cur = null;
                }*/

                cur = stack.peek();
                if (cur.right != null && cur.right != prevVisited) {
                    cur = cur.right;
                } else {
                    cur=stack.pop();
                    prevVisited = cur;
                    list.add(prevVisited.val);
                    cur = null;
                }
            }
        }
        return list;
    }

    /**
     * @return java.util.List<java.lang.Integer>
     * @Title levelorder
     * @Description: 广度遍历
     * @Param [root]
     * @author zph
     * @date 2020/2/9 21:30
     */
    public static List<Integer> levelorder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode cur = null;
        if (root == null)
            return list;
        queue.offer(root);
        while (!queue.isEmpty()) {
            cur = queue.poll();
            list.add(cur.val);
            if (cur.left != null)
                queue.offer(cur.left);
            if (cur.right != null)
                queue.offer(cur.right);
        }
        return list;
    }

    //广度优先遍历是使用队列实现的
    public void BroadFirstSearch(TreeNode nodeHead) {
        if(nodeHead==null) {
            return;
        }
        Queue<TreeNode> myQueue=new LinkedList<>();
        myQueue.add(nodeHead);
        while(!myQueue.isEmpty()) {
            TreeNode node=myQueue.poll();
            System.out.print(node.val+" ");
            if(null!=node.left) {
                myQueue.add(node.left);    //深度优先遍历，我们在这里采用每一行从左到右遍历
            }
            if(null!=node.right) {
                myQueue.add(node.right);
            }

        }
    }

    //深度优先遍历
    public void depthFirstSearch(TreeNode nodeHead) {
        if(nodeHead==null) {
            return;
        }
        Stack<TreeNode> myStack=new Stack<>();
        myStack.add(nodeHead);
        while(!myStack.isEmpty()) {
            TreeNode node=myStack.pop();    //弹出栈顶元素
            System.out.print(node.val+" ");
            if(node.right!=null) {
                myStack.push(node.right);    //深度优先遍历，先遍历左边，后遍历右边,栈先进后出
            }
            if(node.left!=null) {
                myStack.push(node.left);
            }
        }

    }



    /**
     * 深度优先遍历
     *
     * @param node
     * @param rst
     * @param list
     */
    public static void dfs(TreeNode node, List<List<Integer>> rst, List<Integer> list) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            list.add(node.val);
            /* 这里将list存入rst中时，不能直接将list存入，而是通过新建一个list来实现，
             * 因为如果直接用list的话，后面remove的时候也会将其最后一个存的节点删掉*/
            rst.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
        }
        list.add(node.val);
        dfs(node.left, rst, list);
        dfs(node.right, rst, list);
        list.remove(list.size() - 1);
    }

    /**
     * 树的深度
     * 递归法
     */
    // 树高 递归，分别求出左子树的深度、右子树的深度，两个深度的较大值+1
    public static int getHeightByRecursion(TreeNode node) {
        if (node == null) {
            return 0;
        }
        ArrayDeque<Integer> objects = new ArrayDeque<Integer>();
        int left = getHeightByRecursion(node.left);
        int right = getHeightByRecursion(node.right);
        return 1 + Math.max(left, right);
    }

    /**
     * @return int
     * @Title printMaxWidth
     * @Description: 利用层序遍历, 得到树的最大宽度
     * @Param [root]
     * @author zph
     * @date 2020/2/9 21:37
     */
    public static int printMaxWidth(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> queueTemp = new LinkedList<>();

        int maxWidth = 1;

        TreeNode tempNode = root;

        queue.offer(tempNode);

        while (!queue.isEmpty()) {

            while (!queue.isEmpty()) {

                TreeNode topNode = queue.poll();

                if (topNode == null)
                    continue;

                if (topNode.left!=null) {

                    queueTemp.offer(topNode.left);
                }

                if (topNode.right != null) {

                    queueTemp.offer(topNode.right);
                }

            }

            maxWidth = Math.max(maxWidth, queueTemp.size());
            queue = queueTemp;
            queueTemp = new LinkedList<>();
        }

        return maxWidth;
    }

    //二叉树直径
    /**
     * @Title
     * @Description: 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
     *
     * 示例 :
     * 给定二叉树
     *
     *           1
     *          / \
     *         2   3
     *        / \
     *       4   5
     * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
     *
     * 注意：两结点之间的路径长度是以它们之间边的数目表示。
     *
     * @Param
     * @return
     * @author zph
     * @date  2020/3/10 22:47
     */
    private  static  int ans;
    public static int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);

        return ans - 1;
    }
    public static int depth(TreeNode node) {
        if (node == null) return 0; // 访问到空节点了，返回0
        int L = depth(node.left); // 左儿子为根的子树的深度
        int R = depth(node.right); // 右儿子为根的子树的深度
        ans = Math.max(ans, L+R+1); // 计算d_node即L+R+1 并更新ans
        return Math.max(L, R) + 1; // 返回该节点为根的子树的深度
    }



    public static void main(String[] args) {
        //            1
        //          /   \
        //      null      2
        //              /   \
        //              3   null
        //            /   \
        //          null  null
        //pre->123  in->132   post->321  level->123
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        //root.left=new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        List<Integer> list_preorderRecursively = preorderRecursively(root);
        System.out.print("preorderRecursively: " + '\t');
        System.out.println(list_preorderRecursively.toString());

        List<Integer> list_inorderRecursively = inorderRecursively(root);
        System.out.print("inorderRecursively: " + '\t');
        System.out.println(list_inorderRecursively.toString());

        List<Integer> list_postorderRecursively = postorderRecursively(root);
        System.out.print("postorderRecursively: " + '\t');
        System.out.println(list_postorderRecursively.toString());
        System.out.println();


        List<Integer> list_preorderIteratively = preorderIteratively(root);
        System.out.print("preorderIteratively: " + '\t');
        System.out.println(list_preorderIteratively.toString());

        List<Integer> list_inorderIteratively = inorderIteratively(root);
        System.out.print("inorderIteratively: " + '\t');
        System.out.println(list_inorderIteratively.toString());

        List<Integer> list_postorderIteratively = postorderIteratively(root);
        System.out.print("postorderIteratively: " + '\t');
        System.out.println(list_postorderIteratively.toString());
        System.out.println();


        List<Integer> list_levelorder = levelorder(root);
        System.out.print("levelorder: " + '\t');
        System.out.println(list_levelorder.toString());


        List<List<Integer>> rst = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(root,rst,list);
        System.out.println("深度优先遍历"+rst.toString());

        int maxHeight = getHeightByRecursion(root);
        System.out.println("二叉树深度"+maxHeight);

        int maxWidth = printMaxWidth(root);
        System.out.println("二叉树最大宽度"+maxWidth);

        int i = diameterOfBinaryTree(root);
        System.out.println("二叉树直径："+i);


    }
}

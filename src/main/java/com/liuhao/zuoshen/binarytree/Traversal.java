package com.liuhao.zuoshen.binarytree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉遍历本身有三大类：先序、中序、后序。
 * 任意一类中，根据访问 L、R 节点顺序的不同又会细分为两小类。
 * <p>
 * 从实现上看，三类的区别，就是在递归中，第几次访问当前节点时输出数据。
 *
 * @author liuhao.x64
 */
public class Traversal {
    /**
     * PRE-ORDER Traversal (DLR)
     * NOTICE: DRL is also a particular PRE-ORDER Traversal
     */
    public static void preOrder(TreeNode<?> node) {
        if (node == null) {
            return;
        }
        node.visit();
        preOrder(node.getLeft());
        preOrder(node.getRight());
    }

    /**
     * 任何递归都可以改为非递归，即改成压栈
     * pre order 比较容易改。
     */
    public static void preOrder1(TreeNode<?> node) {
        if (node == null) {
            return;
        }
        Stack<TreeNode<?>> stack = new Stack<>();
        stack.add(node);
        while (!stack.isEmpty()) {
            TreeNode<?> curNode = stack.pop();
            // 弹出就 visit
            curNode.visit();
            // 有右就压右
            if (curNode.getRight() != null) {
                stack.add(curNode.getRight());
            }
            // 有左就压左
            if (curNode.getLeft() != null) {
                stack.add(curNode.getLeft());
            }
        }
    }

    /**
     * IN-ORDER Traversal (LDR)
     * NOTICE: RDL is also a particular IN-ORDER Traversal
     */
    public static void inOrder(TreeNode<?> node) {
        if (node == null) {
            return;
        }
        inOrder(node.getLeft());
        node.visit();
        inOrder(node.getRight());
    }

    /**
     * TODO
     */
    public static void inOrder2(TreeNode<?> node) {
    }

    /**
     * IN-ORDER Traversal (LRD)
     * NOTICE: LRD is also a particular POST-ORDER Traversal
     */
    public static void postOrder(TreeNode<?> node) {
        if (node == null) {
            return;
        }
        postOrder(node.getLeft());
        postOrder(node.getRight());
        node.visit();
    }

    /**
     * 后序遍历不太好改
     */
    public static void postOrder1(TreeNode<?> node) {
        if (node == null) {
            return;
        }
        Stack<TreeNode<?>> stack1 = new Stack<>();
        Stack<TreeNode<?>> stack2 = new Stack<>();

        stack1.add(node);
        while (!stack1.isEmpty()) {
            TreeNode<?> node1 = stack1.pop();
            stack2.push(node1);
            if (node1.getLeft() != null) {
                stack1.push(node1.getLeft());
            }
            if (node1.getRight() != null) {
                stack1.push(node1.getRight());
            }
        }
        while (!stack2.isEmpty()) {
            stack2.pop().visit();
        }
    }

    public static void postOrder2(TreeNode<?> root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode<?>> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode<?> node = stack.peek();
            if (node.getLeft() != null && root != node.getLeft() && root != node.getRight()) {
                stack.push(node.getLeft());
            } else if (node.getRight() != null && root != node.getRight()) {
                stack.push(node.getRight());
            } else {
                stack.pop().visit();
                root = node;
            }
        }
    }

    /**
     * 使用队列实现
     */
    public static void level(TreeNode<?> root) {
        Queue<TreeNode<?>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode<?> head = queue.poll();
            if (head.getLeft() != null) {
                queue.add(head.getLeft());
            }
            if (head.getRight() != null) {
                queue.add(head.getRight());
            }
            head.visit();
        }
    }

    /**
     * 0
     */
    // 3 1 4 0 5 2 6
    public static void main(String[] args) {
        /**
         *          0
         *     1         2
         *  3    4    5    6
         */
        TreeNode<?> root = TreeNode.builder()
                .data(0)
                .left(TreeNode.builder()
                        .data(1)
                        .left(TreeNode.builder().data(3).build())
                        .right(TreeNode.builder().data(4).build())
                        .build())
                .right(TreeNode.builder()
                        .data(2)
                        .left(TreeNode.builder().data(5).build())
                        .right(TreeNode.builder().data(6).build())
                        .build())
                .build();

        // 0 1 3 4 2 5 6
        preOrder(root);
        System.out.print("\n");
        preOrder1(root);
        System.out.print("\n");

        // 3 1 4 0 5 2 6
        inOrder(root);
        System.out.print("\n");
        inOrder2(root);
        System.out.print("\n");

        // 3 4 1 5 6 2 0
        postOrder(root);
        System.out.print("\n");
        postOrder1(root);
        System.out.print("\n");
        postOrder2(root);
        System.out.print("\n");

        // 0 1 2 3 4 5 6
        level(root);
        System.out.print("\n");
    }
}

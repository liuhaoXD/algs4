package com.liuhao.zuoshen.binarytree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 统计二叉树最大层宽度
 */
public class QuestionMaxWidth {
    public static void maxWidth(TreeNode<?> root) {
        Map<TreeNode<?>, Integer> nodeLevelMap = new HashMap<>();
        Map<Integer, Integer> levelWidth = new HashMap<>();

        Queue<TreeNode<?>> queue = new LinkedList<>();
        queue.add(root);
        levelWidth.put(0, 1);

        nodeLevelMap.put(root, 0);
        while (!queue.isEmpty()) {
            TreeNode<?> treeNode = queue.poll();
            treeNode.visit();
            if (treeNode.getLeft() != null) {
                queue.add(treeNode.getLeft());
                nodeLevelMap.put(treeNode.getLeft(), nodeLevelMap.get(treeNode) + 1);
                levelWidth.put(nodeLevelMap.get(treeNode) + 1, levelWidth.getOrDefault(nodeLevelMap.get(treeNode) + 1, 0) + 1);
            }
            if (treeNode.getRight() != null) {
                queue.add(treeNode.getRight());
                nodeLevelMap.put(treeNode.getRight(), nodeLevelMap.get(treeNode) + 1);
                levelWidth.put(nodeLevelMap.get(treeNode) + 1, levelWidth.getOrDefault(nodeLevelMap.get(treeNode) + 1, 0) + 1);
            }
        }
        System.out.println();
    }

    /**
     * 不使用 map 的话如何实现
     */
    public static void maxWidth2(TreeNode<?> root) {
    }

    public static void main(String[] args) {
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
        maxWidth(root);
        System.out.println();
    }
}

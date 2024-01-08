package com.liuhao.zuoshen.binarytree;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * @author liuhao.x64
 */
@Getter
@Setter
@Builder
@EqualsAndHashCode
public class TreeNode<T> {
    private T data;

    private TreeNode<T> left;

    private TreeNode<T> right;

    public void visit() {
        System.out.printf("%s ", data);
    }
}

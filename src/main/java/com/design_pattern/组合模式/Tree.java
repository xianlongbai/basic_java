package com.design_pattern.组合模式;

/**
 * Created by root on 2019/5/26.
 */
public class Tree {

    TreeNode root = null;

    public Tree(String name) {
        root = new TreeNode(name);
    }
}

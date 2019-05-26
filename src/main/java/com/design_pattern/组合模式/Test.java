package com.design_pattern.组合模式;

/**
 * Created by root on 2019/5/26.
 *
 * 使用场景：将多个对象组合在一起进行操作，常用于表示树形结构中，例如二叉树，目录树等。
 */
public class Test {

    public static void main(String[] args){
        Tree tree = new Tree("A");
        TreeNode nodeB = new TreeNode("B");
        TreeNode nodeC = new TreeNode("C");

        nodeB.add(nodeC);
        tree.root.add(nodeB);
        System.out.println("build the tree finished!");
    }
}

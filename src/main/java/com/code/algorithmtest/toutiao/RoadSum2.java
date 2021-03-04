package com.code.algorithmtest.toutiao;

/**
 * ClassName RoadSum2
 * Description TODO
 *
 * @Date 2020/10/23 13:26
 * Version 1.0
 */
public class RoadSum2 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(32);
        root.generateChildrens(4);

        System.out.println("Tree generated: ");
        root.printCurrentTree();

        int target = 73;
        boolean result = hasRoad(target, root);
        System.out.println(result);
    }

    public static boolean hasRoad(int target, TreeNode root){


        return false;
    }
}

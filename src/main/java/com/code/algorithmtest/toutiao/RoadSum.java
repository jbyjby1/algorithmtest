package com.code.algorithmtest.toutiao;

import java.util.List;
import java.util.Random;

/**
 * ClassName RoadSum
 * Description TODO
 *
 * @Date 2020/10/22 8:48
 * Version 1.0
 */
public class RoadSum {

    public static void main(String[] args){
        //TreeNode root = new TreeNode(new Random().nextInt(100) - 50);
        TreeNode root = new TreeNode(32);
        root.generateChildrens(4);

        System.out.println("Tree generated: ");
        root.printCurrentTree();

        int target = 73;
        boolean result = hasRoad(target, root);
        System.out.println(result);
    }

    public static boolean hasRoad(int target, TreeNode root){
        return hasRoadTree(root, target, 0);
    }

    public static boolean hasRoadTree(TreeNode root, int target, Integer nowRoad){
        if(root.getLeftChild() != null || root.getRightChild() != null){
            boolean lb = false, rb = false;
            if(root.getLeftChild() != null){
                lb =  hasRoadTree(root.getLeftChild(), target,nowRoad + root.getValue());
            }
            if(root.getRightChild() != null){
                rb = hasRoadTree(root.getRightChild(), target,nowRoad + root.getValue());
            }
            return lb || rb;
        }
        if(nowRoad + root.getValue() == target){
            System.out.println("find road : " + root.getValue());
            return true;
        }else{
            return false;
        }
    }



}

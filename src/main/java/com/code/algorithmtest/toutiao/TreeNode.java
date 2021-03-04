package com.code.algorithmtest.toutiao;

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * ClassName TreeNode
 * Description TODO
 *
 * @Date 2020/10/22 8:48
 * Version 1.0
 */
public class TreeNode {

    private int value;

    private TreeNode leftChild;

    private TreeNode rightChild;

    public TreeNode() {}

    public TreeNode(int value) {
        this.value = value;
    }

    public void generateChildrens(int level){
        LinkedList<TreeNode> currentLevel = new LinkedList<TreeNode>();
        currentLevel.add(this);
        for (int i = 0; i < level; i++){
            List<TreeNode> currentLevelNodes = new ArrayList<>();
            TreeNode cur = currentLevel.poll();
            while(cur != null){
                TreeNode nextLNode = new TreeNode(new Random(cur.getValue()).nextInt(100) - 50);
                cur.leftChild =nextLNode;
                TreeNode nextRNode = new TreeNode(new Random(cur.getValue() + 1).nextInt(100) - 50);
                cur.rightChild =nextRNode;
                currentLevelNodes.add(nextLNode);
                currentLevelNodes.add(nextRNode);
                cur = currentLevel.poll();
            }
            currentLevel.addAll(currentLevelNodes);
        }
    }

    public void printCurrentTree(){
        LinkedList<TreeNode> currentLevel = new LinkedList<>();
        currentLevel.add(this);
        List<TreeNode> nextLevelNodes = new ArrayList<>();
        while(true){
            while(!currentLevel.isEmpty()){
                TreeNode currentNode = currentLevel.poll();
                if(currentNode.getLeftChild() != null){
                    nextLevelNodes.add(currentNode.getLeftChild());
                }
                if(currentNode.getRightChild() != null){
                    nextLevelNodes.add(currentNode.getRightChild());
                }
                System.out.print(currentNode.getValue() + "\t");
            }
            System.out.print("\n");
            if(nextLevelNodes.isEmpty()){
                break;
            }else{
                currentLevel.addAll(nextLevelNodes);
                nextLevelNodes.clear();
            }
        }
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }
}

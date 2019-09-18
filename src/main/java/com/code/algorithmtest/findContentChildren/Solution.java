package com.code.algorithmtest.findContentChildren;

import java.util.Arrays;
import java.util.List;

/**
 * ClassName Solution
 * Description TODO
 *
 * @Date 2019/9/16 19:34
 * Version 1.0
 */
public class Solution {

    /**
     * 得到能够满足的最大人数
     * @param g 胃口数组
     * @param s 饼干数组
     * @return 能够满足的最大人数
     */
    public int findContentChildren(int[] g, int[] s) {
        //主要思想，贪心算法，因为每块饼干最多满足一个人，所以对于每个人只要找到最优解（找到最接近他胃口的饼干），不会有更优的解法，比如[2,3,5]小朋友和[2,6,3]饼干
        //饼干是否已被分配
        int[] allocated = new int[s.length];
        int result = 0;
        for (int i = 0; i < g.length; i++){
            //饼干数有限，直接遍历获取
            int currentStomach = g[i];
            int minCarryIndex = Integer.MAX_VALUE;
            for (int j = 0; j < s.length; j++ ){
                if(allocated[j] == 1){
                    //已经分配出去的饼干不再分配
                    continue;
                }
                if(s[j] >= currentStomach){
                    //饼干比胃口大
                    if(minCarryIndex == Integer.MAX_VALUE || s[j] < s[minCarryIndex]){
                        //饼干比之前的饼干小
                        //满足条件，分配饼干
                        minCarryIndex = j;
                    }
                }
            }
            if (minCarryIndex != Integer.MAX_VALUE){
                //如果饼干被分配出去了，设置标志位
                allocated[minCarryIndex] = 1;
                result++;
            }
        }
        return result;
    }
}

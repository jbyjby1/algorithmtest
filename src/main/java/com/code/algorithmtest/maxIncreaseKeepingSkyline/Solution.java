package com.code.algorithmtest.maxIncreaseKeepingSkyline;

import com.code.algorithmtest.util.PrintUtils;

/**
 * ClassName Solution
 * Description TODO
 *
 * @Date 2019/9/17 9:33
 * Version 1.0
 */
public class Solution {

    /**
     * 保持天际线
     * 思想：首先获取到当前的天际线，然后遍历每个建筑物，根据建筑物的横坐标和纵坐标获取到天际线的高度，建筑物高度不能大于原本高度和天际线高度的最小值
     * @param grid
     * @return
     */
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int result = 0;
        //获取原本天际线数据
        int[] leftSkyLine = new int[grid.length];
        int[] topSkyLine = new int[grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                int currentHeight = grid[i][j];
                if(currentHeight > leftSkyLine[i]){
                    leftSkyLine[i] = currentHeight;
                }
                if(currentHeight > topSkyLine[j]){
                    topSkyLine[j] = currentHeight;
                }
            }
        }
        //遍历判断每个建筑物的最高高度，计算增加总和
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int currentHeight = grid[i][j];
                if(currentHeight < leftSkyLine[i] && currentHeight < topSkyLine[j]){
                    int maxHeight = leftSkyLine[i] > topSkyLine[j] ? topSkyLine[j] : leftSkyLine[i];
                    result += maxHeight - currentHeight;
                }
            }
        }

        return result;
    }

}

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

      int result =0;
      int[] linMax= new  int[grid.length];
      int[] colunMax=new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j <grid[i].length ; j++) {
                if(grid[i][j]>colunMax[i]){
                    colunMax[i]=grid[i][j];
                }
            }
//            if(grid[i][0] ){
//
//            }
        }


        return result;
    }

}

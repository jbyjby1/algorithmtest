package com.code.algorithmtest.islandPerimeter;

/**
 * ClassName Solution
 * Description TODO
 *
 * @Date 2019/9/16 17:32
 * Version 1.0
 */
public class Solution {

    public int islandPerimeter(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++){
                int currentPerimeter = 0;
                if(grid[i][j] == 0){
                    //如果当前是水，则直接忽略
                    continue;
                }
                //看左边
                if(i == 0){
                    //左边到边，加边
                    currentPerimeter++;
                }else{
                    if(grid[i - 1][j] == 1){
                        //左边是岛，不用加边
                    }else{
                        //左边是水，加边
                        currentPerimeter++;
                    }
                }
                //看上边
                if(j == 0){
                    //上边到边，加边
                    currentPerimeter++;
                }else{
                    if(grid[i][j - 1] == 1){
                        //上边是岛，不用加边
                    }else{
                        //上边是水，加边
                        currentPerimeter++;
                    }
                }
                //看右边
                if(i == grid.length - 1){
                    //右边到边，加边
                    currentPerimeter++;
                }else{
                    if(grid[i + 1][j] == 1){
                        //右边是岛，不用加边
                    }else{
                        //右边是水，加边
                        currentPerimeter++;
                    }
                }
                //看下边
                if(j == grid[i].length - 1){
                    //下边到边，加边
                    currentPerimeter++;
                }else{
                    if(grid[i][j + 1] == 1){
                        //下边是岛，不用加边
                    }else{
                        //下边是水，加边
                        currentPerimeter++;
                    }
                }
                result+=currentPerimeter;
            }
        }
        return result;
    }
}

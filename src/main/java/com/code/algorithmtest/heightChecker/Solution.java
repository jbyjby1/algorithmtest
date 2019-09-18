package com.code.algorithmtest.heightChecker;

/**
 * ClassName Solution
 * Description TODO
 *
 * @Date 2019/9/16 17:03
 * Version 1.0
 */
public class Solution {

    public int heightChecker(int[] heights) {
        int result = 0;
        int[] heightNum = new int[101];
        for(int i = 0; i < heights.length; i++){
            heightNum[heights[i]]++;
        }
        int currentStudentNum = 0;
        for (int i = 0; i < heightNum.length; i++){
            if(heightNum[i] == 0){
                continue;
            }else{
                for (int j = 0; j < heightNum[i]; j++){
                    if(heights[currentStudentNum] != i){
                        result++;
                    }
                    currentStudentNum++;
                }
            }
        }
        return result;
    }
}

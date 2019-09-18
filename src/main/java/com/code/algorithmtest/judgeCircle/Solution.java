package com.code.algorithmtest.judgeCircle;

/**
 * ClassName Solution
 * Description TODO
 *
 * @Date 2019/9/16 16:36
 * Version 1.0
 */
public class Solution {

    public boolean judgeCircle(String moves) {
        char[] moveSteps = moves.toCharArray();
        //水平偏移量，负数代表向左，正数代表向右
        int horizontalOffset = 0;
        //垂直偏移量，负数代表向下，正数代表向上
        int verticalOffset = 0;
        for (int i = 0; i <  moveSteps.length; i++){
            switch (moveSteps[i]){
                case 'U': verticalOffset++;break;
                case 'D': verticalOffset--;break;
                case 'L': horizontalOffset--;break;
                case 'R': horizontalOffset++;break;
            }
        }
        return horizontalOffset == 0 && verticalOffset == 0;
    }
}

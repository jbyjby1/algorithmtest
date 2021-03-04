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
        //统计U D L R 的个数 ；
        //U 和 D相等 且L 和R 相等 返回true
        int uCount = 0;
        int dCount = 0;
        int lCount = 0;
        int rCount = 0;
        moves = moves.toLowerCase();
        for (int i = 0; i < moves.length(); i++) {
            String s = String.valueOf(moves.charAt(i));
            if ("u".equals(s)) {
                uCount++;
            } else if ("d".equals(s)) {
                dCount++;
            } else if ("l".equals(s)) {
                lCount++;
            } else if ("r".equals(s)) {
                rCount++;
            }
        }
        if (uCount == dCount && lCount == rCount) {
            return true;
        }
        return false;
    }
}

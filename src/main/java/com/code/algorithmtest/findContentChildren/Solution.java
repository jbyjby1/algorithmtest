package com.code.algorithmtest.findContentChildren;

import com.code.algorithmtest.util.PrintUtils;

import java.util.Arrays;
import java.util.Collections;
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
        Arrays.sort(g);
        PrintUtils.printArray(g);
        Arrays.sort(s);
        PrintUtils.printArray(s);

        // j是满足度
        int result = 0;
        for (int j = g.length; j >= 0; j--) {
            boolean flag = false;
            for (int i = s.length; i >= 0; i--) {
                if (g[j] <= s[i] && !flag) {
                    flag = true;
                    s[i] = -1;
                    g[j] = 0;
                    result++;
                }
            }
        }


        return result;
    }

}

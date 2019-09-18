package com.code.algorithmtest.maxIncreaseKeepingSkyline;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void maxIncreaseKeepingSkyline() {
        com.code.algorithmtest.maxIncreaseKeepingSkyline.Solution solution = new com.code.algorithmtest.maxIncreaseKeepingSkyline.Solution();
        //solution.addBinary("11", "1");
        System.out.println(solution.maxIncreaseKeepingSkyline(new int[][]{{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}}));
    }
}
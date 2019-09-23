package com.code.algorithmtest.maxProfit;

import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void maxProfit() {
        Solution solution = new Solution();
        //int k = solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        int k = solution.maxProfit2(new int[]{10, 2, 9, 1, 2, 1, 3, 1});
        System.out.println(k);
    }
}
package com.code.algorithmtest.maxProfit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void maxProfit() {
        com.code.algorithmtest.maxProfit.Solution solution = new com.code.algorithmtest.maxProfit.Solution();
        solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
    }
}
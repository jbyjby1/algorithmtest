package com.code.algorithmtest.heightChecker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void heightChecker() {

        com.code.algorithmtest.heightChecker.Solution solution = new com.code.algorithmtest.heightChecker.Solution();
        //solution.addBinary("11", "1");
        System.out.println(solution.heightChecker(new int[]{1, 4, 2, 3}));
    }
}
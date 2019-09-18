package com.code.algorithmtest.findContentChildren;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void findContentChildren() {

        com.code.algorithmtest.findContentChildren.Solution solution = new com.code.algorithmtest.findContentChildren.Solution();
        //solution.addBinary("11", "1");
        System.out.println(solution.findContentChildren(new int[]{1,2,3}, new int[]{1,1}));

    }
}
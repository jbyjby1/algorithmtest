package com.code.algorithmtest.islandPerimeter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void islandPerimeter() {
        com.code.algorithmtest.islandPerimeter.Solution solution = new com.code.algorithmtest.islandPerimeter.Solution();
        //solution.addBinary("11", "1");
        System.out.println(solution.islandPerimeter(new int[][]{{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}}));
    }
}
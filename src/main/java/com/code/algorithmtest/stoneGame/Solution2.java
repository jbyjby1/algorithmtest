package com.code.algorithmtest.stoneGame;

import com.code.algorithmtest.util.PrintUtils;

import java.util.Arrays;

/**
 * ClassName Solution2
 * Description TODO
 *
 * @Date 2019/9/17 11:31
 * Version 1.0
 */
public class Solution2 {

    //winStone[i][j]第i个数到第j个数的序列可以获取到的最佳数
    int[][] winStones;
    /**
     * 石头游戏，思想： F(N) = F(N-L)L 和F(N-R)R 中的最优解
     * 从两个数开始，逐渐向外进行扩展求值。
     * @param piles 输入值
     * @return 先拿石子的人是否能赢
     */
    public boolean stoneGame(int[] piles) {
        if(piles.length == 2){
            return true;
        }
        winStones = new int[piles.length][piles.length];
        int winNum = getWinStones(piles, 0, piles.length - 1);
        return winNum > 0;
    }

    /**
     * 获取当前先拿的人所能得到的赢取数
     * @param piles
     * @param startIndex
     * @param endIndex
     * @return
     */
    public int getWinStones(int[] piles, int startIndex, int endIndex){
        if(winStones[startIndex][endIndex] != 0){
            //缓存中存在直接返回
            return winStones[startIndex][endIndex];
        }
        if(piles.length == 2 || endIndex - startIndex == 1){
            //长度为2直接缓存并返回
            int stones = piles[startIndex] > piles[endIndex] ? piles[startIndex] - piles[endIndex] : piles[endIndex] - piles[startIndex];
            winStones[startIndex][endIndex] = stones;
            return stones;
        }
        //拆分成子查询
        int leftWin = getWinStones(piles, startIndex + 1, endIndex);
        int rightWin = getWinStones(piles, startIndex, endIndex - 1);
        int leftRealWin = piles[startIndex] - leftWin;
        int rightRealWin = piles[endIndex] - rightWin;
        int currentWinResult = leftRealWin > rightRealWin ? leftRealWin : rightRealWin;
        winStones[startIndex][endIndex] = currentWinResult;
        return currentWinResult;
    }
}

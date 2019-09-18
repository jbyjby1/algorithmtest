package com.code.algorithmtest.stoneGame;

import com.code.algorithmtest.util.PrintUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName Solution
 * Description TODO
 *
 * @Date 2019/9/17 10:33
 * Version 1.0
 */
public class Solution {

    //key： 数组toString的值， value： 能够达成的赢取数量，正数为先拿赢，负数为后拿赢
    Map<String, Integer> winStones = new HashMap<>();

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
        int winNum = stoneGameWin(piles);
        System.out.println(winNum);
        return winNum > 0;
    }

    /**
     * 判断在这种情况下能够赢得几颗石子，使用map返回
     * @return
     */
    public int stoneGameWin(int[] piles){
        //判断如果总共就两颗则直接返回赢得的石子数
        if(piles.length == 2){
            int stones = piles[0] > piles[1] ? piles[0] - piles[1] : piles[1] - piles[0];
            winStones.put(Arrays.toString(piles), stones);
            return stones;
        }
        //如果缓存中存在直接返回缓存中的赢得数量
        String currentKey = Arrays.toString(piles);
        if(winStones.containsKey(currentKey)){
            return winStones.get(currentKey);
        }
        //如果大于两颗，且缓存中没有，使用此方法继续调用下一层，左边刨除去一个，加上左边，右边刨除去一个加上右边，取最优值
        int[] leftPiles = Arrays.copyOfRange(piles, 1, piles.length);
        int[] rightPiles = Arrays.copyOfRange(piles, 0, piles.length - 1);
        int leftWin = stoneGameWin(leftPiles);
        int rightWin = stoneGameWin(rightPiles);
        int leftRealWin = piles[0] - leftWin;
        int rightRealWin = piles[piles.length - 1] - rightWin;
        int currentWinResult = leftRealWin > rightRealWin ? leftRealWin : rightRealWin;
        winStones.put(Arrays.toString(piles), currentWinResult);
        return currentWinResult;
    }

}

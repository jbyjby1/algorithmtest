package com.code.algorithmtest.maxProfit;

import java.util.Arrays;

/**
 * 只能买卖一种股票的情况
 * Description TODO
 *
 * @Date 2019/9/16 13:19
 * Version 1.0
 */
public class Solution2 {

    public int maxProfit(int[] prices) {
        //核心思想：对于只能买卖一种股票的情况，首先找到所有股票中的最高和最低点
        //如果最高点在最低点右边，则已定
        //如果最高点在最低点左边，则以此为界，不可能在最高点左边卖出，也不可能在最低点右边买入
        //最高点左边找到最低值作为买入值，到最高点作为比较选项1，最低点右边找到最高值作为卖出值，与最低点作为比较选项2，再加上最高点和最低点中间的值，递归
        //递归直接返回条件
        if(prices.length < 2){
            return 0;
        }else if(prices.length == 2){
            if(prices[0] < prices[1]){
                return prices[1] - prices[0];
            }else{
                return 0;
            }
        }

        //第一步，找到最高和最低点
        int max = prices[0];
        int min = prices[0];
        int maxIndex = 0;
        int minIndex = 0;
        for(int i = 0; i <  prices.length; i++){
            if(prices[i] > max){
                max = prices[i];
                maxIndex = i;
            }
            if(prices[i] <  min){
                min = prices[i];
                minIndex = i;
            }
        }
        if(max == min || maxIndex == minIndex){
            //最大最小值相等，则返回0
            return 0;
        }else if (minIndex < maxIndex){
            //最小值在最大值左边，定下来
            return max - min;
        }

        int leftMin = max;
        //找到左边最低值
        for (int i = 0; i <= maxIndex; i++){
            if(prices[i] < leftMin){
                leftMin = prices[i];
            }
        }
        //左边最大挣钱数
        int leftProfit = max - leftMin;

        //找到右边最高值
        int rightMax = min;
        for (int i = prices.length - 1; i >= minIndex; i--){
            if(prices[i] > rightMax){
                rightMax = prices[i];
            }
        }
        //右边最大挣钱数
        int rightProfit = rightMax - min;

        //得到筛选过的新数组
        //新数组长度
        int[] wrappedPrices = new int[minIndex - maxIndex + 1];
        wrappedPrices[0] = max;
        wrappedPrices[wrappedPrices.length - 1] = min;
        for (int i = 1; i <= wrappedPrices.length - 2; i++){
            wrappedPrices[i] = prices[i + maxIndex];
        }
        // 判断如果左边或右边不挣钱则去掉
        int leftCutIndex, rightCutIndex;
        if(leftProfit == 0){
            leftCutIndex = 1;
        }else{
            leftCutIndex = 0;
        }
        if(rightProfit == 0){
            rightCutIndex = wrappedPrices.length - 1;
        }else{
            rightCutIndex = wrappedPrices.length;
        }
        // 获取递归结果
        int middleProfit = maxProfit(Arrays.copyOfRange(wrappedPrices,leftCutIndex, rightCutIndex));
        //比较最大值返回
        int realMax = max(middleProfit, max(leftProfit, rightProfit));
        return realMax;
    }

    public int max(int a , int b){
        return a > b ? a : b;
    }

    public int maxProfit2(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int minPrice = prices[0];
        int maxProfit = 0;
        for(int i = 1; i < prices.length; i++){
            maxProfit = maxProfit > (prices[i] - minPrice) ? maxProfit : (prices[i] - minPrice);
            minPrice = minPrice < prices[i] ? minPrice : prices[i];
        }
        return maxProfit;
    }
}

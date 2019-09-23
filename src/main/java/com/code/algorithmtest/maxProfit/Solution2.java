package com.code.algorithmtest.maxProfit;

public class Solution2 {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int profitStart = 0;
        boolean findRight = false; //是否已经找到合适的买入点，正在寻找卖出
        for (int currentIndex = 0; currentIndex < prices.length - 1; currentIndex++){
            int thisPrice = prices[currentIndex];
            int nextPrice = prices[currentIndex + 1];
            if(nextPrice > thisPrice){
                //股票上涨
                //此时如果之前没有买入，则应该买入，如果已经买入了则静观其变
                if(!findRight) {
                    profitStart = currentIndex;
                    findRight = true;
                }
                continue;
            }else if(nextPrice < thisPrice){
                //股票下跌
                //此时如果之前没有买入，则应该静观其变，如果已经买入了则应该卖出
                if(findRight){
                    maxProfit += prices[currentIndex] - prices[profitStart];
                    findRight = false;
                }
                continue;
            }else if(nextPrice == thisPrice){
                //不涨不跌，直接静观其变
                continue;
            }
        }
        if(findRight){
            //如果最后这个没卖出去，则卖一下
            maxProfit += prices[prices.length - 1] -  prices[profitStart];
            findRight = false;
        }
        return maxProfit;
    }
}

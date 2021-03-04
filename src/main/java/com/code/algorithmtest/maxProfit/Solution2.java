package com.code.algorithmtest.maxProfit;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    public int maxProfit(int[] prices) {

        //美乳是0，卖出是1，根据pricess的天数是一个0,1的数组
        int length = prices.length;
        List result = new ArrayList();
        for(int i=0;i<Math.pow(2,length)-1;i++){
            //转成二进制
            String s = Integer.toBinaryString(i);
            String[] a = s.split("");
//            for(j)

        }



        return 0;
    }


    public static void main(String[] args){

    }
}

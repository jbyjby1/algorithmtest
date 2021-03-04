package com.code.algorithmtest.twoSum;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName Solution
 * Description TODO
 *
 * @Date 2019/9/11 16:51
 * Version 1.0
 */
class Solution {
    /**
     * please ignore this method
     * @param nums 所有的数字
     * @param target 目标数字
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        return this.allocateServerMem(nums, target);
    }


    /**
     * 需要注意：
     * 1.变量命名尽量使用业务名称，除了循环中的i这种以外
     * 2.尽量不要使用java8相关的语法、List、Map这种重的对象，因为效率低，在执行时间和内存消耗上会吃亏，当然，像这道例题明显使用map能提高效率
     * 3.不要求一定抛异常
     * 4.可以百度查的，但是不能直接查题目
     * 5.PrintUtils中有数组打印的工具方法，可以帮助调试，你也可以写自己的。
     * @param allServerMems
     * @param userChoose
     * @return
     */
    public int[] allocateServerMem(int[] allServerMems, int userChoose){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < allServerMems.length; i++) {
            int complement = userChoose - allServerMems[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(allServerMems[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

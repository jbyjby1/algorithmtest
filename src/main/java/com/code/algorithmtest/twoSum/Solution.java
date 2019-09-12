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

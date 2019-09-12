package com.code.algorithmtest.removeElement;

/**
 * ClassName Solution
 * Description TODO
 *
 * @Date 2019/9/12 17:09
 * Version 1.0
 */
public class Solution {

    public int removeElement(int[] nums, int val) {
        int i = 0,j = nums.length;
        if(nums.length == 0){
            return 0;
        }
        int maxLength = nums.length;
        while(true){
            int currentLeft = i;
            int currentRight = j - 1;
            if(currentLeft == currentRight){
                if(nums[currentLeft] == val){
                    maxLength--;
                    break;
                }else{
                    break;
                }
            }else if(currentLeft > currentRight){
                break;
            }
            if(nums[currentLeft] != val){
                //如果左index与目标不同，继续看下一个
                i++;
                continue;
            }else {
                //如果左index与目标相同，则看右index
                if(nums[currentRight] == val){
                    //如果右index与目标相同，则看前面一个，最大长度减1
                    j--;
                    maxLength--;
                    continue;
                }else{
                    //如果右index与目标不同，则交换数据，最大长度减1
                    int temp = nums[currentLeft];
                    nums[currentLeft] = nums[currentRight];
                    nums[currentRight] = temp;
                    i++;
                    j--;
                    maxLength--;
                    continue;
                }
            }
        }
        return maxLength;
    }

}

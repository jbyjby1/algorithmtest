package com.code.algorithmtest.plusOne;

import java.util.Arrays;

/**
 * ClassName Solution
 * Description TODO
 *
 * @Date 2019/9/11 20:05
 * Version 1.0
 */
public class Solution {

    public int[] plusOne(int[] digits) {
        int carry = 0;
        int[] result = new int[digits.length + 1];
        for (int i = digits.length - 1; i >=0; i--){
            int currentNum = digits[i];
            if(i == digits.length - 1){
                if(currentNum + carry + 1 < 10){
                    result[i + 1] = currentNum + carry + 1;
                    carry = 0;
                }else{
                    result[i + 1] = currentNum + carry + 1 - 10;
                    carry = 1;
                }
            }else{
                if(currentNum + carry < 10){
                    result[i + 1] = currentNum + carry;
                    carry = 0;
                }else{
                    result[i + 1] = currentNum + carry - 10;
                    carry = 1;
                }
            }
        }
        if(carry == 1){
            result[0] = 1;
        }else{
            result = Arrays.copyOfRange(result, 1, result.length);
        }
        return result;
    }

}

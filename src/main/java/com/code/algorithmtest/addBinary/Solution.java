package com.code.algorithmtest.addBinary;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * ClassName Solution
 * Description TODO
 *
 * @Date 2019/9/11 17:44
 * Version 1.0
 */
public class Solution {
    public String addBinary(String a, String b) {
        return sumIpAddr(a, b);
    }

    public static String sumIpAddr(String ipAddressA, String ipAddressB){
        int aLength = ipAddressA.length();
        int bLength = ipAddressB.length();
        int maxLength = aLength > bLength ? aLength : bLength;
        char[] ipAArray = ipAddressA.toCharArray();
        char[] ipBArray = ipAddressB.toCharArray();
        char[] result = new char[maxLength + 1];
        for (int i = 0; i < result.length; i++){
            result[i] = '0';
        }
        int carry = 0;
        for (int i = 0 ; i < maxLength  ;i++){
            char currentResult = '0';
            char aCurrentChar = '0';
            if (i < ipAArray.length){
                aCurrentChar = ipAArray[ipAArray.length - 1 - i];
            }
            char bCurrentChar = '0';
            if (i < ipBArray.length){
                bCurrentChar = ipBArray[ipBArray.length - 1 - i];
            }
            int realA = aCurrentChar - 48;
            int realB = bCurrentChar - 48;
            int currentInt = realA + realB + carry;
            if(currentInt == 0){
                currentResult = '0';
                carry = 0;
            }else if (currentInt == 1){
                currentResult = '1';
                carry = 0;
            }else if (currentInt == 2){
                currentResult = '0';
                carry = 1;
            }else if(currentInt == 3){
                currentResult = '1';
                carry = 1;
            }
            result[result.length - 1 - i] = currentResult;
        }
        //最后一位如果有借位需要给最后一位变为1，否则需要少一位
        if(carry == 1){
            result[0] = '1';
        }else{
            result = Arrays.copyOfRange(result, 1, result.length);
        }
        return String.valueOf(result);
    }

}

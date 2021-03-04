package com.code.algorithmtest.util;

import java.util.Map;

/**
 * ClassName PrintUtils
 * Description TODO
 *
 * @Date 2019/9/17 9:50
 * Version 1.0
 */
public class PrintUtils {

    public static void printArray(int[] array){
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
        System.out.print("\n");
    }

    public static void printArray(int[][] array){
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[0].length;j++) {
                System.out.print(array[i][j]+" ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    public static void printMap(Map<String, Integer> map){
        for (Map.Entry<String, Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + "  " + entry.getValue());
        }
    }

    public static void printIntegerMap(Map<Integer, Integer> map){
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + "  " + entry.getValue());
        }
    }


}

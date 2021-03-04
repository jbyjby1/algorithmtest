package com.code.algorithmtest.FreedomTrail;

import com.code.algorithmtest.util.PrintUtils;

import java.util.*;

/**
 * ClassName Solution
 * Description TODO
 *
 * @Date 2020/11/11 17:22
 * Version 1.0
 */
public class Solution {

    //得到一个列表
    //当前位置 -> 到X字符的距离列表、每个距离对应的结束位置
    /**
     * f(x) = min(f(x - 1a) + d(1a-x), f(x - 1b) + d(1b-x), .....)
     * @param ring
     * @param key
     * @return
     */
    public int findRotateSteps(String ring, String key) {
        int[][] levelWithLocationMinDistance = new int[key.length()][ring.length()];
        for (int i = 0 ; i< levelWithLocationMinDistance.length; i++){
            for (int j = 0; j < levelWithLocationMinDistance[i].length; j++){
                levelWithLocationMinDistance[i][j] = Integer.MAX_VALUE;
            }
        }

        printArray(levelWithLocationMinDistance);

        char[] keyArray = key.toCharArray();

        Map<Integer, Integer> lastLocationsAndSteps = new HashMap<>();
        lastLocationsAndSteps.put(0, 0);
        for (int level = 0; level < keyArray.length; level++){
            System.out.println("level " + level + " start");

            char targetKey = keyArray[level];
            Map<Integer, Integer> currentLocations = new HashMap<>(lastLocationsAndSteps);
            lastLocationsAndSteps.clear();
            for (Map.Entry<Integer, Integer> locationEntry : currentLocations.entrySet()){
                int location = locationEntry.getKey();
                int lastSteps = locationEntry.getValue();
                Map<Integer, Integer> stopLocationToSteps = operateTo(ring, location, targetKey);
                for (Map.Entry<Integer, Integer> entry : stopLocationToSteps.entrySet()){
                    Integer stopLocation = entry.getKey();
                    Integer steps = entry.getValue();
                    Integer reallySteps = steps + lastSteps;
                    if(reallySteps < levelWithLocationMinDistance[level][stopLocation]){
                        levelWithLocationMinDistance[level][stopLocation] = reallySteps;
                        lastLocationsAndSteps.put(stopLocation, reallySteps);
                    }
                }
            }
            System.out.println("level " + level + " end");
            printArray(levelWithLocationMinDistance);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < levelWithLocationMinDistance[levelWithLocationMinDistance.length - 1].length; i++){
            int cur = levelWithLocationMinDistance[levelWithLocationMinDistance.length - 1][i];
            if(cur < min){
                min = cur;
            }
        }
        return min;
    }

    Map<Integer, Map<Character, Map<Integer, Integer>>> cache = new HashMap<>();

    /**
     * 根据环，以及当前所在位置的Index，找到前往某个key所需的步数，以及结束后的位置
     * @param ring
     * @param currentLocation
     * @param targetKey
     * @return Map<结束后位置，所需步数>
     */
    public Map<Integer, Integer> operateTo(String ring, Integer currentLocation, char targetKey){
        System.out.println("ring: " + ring + " currentLocation: " + currentLocation + " target key: " + targetKey);
        if(cache.containsKey(currentLocation)){
            if(cache.get(currentLocation).containsKey(targetKey)){
                PrintUtils.printIntegerMap(cache.get(currentLocation).get(targetKey));
                return cache.get(currentLocation).get(targetKey);
            }
        }

        int allLength = ring.length();
        int maxDistance = allLength / 2;
        Map<Integer, Integer> stopLocationToSteps = new HashMap<>();
        for (int i = 0; i < allLength; i++){
            char recordKey = ring.charAt(i);
            if(targetKey != recordKey){
                continue;
            }
            int distance = Math.abs(i - currentLocation);
            int recordDistance;
            if(distance <= maxDistance){
                recordDistance = distance;
            }else{
                recordDistance = allLength - distance;
            }
            stopLocationToSteps.put(i, recordDistance + 1);
        }
        Map<Character, Map<Integer, Integer>> targetKeyToResult;
        if(!cache.containsKey(currentLocation)){
            targetKeyToResult = new HashMap<>();
        }else{
            targetKeyToResult = cache.get(currentLocation);
        }
        targetKeyToResult.put(targetKey, stopLocationToSteps);
        PrintUtils.printIntegerMap(stopLocationToSteps);
        return stopLocationToSteps;
    }

    public void printArray(int[][] array){
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                System.out.print(array[i][j] + "\t");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.findRotateSteps("abcdefghid", "ade");
        System.out.println("result: " + result);
    }
}

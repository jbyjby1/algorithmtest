package com.code.algorithmtest.FreedomTrail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName Solution2
 * Description TODO
 *
 * @Date 2020/11/18 11:18
 * Version 1.0
 */
public class Solution2 {

    /**
     * 方法一：动态规划
     * 定义 \textit{dp}[i][j]dp[i][j] 表示从前往后拼写出 \textit{key}key 的第 ii 个字符， \textit{ring}ring 的第 jj 个字符与 12:0012:00 方向对齐的最少步数（下标均从 00 开始）。
     *
     * 显然，只有当字符串 \textit{ring}ring 的第 jj 个字符需要和 \textit{key}key 的第 ii 个字符相同时才能拼写出 \textit{key}key 的第 ii 个字符，因此对于 \textit{key}key 的第 ii 个字符，需要考虑计算的 \textit{ring}ring 的第 jj 个字符只有 \textit{key}[i]key[i] 在 \textit{ring}ring 中出现的下标集合。我们对每个字符维护一个位置数组 \textit{pos}[i]pos[i]，表示字符 ii 在 \textit{ring}ring 中出现的位置集合，用来加速计算转移的过程。
     *
     * 对于状态 \textit{dp}[i][j]dp[i][j]，需要枚举上一次与 12:0012:00 方向对齐的位置 kk，因此可以列出如下的转移方程：
     *
     * \textit{dp}[i][j]=\min_{k \in pos[key[i-1]]}\{dp[i-1][k]+\min\{\text{abs}(j-k),n-\text{abs}(j-k)\}+1\}
     * dp[i][j]=
     * k∈pos[key[i−1]]
     * min
     * ​
     *  {dp[i−1][k]+min{abs(j−k),n−abs(j−k)}+1}
     *
     * 其中 \min\{\text{abs}(j-k),n-\text{abs}(j-k)\}+1min{abs(j−k),n−abs(j−k)}+1 表示在当前第 kk 个字符与 12:0012:00 方向对齐时第 jj 个字符旋转到 12:0012:00 方向并按下拼写的最少步数。
     *
     * 最后答案即为 \min_{i=0}^{n-1}\{\textit{dp}[m-1][i]\}min
     * i=0
     * n−1
     * ​
     *  {dp[m−1][i]}。
     *
     * 这样的做法需要开辟 O(mn)O(mn) 的空间来存放 \textit{dp}dp 值。考虑到每次转移状态 \textit{dp}[i][]dp[i][] 只会从 \textit{dp}[i-1][]dp[i−1][] 转移过来，因此我们可以利用滚动数组优化第一维的空间复杂度，有能力的读者可以尝试实现。下面只给出最朴素的 O(mn)O(mn) 空间复杂度的实现。
     *
     *复杂度分析
     *
     * 时间复杂度：O(mn^2)O(mn
     * 2
     *  )，其中 mm 为字符串 \textit{key}key 的长度，nn 为字符串 \textit{ring}ring 的长度。一共有 O(mn)O(mn) 个状态要计算，每次转移的时间复杂度为 O(n)O(n)，因此时间复杂度为 O(mn^2)O(mn
     * 2
     *  )。
     * 由于维护了位置数组 \textit{pos}pos 加速了状态的计算与转移，因此 O(mn^2)O(mn
     * 2
     *  ) 是一个较松的上界，很多情况下的时间复杂度都会低于 O(mn^2)O(mn
     * 2
     *  )。
     *
     * 空间复杂度：O(mn)O(mn)。需要使用 O(mn)O(mn) 的空间来存放 \textit{dp}dp 数组，以及使用 O(n)O(n) 的空间来存放 \textit{pos}pos 数组，因此总空间复杂度为 O(mn)O(mn)。如果利用滚动数组，则可以将 \textit{dp}dp 数组的空间复杂度降低到 O(n)O(n)，总空间复杂度降低到 O(n)O(n)。
     *
     * @param ring
     * @param key
     * @return
     */

    public int findRotateSteps(String ring, String key) {
        int n = ring.length(), m = key.length();
        List<Integer>[] pos = new List[26];
        for (int i = 0; i < 26; ++i) {
            pos[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < n; ++i) {
            pos[ring.charAt(i) - 'a'].add(i);
        }
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; ++i) {
            Arrays.fill(dp[i], 0x3f3f3f);
        }
        for (int i : pos[key.charAt(0) - 'a']) {
            dp[0][i] = Math.min(i, n - i) + 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j : pos[key.charAt(i) - 'a']) {
                for (int k : pos[key.charAt(i - 1) - 'a']) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + Math.min(Math.abs(j - k), n - Math.abs(j - k)) + 1);
                }
            }
        }
        return Arrays.stream(dp[m - 1]).min().getAsInt();
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int result = solution2.findRotateSteps("abcdefghid", "ade");
        System.out.println(result);
    }

}

package karvein.algorithem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * @Author: karvein
 * @Date: 2022/9/5
 * @Description:
 */

public class PalindromicSubstring {
    public static void main(String[] args) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(inputStreamReader);
        try {
            System.out.printf("Input here:\n");
            String s = br.readLine();
            System.out.println(palindromicSub1(s));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            br.close();
            inputStreamReader.close();
        }

    }

    /**
     * 动态规划，DP，Dynamic programming
     * 迭代子问题的最优解求法
     * 记录每一个子问题的解决方案
     * 用空间换时间
     * @param s 输入字符串
     * @return String
     */
    public static String palindromicSub1(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int strLen = s.length();
        int maxStart = 0;  //最长回文串的起点
        int maxEnd = 0;    //最长回文串的终点
        int maxLen = 1;  //最长回文串的长度
        boolean[][] dp = new boolean[strLen][strLen];
        for (int r = 1; r < strLen; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > maxLen) {
                        maxLen = r - l + 1;
                        maxStart = l;
                        maxEnd = r;
                    }
                }
            }
        }
        return s.substring(maxStart, maxEnd + 1);
    }

    /**
     * 中心扩展算法
     * @param s 输入字符串
     * @return String
     */
    public static String palindromicSub2(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int strLen = s.length();
        int left = 0;
        int right = 0;
        int len = 1;
        int maxStart = 0;
        int maxLen = 0;

        for (int i = 0; i < strLen; i++) {
            left = i - 1;
            right = i + 1;
            while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                len++;
                left--;
            }
            while (right < strLen && s.charAt(right) == s.charAt(i)) {
                len++;
                right++;
            }
            while (left >= 0 && right < strLen && s.charAt(right) == s.charAt(left)) {
                len = len + 2;
                left--;
                right++;
            }
            if (len > maxLen) {
                maxLen = len;
                maxStart = left;
            }
            len = 1;
        }
        return s.substring(maxStart + 1, maxStart + maxLen + 1);
    }
    /**
     * 动态规划详解
     * 暴力递归-->存在大量重复计算
     * 带备忘录的递归解法（自顶向下）-->分解大问题成一个个小问题,记录每一个小问题的结果,避免重复计算
     * 自底向上的动态规划-->最优子结构、状态转移方程、边界、重叠子问题-->动态规划的核心思想就是拆分子问题，记住过往，减少重复计算
     *  一种类似数学归纳法的解题步骤
     *  1.穷举分析
     *  2.确定边界
     *  3.找出规律，确定最优子结构
     *  4.写出状态转移方程
     */
}

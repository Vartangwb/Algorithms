package ProgramChallenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by twb on 2017/9/12.
 */
public class Part2_DP {

    //dp[i+1][j]表示从0到i这i+1个物品中选出总重量不超过J的
    public static void solve(int v[], int[] w, int W){
        int len = v.length;
        int[][] dp = new int[len + 1][W + 1];
        for(int i = 0; i < len; i++){
            for(int j = 0; j <= W; j++){
                if(j < w[i]){
                    dp[i + 1][j] = dp[i][j];
                }else{
                    dp[i + 1][j] = Math.max(dp[i][j], dp[i][j - w[i]] + v[i]);
                }
            }
        }
        System.out.println(dp[len][W]);
    }

    /**
     * 最长工作子序列
     * @param s
     * @param t
     */
    public static void solve2(String s, String t){
        int len_s = s.length();
        int len_t = s.length();
        int dp[][] = new int[len_s + 1][len_t + 1];
        for(int i = 0; i < len_s; i++){
            for(int j = 0; j < len_t; j++){
                if(s.charAt(i) == t.charAt(j)){
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                }else{
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        System.out.println(dp[len_s][len_t]);
    }

    /**
     * 完全背包问题
     * @param v
     * @param w
     * @param len1
     * @param W
     */
    public static void solve3(int v[], int w[], int len1, int W){
        int dp[][] = new int[len1 + 1][W + 1];
        for(int i = 0; i < len1; i++){
            for(int j = 0; j <= W ; j++){
                for(int k = 0; w[i] * k <= j; k++){
                    dp[i+1][j] = Math.max(dp[i + 1][j], dp[i][j - w[i] * k] + v[i] * k);
                }
            }
        }

        System.out.println(dp[len1][W]);
    }

    public static void solve4(int v[], int w[], int len1, int W){
        int dp[][] = new int[2][W + 1];
        for(int i = 0; i < len1; i++){
            for(int j = 0; j <= W ; j++){
                for(int k = 0; w[i] * k <= j; k++){
                    dp[(i+1)&1][j] = Math.max(dp[(i + 1)&1][j], dp[i&1][j - w[i] * k] + v[i] * k);
                }
            }
        }
        System.out.println(dp[len1&1][W]);
    }

    /**
     * 判断多重部分和问题
     * @param v
     * @param w
     * @param len1
     * @param W
     */
    public static void solve5(int a[], int m[], int n, int K){
        boolean dp[][] = new boolean[n + 1][K + 1];
        dp[0][0] = true;
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= K ; j++){
                for(int k = 0; k <= m[i] && a[i] * k <= j; k++){
                    dp[i+1][j] |= dp[i][j - k * a[i]];
                }
            }
        }

        System.out.println(dp[n][K]);
    }

    /**
     * 最长递增子序列问题
     * @param n
     * @param len
     * @return
     */
    public static int solve6(int n[], int len){
        int dp[] = new int[len];
        for(int i = 0; i < len; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(n[j] <= n[i]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        return dp[len - 1];
    }


    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Pair p1 = new Pair(1,3);
        Pair p2 = new Pair(2,5);
        Pair p3 = new Pair(4,7);
        Pair p4 = new Pair(6,9);
        Pair p5 = new Pair(8,10);
        List<Pair> ls = new ArrayList<>();
        ls.add(p1);
        ls.add(p2);
        ls.add(p3);
        ls.add(p4);
        ls.add(p5);
        solve(new int[]{3,2,4,2}, new int[]{2,1,3,2},5);
        solve2("abcd", "becd");
        solve3( new int[]{4,5,3},new int[]{3,4,2},3,7);
        solve4( new int[]{4,5,3},new int[]{3,4,2},3,7);
        solve5( new int[]{3,5,8},new int[]{3,2,2},3,17);
        System.out.println(solve6(new int[]{4,2,3,1,5}, 5));
    }

    public static class Pair {
        int start;
        int end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

}

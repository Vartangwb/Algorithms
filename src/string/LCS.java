package string;

/**
 * Created by twb on 2017/5/30.
 */

import static java.lang.Math.max;

/**
    对于母串X=<x1,x2,⋯,xm>, Y=<y1,y2,⋯,yn>，求LCS与最长公共子串。
    假设Z=<z1,z2,⋯,zk>是X与Y的LCS， 我们观察到
    如果Xm=Yn，则Zk=Xm=Yn，有Zk−1是Xm−1与Yn−1的LCS；
    如果Xm≠Yn，则Zk是Xm与Yn−1的LCS，或者是Xm−1与Yn的LCS。
    因此，求解LCS的问题则变成递归求解的两个子问题。但是，上述的递归求解的办法中，
    重复的子问题多，效率低下。改进的办法——用空间换时间，用数组保存中间状态，方便
    后面的计算。这就是动态规划（DP)的核心思想了。
 */
public class LCS {

    //用二维数组c[i][j]记录串x1x2⋯xi与y1y2⋯yj的LCS长度，则可得到状态转移方程
    public static int lcs(String str1, String str2){
        int len1 = str1.length();
        int len2 = str2.length();
        int c[][] = new int[len1+1][len2+1];
        for(int i = 0; i <= len1; i++){
            for(int j = 0; j <= len2; j++){
                if(i == 0 || j == 0){
                    c[i][j] = 0;
                }else if(str1.charAt(i-1) == str2.charAt(j - 1)){
                    c[i][j] = c[i-1][j-1]+1;
                }else{
                    c[i][j] = max(c[i-1][j], c[i][j-1]);
                }
            }
        }
        return c[len1][len2];
    }


    //最长公共字串
    public static int _lcs(String str1, String str2){
        int len1 = str1.length();
        int len2 = str2.length();
        int result = 0;     //记录最长公共子串长度
        int c[][] = new int[len1+1][len2+1];
        for (int i = 0; i <= len1; i++) {
            for( int j = 0; j <= len2; j++) {
                if(i == 0 || j == 0) {
                    c[i][j] = 0;
                } else if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    c[i][j] = c[i-1][j-1] + 1;
                    result = max(c[i][j], result);
                } else {
                    c[i][j] = 0;
                }
            }
        }
        return result;
    }
//http://blog.csdn.net/u010189459/article/details/28655597
    //最短编辑距离
    public static int minEditDistance(String dest, String src) {

        int[][] f = new int[dest.length() + 1][src.length() + 1];
        f[0][0] = 0;
        for (int i = 1; i < dest.length() + 1; i++) {
            f[i][0] = i;
        }

        for (int i = 1; i < src.length() + 1; i++) {
            f[0][i] = i;
        }

        for (int i = 1; i < dest.length() + 1; i++) {
            for (int j = 1; j < src.length() + 1; j++) {
                // 替换的开销
                int cost = 0;
                if (dest.charAt(i - 1) != src.charAt(j - 1)) {
                    cost = 1;
                }
                int minCost;
                if (f[i - 1][j] < f[i][j - 1]) {
                    minCost = f[i - 1][j] + 1;
                } else {
                    minCost = f[i][j - 1] + 1;
                }
                if (minCost > f[i - 1][j - 1] + cost) {
                    minCost = f[i - 1][j - 1] + cost;
                }
                f[i][j] = minCost;
            }
        }
        return f[dest.length()][src.length()];
    }

    public static void main(String[] args) {
        System.out.println(LCS._lcs("abcdef", "beddeff"));
    }
}

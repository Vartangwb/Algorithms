package string;

import static java.lang.Math.max;

/**
 * Created by twb on 2017/5/30.
 */
//http://www.cnblogs.com/AndyJee/p/4465696.html
//最长回文字符串的的个数
//最长回文子串
public class LSP {

    String findLongestPalindrome(String s)
    {
        int length=s.length();
        int maxlength=1;
        int start = 0;
        boolean P[][]= new boolean[50][50];
        for(int i=0;i<length;i++)//初始化准备
        {
            P[i][i]=true;
            if(i<length-1&&s.charAt(i)==s.charAt(i+1))
            {
                P[i][i+1]=true;
                start=i;
                maxlength=2;
            }
        }
        for(int len=3;len<length;len++)//子串长度
            for(int i=0;i<=length-len;i++)//子串起始地址
            {
                int j=i+len-1;//子串结束地址
                if(P[i+1][j-1]&&s.charAt(i)==s.charAt(j))
                {
                    P[i][j]=true;
                    maxlength=len;
                    start=i;
                }
            }
        System.out.println(maxlength);
        if(maxlength>=2)
            return s.substring(start,start+maxlength);
        return null;
    }



//    https://segmentfault.com/a/1190000003914228
    //最长回文子序列
    //参考
//http://blog.csdn.net/geekmanong/article/details/51056375
    int findLongestPalindromeSeq(String s)
    {
        int length=s.length();

        int P[][]= new int[50][50];
        //字符串长度为1，回文子序列长度为1
        for(int i=0;i<length;i++)//初始化准备
        {
            P[i][i]=1;
        }

        for(int len=1;len<length;len++)//子串长度
        {
            int tmp = 0;
            //考虑长度为len+1的字串
            for(int i=0;i<length-len;i++)//子串起始地址
            {
                if(s.charAt(i)==s.charAt(i+len))
                {
                    tmp = P[i+1][i+len-1]+2;
                }else{
                    tmp = max(P[i+1][i+len], P[i][i+len-1]);
                }
                P[i][len+i] = tmp;
            }
            }
            return P[0][length-1];
    }

    public static void main(String[] args) {
        LSP l = new LSP();
        System.out.println(l.findLongestPalindromeSeq("abbcecba"));
    }
}

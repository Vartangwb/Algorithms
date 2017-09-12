package ProgramChallenge;

import java.util.*;

/**
 * Created by twb on 2017/9/12.
 */
public class Part2_Greedy {

    //public static int V[] = new int[]{1,5,10,50,100,500};

    /**
     * 最多开会数目
     * @param ls
     * @return
     */
    public static int solve(List<Pair> ls){
        int num = 1;
        Collections.sort(ls, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if(o1.end == o2.end){
                    return o1.start - o2.start;
                }else{
                    return o1.end - o2.end;
                }
            }
        });
        int len = ls.size();
        int end = ls.get(0).end;
        for(int i = 1;i<len;i++){
            if(end < ls.get(i).start){
                num++;
                end = ls.get(i).end;
            }
        }
        return num;
    }

    /**
     * 求取字符串翻转之后的最大
     * @param s
     * @return
     */
    public static String solve2(String s){
        String t = "";
        int left = 0;
        int right = s.length() - 1;
        while(left<=right){

            char l = s.charAt(left);
            char r = s.charAt(right);
            if(l > r){
                t += r;
                right--;
            }else if(l < r){
                t+=l;
                left++;
            }else{
                String tmp = new StringBuilder(s.substring(left, right +1)).reverse().toString();
                if(tmp.compareTo(s) < 0){
                    t+=l;
                    left++;
                }else{
                    t+=r;
                    right--;
                }
            }
        }
        return t;
    }

    /**
     * 安放坐标问题
     * @param x
     * @param r
     * @param n
     * @return
     */
    public static int solve3(int x[], int r, int n){
        int num = 0;
        int i = 0;
        while(i < n){
            int start = x[i];
            i++;
            while(i < n && start + r >= x[i])
                i++;
            int p = x[i - 1];
            while(i < n && p + r >= x[i])
                i++;
            num++;
        }
        return num;
    }

    /**
     * 求切割木板的最小花费
     * @param L
     * @param n
     */
    public static void solve4(int L[], int n){
        int ans = 0;
        while(n > 1){
            int min1 = 0;
            int min2 = 1;
            if(L[min1] > L[min2]){
                swap(L, min1, min2);
            }
            for(int i = 2; i < n; i++){
                if(L[i] <= L[min1]){
                    min2 = min1;
                    min1 = i;
                }else if(
                    L[i] <= L[min1]){
                        min2 = i;
                }
            }
            int t = L[min1] + L[min2];
            ans+=t;
            if(min1 == n - 1){
                int tmp = min1;
                min1 = min2;
                min2 = tmp;
            }
            L[min1] = t;
            L[min2] = L[n - 1];
            n--;
        }
        System.out.println(ans);
    }
    public static void swap(int x[], int min1, int min2){
        int tmp = x[min1];
        x[min1] = x[min2];
        x[min2] = tmp;
    }

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
        System.out.println(solve(ls));
        System.out.println(solve2("ACDBCB"));
        System.out.println(solve3(new int[]{1,7,15,20,30,50},10,6));
        solve4(new int[]{8,5,8},3);
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

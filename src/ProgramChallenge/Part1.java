package ProgramChallenge;

import java.util.Arrays;

/**
 * Created by twb on 2017/9/11.
 */
public class Part1 {
    public static final int MAX_N = 100;

    public static boolean binary_search(int x, int left , int right, int[] k){

        while(right - left >= 1){
            int i = (left + right) / 2;
            if(x == k[i]){
                return true;
            }else if(x > k[i]){
                left = i + 1;
            }else{
                right = i;
            }
        }
        return false;
    }

    public static void solve(int[] k, int m, int n){
        boolean flag = false;
        Arrays.sort(k);
        for(int a = 0; a < n; a++){
            for(int b = 0; b < n; b++){
                for(int c = 0; c < n; c++){
                    if(binary_search(m-k[a]-k[b]-k[c], 0, k.length, k))
                        flag = true;
                }
            }
        }
        System.out.println(flag);
    }

    public static void main(String[] args) {
        solve(new int[]{1,2,3,4,5}, 5, 5);
    }

}

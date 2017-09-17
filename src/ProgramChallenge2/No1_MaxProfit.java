package ProgramChallenge2;

/**
 * Created by twb on 2017/9/15.
 */
public class No1_MaxProfit {

    public static int maxProfit(int A[], int len){
        int max = Integer.MIN_VALUE;
        int minV = A[0];
        for(int i = 1; i < len; i++){
            max = Math.max(max, A[i] - minV);
            minV = Math.min(minV, A[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{3,2,5}, 3));
    }

}

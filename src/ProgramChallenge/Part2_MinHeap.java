package ProgramChallenge;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by twb on 2017/9/14.
 */
public class Part2_MinHeap {
    /**
     * 最大堆，最小堆的插入和查找复杂度都是log(n)
     * 二叉搜索树的操作都是O(log(n))
     * 平衡二叉树借助旋转操作保持树的平衡,
     */


    public static final int MAX_VALUE = 1000;

    /**
     * 车站加油问题，使用优先队列，然后把车站的第len项普通化。
     * @param A
     * @param B
     * @param L
     * @param P
     * @param len
     */
    public static void solve(int A[], int B[], int L, int P, int len){
        Queue<Integer> queue = new LinkedList<>();

        A[len] = L;
        B[len] = 0;

        len++;
        //加油次数
        int ans = 0;
        //pos:现在所处的位置
        int pos = 0;

        int tank = P;

        for(int i = 0;i<len;i++){
            int d = A[i] - pos;
            while(tank - d < 0){
                if(queue.size() == 0){
                    System.out.println("-1");
                    return ;
                }
                tank += queue.poll();
                ans++;
            }
            tank -= d;
            pos = A[i];
            queue.add(B[i]);
        }
    }

    /**
     * 木板合并问题
     * @param L
     * @param len
     */
    public static void solve2(int L[], int len){
        int ans = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < len; i++){
            queue.add(L[i]);
        }
        while(queue.size() > 1){
            int l1 = 0;
            int l2 = 0;
            l1 = queue.poll();
            l2 = queue.poll();
            ans += l1 + l2;
            queue.add(l1 + l2);
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        solve2(new int[]{1,2,3},3);
    }
}

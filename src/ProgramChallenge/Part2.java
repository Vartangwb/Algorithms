package ProgramChallenge;

/**
 * Created by twb on 2017/9/11.
 */
public class Part2 {

    /**
     * 给定数组，判断是否可以从中选出若干数，使其和为k
     * @param arr
     * @return
     */
    public static boolean solve1(int[] arr, int k){
        return dfs(0, 0, arr.length, k, arr);
    }

    public static boolean dfs(int i, int sum, int len, int k, int[] arr){
        if( i == len)
            return sum == k;
        //不加上i之后的结果
        if(dfs(i + 1, sum, len, k, arr)){
            return true;
        }
        //加上i之后的结果
        if(dfs(i + 1, sum + arr[i], len, k, arr)){
            return true;
        }
        return false;
    }

    /**
     * DFS判断水渠的数量
     * @param field
     * @return
     */
    public static int solve2(char[][] field){
        int num = 0;
        for(int i = 0; i < field.length;i++){
            for(int j = 0; j < field[0].length; j++){
                if(field[i][j] == 'W'){
                    dfs2(field, i, j);
                    num++;
                }
            }
        }
        return num;
    }
    public static void dfs2(char[][] field, int x, int y){
        field[x][y] = '.';
        for(int i = -1; i <= 1; i++){
            for(int j = -1; j <= 1;j++){
                int nx = x + i;
                int ny = y + j;
                if(0<=nx && nx < field.length && 0<=ny && ny < field[0].length){
                    if(field[nx][ny] == 'W'){
                        dfs2(field, nx, ny);
                    }
                }
            }
        }
    }



    public static void main(String[] args) {
        System.out.println(solve1(new int[]{1,2,3,4,5}, 10));
        System.out.println(solve2(new char[][]{{}}));
    }

}

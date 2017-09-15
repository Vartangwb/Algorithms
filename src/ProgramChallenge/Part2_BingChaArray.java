package ProgramChallenge;

/**
 * Created by twb on 2017/9/14.
 */
public class Part2_BingChaArray {

    public static final int MAX_N = 100;

    public static int[] par = new int[MAX_N];

    public static int[] rank = new int[MAX_N];

    public static void init(int n){
        for(int i = 0; i < n; i++){
            par[i] = i;
            rank[i] = 0;
        }
    }

    //查找树根
    public static int find(int x){
        if(par[x] == x){
            return x;
        }else{
            return par[x] = find(par[x]);
        }
    }
    //合并xy所属的集合
    public static void unite(int x, int y){
        x = find(x);
        y = find(y);
        if(x == y)
            return;
        if(rank[x] < rank[y]){
            par[x] = y;
        }else{
            par[y] = x;
            if(rank[x] == rank[y])
                rank[x] ++;
        }
    }

    public static boolean same(int x, int y){
        return find(x) == find(y);
    }

    public static void main(String[] args) {

    }

}

package ProgramChallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by twb on 2017/9/14.
 */
public class Part2_Map {

    /**
     * 图的表示方法：
     * (1)0-1矩阵
     * (2)邻接表
     * (3)
     */
    public static final int MAX_V = 100;

    List<List<Integer>> G = new ArrayList<>();
    int V; //顶点数
    int color[] = new int[MAX_V];

    /**
     * 二分图问题
     * @param v
     * @param c
     * @return
     */
    public boolean dfs(int v, int c){
        color[v] = c;
        for(int i = 0; i<G.get(v).size();i++){
            //如果相邻的顶点同色，则返回false
            if(color[G.get(v).get(i)] == c){
                return false;
            }
            //如果相邻的顶点没被染色，则染成-c
            if(color[G.get(v).get(i)] == 0 && !dfs(G.get(v).get(i), -c))
                return false;
        }
        return true;
    }

    public void solve(){
        for(int i = 0; i < V; i++){
            if(color[i] == 0){
                if(!dfs(i,1)){
                    System.out.println(false);
                    return;
                }
            }
        }
        System.out.println(true);
    }

    class Edge{
        int from;
        int to;
        int cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }


    List<Edge> edges = new ArrayList<>();
    int d[] = new int[MAX_V];

    void shortest_path(int s){
        for(int i = 0; i < V; i++){
            d[i] = Integer.MAX_VALUE;
        }
    }

    public static void main(String[] args) {
        Part2_Map part2_map = new Part2_Map();
        part2_map.G.add(Arrays.asList(1,3));
        part2_map.G.add(Arrays.asList(0,2));
        part2_map.G.add(Arrays.asList(1,3));
        part2_map.G.add(Arrays.asList(0,2));
        part2_map.V = 4;
        part2_map.solve();
    }
}

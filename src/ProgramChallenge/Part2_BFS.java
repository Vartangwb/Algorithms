package ProgramChallenge;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by twb on 2017/9/11.
 */
public class Part2_BFS {
    public static int MAX_N = 1000;
    public static int MAX_M = 1000;
    public static char maze[][] = new char[MAX_N][MAX_M];
    public static int d[][] = new int[MAX_N][MAX_M];
    public static int dx[] = new int[]{1,0,-1,0};
    public static int dy[] = new int[]{0,1,0,-1};
    public static int N = 100;
    public static int M = 100;
    public static int INF = 1000000;
    int bfs(int sx,int sy, int gx, int gy){
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(sx, sy));
        d[sx][sy] = 0;
        while(queue.size() > 0){
            Pair p = queue.poll();
            if(p.x == gx && p.y ==  gy)
                break;
            for(int i = 0;i<4;i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(0<=nx && nx<N && ny>=0 && ny<M){
                    if(maze[nx][ny] != '#' && d[nx][ny] == INF){
                        queue.add(new Pair(nx, ny));
                        d[nx][ny] = d[p.x][p.y] + 1;
                    }
                }
            }
        }
        return d[gx][gy];
    }

    public static void solve(int sx,int sy, int gx, int gy){

    }


    public static void main(String[] args) {

    }

    public class Pair{

        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

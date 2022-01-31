
/**
 * @author: ByeongJoon Kim
 * @Judge_site: programmers
 * @level: 2
 * @prob_name: 게임 맵 최단 거리
 * @prob_url: https://programmers.co.kr/learn/courses/30/lessons/1844
 *
 * 대표적인 알고리즘인 BFS를 사용하여 최단거리를 구하는 문제
 */

import java.util.*;

class Pos{
    int x, y;
    Pos(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Solution {

    class Pos{
        int x, y;
        Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m;
    static int[][] dist;

    void arrInit(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                dist[i][j] = -1;
            }
        }
    }

    boolean isInRange(int x, int y){
        if(x < 0 || x >= n || y < 0 || y >= m) return false;
        return true;
    }

    public int solution(int[][] maps) {
        int answer = 0;
        n = maps.length;
        m = maps[0].length;
        dist = new int[n][m];
        arrInit();
        Queue<Pos> q = new LinkedList<>();
        q.offer(new Pos(0, 0));
        dist[0][0] = 1;

        while(!q.isEmpty()){
            int x = q.peek().x;
            int y = q.peek().y;
            q.remove();
            for(int dir = 0; dir < 4; ++dir){
                int nx = x + dx[dir], ny = y + dy[dir];
                if(isInRange(nx, ny) && maps[nx][ny] == 1 && dist[nx][ny] == -1){
                    dist[nx][ny] = dist[x][y] + 1;
                    q.offer(new Pos(nx, ny));
                }
            }
        }
        return dist[n-1][m-1];
    }
}
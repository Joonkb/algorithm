
  /**
 * @author: ByeongJoon Kim
 * @Judge_site: programmers
 * @level: 2
 * @prob_name: 게임 맵 최단 거리
 * @prob_url: https://programmers.co.kr/learn/courses/30/lessons/1844
 *
 * 대표적인 알고리즘인 BFS를 사용하여 최단거리를 구하는 문제
 */


#include <vector>
#include <queue>
#include <algorithm>
#include <cstring>
using namespace std;

int dx[] = {-1, 0, 1, 0};
int dy[] = {0, 1, 0, -1};
int dist[101][101];
int n, m;

bool isInRange(int x, int y){
    if(x < 0 || x >= n || y < 0 || y >= m) return false;
    return true;
}

int solution(vector<vector<int> > maps)
{
    int answer = -1;
    n = maps.size(), m = maps[0].size();
    memset(dist, -1, sizeof(dist));
    queue<pair<int, int>> q;
    q.push({0, 0});
    dist[0][0] = 1;
    
    while(!q.empty()){
        int x = q.front().first, y = q.front().second; q.pop();
        for(int dir = 0; dir < 4; ++dir){
            int nx = x + dx[dir], ny = y + dy[dir];
            if(isInRange(nx, ny) && maps[nx][ny] == 1 && dist[nx][ny] == -1){
                dist[nx][ny] = dist[x][y] + 1;
                q.push(make_pair(nx, ny));
            }
        }
    }
    answer = dist[n-1][m-1];
    return answer;
}
/**
 * @author: ByeongJoon Kim
 * @Judge_site: programmers
 * @level: 3
 * @prob_name: 가장 먼 노드
 * @prob_url: https://programmers.co.kr/learn/courses/30/lessons/49189
 * 
 */

#include <string>
#include <vector>
#include <queue>
#include <cstring>

using namespace std;

const int SIZE = 20001;

int dist[SIZE];
vector<int> graph[SIZE];

int dfs(int start) {
    int distant = 0;
    queue<int> q;
    q.push(start);
    dist[start] = 0;
    while (!q.empty()) {
        int x = q.front(); q.pop();
        for (int i = 0; i < graph[x].size(); i++) {
            int y = graph[x][i];
            if (dist[y] != -1) continue;
            dist[y] = dist[x] + 1;
            q.push(y);
        }
        distant = dist[x];
    }
    return distant;
}

int solution(int n, vector<vector<int>> edge) {
    memset(dist, -1, sizeof(dist));
    int answer = 0;
    // 그래프 구성
    for (int i = 0; i < edge.size(); i++) {
        graph[edge[i][0]].push_back(edge[i][1]);
        graph[edge[i][1]].push_back(edge[i][0]);
    }
    // 거리계산
    int longDist = dfs(1);
    for (int i = 1; i <= n; i++) {
        if (longDist == dist[i]) answer++;
    }
    return answer;
}
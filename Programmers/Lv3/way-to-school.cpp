/**
 * @author: ByeongJoon Kim
 * @Judge_site: programmers
 * @level: 3
 * @prob_name: 등굣길
 * @prob_url: https://programmers.co.kr/learn/courses/30/lessons/42898
 * @desc : 
 * 전형적인 dp 문제, 시간이 소요된 부분 -> 문제의 (m,n)의 좌표와 
 * 배열의[][] 좌표가 서로 달라서 값이 다르게 나옴 
 */

#include <string>
#include <vector>
#include <iostream>
using namespace std;

const int MAX = 100;
static const long mod = 1000000007L;
long board[MAX][MAX];

int calc(int m, int n) {
    board[0][0] = 1;
    for (int i = 1; i < n; i++) { 
        if (board[i][0] == -1) board[i][0] = -1;
        else  board[i][0] = board[i - 1][0];
    }
    for (int i = 1; i < m; i++) {
        if (board[0][i] == -1) board[0][i] = -1;
        board[0][i] = board[0][i-1]; 
    }
    for (int i = 1; i < n; i++) {
        for (int j = 1; j < m; j++) {
            long& ret = board[i][j];
            if (ret == -1) continue;
            if (board[i - 1][j] != -1) ret += board[i - 1][j];
            ret = ret % mod;
            if (board[i][j-1] != -1) ret += board[i][j-1];
            ret = ret % mod;
        }
    }
    return board[n - 1][m - 1];
}

int solution(int m, int n, vector<vector<int>> puddles) {
    int answer = 0;
    for (int i = 0; i < puddles.size(); i++) {
        board[puddles[i][0]-1][puddles[i][1]-1] = -1;
    }
    answer = calc(m, n);
    return answer;
}

int main() {
    vector<vector<int>> puddles = { {2, 2} };
    solution(4, 3, puddles);
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 4; j++) {
            cout << board[i][j] << ' ';
        }
        cout << '\n';
    }
    cout << '\n';
}
/**
 * @author: ByeongJoon Kim
 * @Judge_site: programmers
 * @level: 3
 * @prob_name: 리틀 프렌즈 사천성
 * @prob_url: https://programmers.co.kr/learn/courses/30/lessons/1836
 *
 */

/*
* @desc : 전형적인 브루트포스 문제로 보임, 조건이 매우 까다로움.
* 
*/

#include <string>
#include <vector>
#include <algorithm>

using namespace std;

static vector<char> ans;
bool needSort = false;

int dx[] = { -1, 0, 1, 0 };
int dy[] = { 0, 1, 0, -1 };

bool isInRange(int x, int y, int m, int n) {
    if (0 > x || x >= m || 0 > y || y >= n) return false;
    return true;
}
// 모두 제거했는지 체크
bool isAllClear(int m, int n, vector<string> board) {
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (board[i][j] != '.' || board[i][j] != '*') return false;
        }
    }
    return true;
}

// 인접한 2개 제거하기
void clearAdjacent(int m, int n, vector<string> board) {
    int count = 0;
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (board[i][j] == '.' || board[i][j] == '*') continue;
            for (int dir = 0; dir < 4; ++dir) {
                int nx = i + dx[dir], ny = j + dy[dir];
                if (isInRange(nx, ny, m, n) && (board[i][j] == board[nx][ny])) {
                    count++;
                    board[i][j] = board[nx][ny] = '.';
                    ans.push_back(board[i][j]);
                }
            }
        }
    }
    if (count >= 2) needSort = true;
}

int stepClear(int m, int n, vector<string> board) {
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (board[i][j] == '.' || board[i][j] == '*') continue;
            // 알파벳 제거하기
        }
    }
}


// 전역 변수를 정의할 경우 함수 내에 초기화 코드를 꼭 작성해주세요.
string solution(int m, int n, vector<string> board) {
    string answer = "";
    clearAdjacent(m, n, board);
    while (!isAllClear(m, n, board)) {
        stepClear(m, n, board);
    }
    return answer;
}
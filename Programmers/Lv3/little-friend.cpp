/**
 * @author: ByeongJoon Kim
 * @Judge_site: programmers
 * @level: 3
 * @prob_name: ��Ʋ ������ ��õ��
 * @prob_url: https://programmers.co.kr/learn/courses/30/lessons/1836
 *
 */

/*
* @desc : �������� ���Ʈ���� ������ ����, ������ �ſ� ��ٷο�.
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
// ��� �����ߴ��� üũ
bool isAllClear(int m, int n, vector<string> board) {
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (board[i][j] != '.' || board[i][j] != '*') return false;
        }
    }
    return true;
}

// ������ 2�� �����ϱ�
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
            // ���ĺ� �����ϱ�
        }
    }
}


// ���� ������ ������ ��� �Լ� ���� �ʱ�ȭ �ڵ带 �� �ۼ����ּ���.
string solution(int m, int n, vector<string> board) {
    string answer = "";
    clearAdjacent(m, n, board);
    while (!isAllClear(m, n, board)) {
        stepClear(m, n, board);
    }
    return answer;
}
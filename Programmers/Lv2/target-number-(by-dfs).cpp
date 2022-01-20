/**
 * @author: ByeongJoon Kim
 * @Judge_site: programmers
 * @level: 2
 * @prob_name: Ÿ�� �ѹ�
 * @prob_url: https://programmers.co.kr/learn/courses/30/lessons/43165?language=cpp
 *
 */

 /*
     ������ ������� DFS�� �̿��� Ǯ��, �� ��ͷ� Ǯ��
 */

#include <string>
#include <vector>

using namespace std;

int dfs(vector<int> numbers, int index, int target, int sum) {
    if (index == numbers.size() && target == sum) return 1;
    if (index == numbers.size()) return 0;
    int res = 0;
    res += dfs(numbers, index + 1, target, sum + numbers[index]);
    res += dfs(numbers, index + 1, target, sum - numbers[index]);
    return res;
}


int solution(vector<int> numbers, int target) {
    int answer = 0;
    answer = dfs(numbers, 0, target, 0);
    return answer;
}
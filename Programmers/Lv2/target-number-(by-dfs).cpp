/**
 * @author: ByeongJoon Kim
 * @Judge_site: programmers
 * @level: 2
 * @prob_name: 타겟 넘버
 * @prob_url: https://programmers.co.kr/learn/courses/30/lessons/43165?language=cpp
 *
 */

 /*
     문제의 유형대로 DFS를 이용한 풀이, 즉 재귀로 풀기
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
/**
 * @author: ByeongJoon Kim
 * @Judge_site: programmers
 * @level: 2
 * @prob_name: 타겟 넘버
 * @prob_url: https://programmers.co.kr/learn/courses/30/lessons/43165?language=cpp
 *
 */

 /*
     비트 연산자를 이용한 풀이
     빠르게 무지성으로 푼 풀이, +연산자를 : 1, - 연산자를 0으로 생각
 */

#include <string>
#include <vector>

using namespace std;

int solution(vector<int> numbers, int target) {
    int answer = 0;
    int nsize = numbers.size();
    for (int i = 0; i < (1 << nsize); i++) {
        int sum = 0;
        for (int j = 0; j < nsize; j++) {
            if (i & (1 << j)) sum += numbers[j];
            else sum -= numbers[j];
        }
        if (sum == target) answer++;
    }
    return answer;
}
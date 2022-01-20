/**
 * @author: ByeongJoon Kim
 * @Judge_site: programmers
 * @level: 2
 * @prob_name: 큰 수 만들기
 * @prob_url: https://programmers.co.kr/learn/courses/30/lessons/42883
 *
 */

 /*
 * @desc : 브루트 포스 문제로 착각 ( 모든 경우의 수를 만들어 보자) 
           -> 1,000,000 C 999,999 가지의 경우의수
   10^6 : 이라는 점에서 nlogn, n 의 시간복잡도인 풀이를 생각해야함
 
 */

#include <string>
#include <vector>

using namespace std;

string solution(string number, int k) {
    string answer = "";
    int ssize = number.size() - k;
    for (int i = 0; i < number.size(); i++) {
        int idx = i;
        int maxNum = number[i] - '0';
        for (int j = i; j <= number.size() - k; j++) {
            int num = number[j] - '0';
            if (maxNum < num) {
                idx = j;
                maxNum = num;
            }
        }
        i = idx;
        answer += (maxNum+ '0');
        ssize--;
        if (ssize == 0) break;
    }
    return answer;
}
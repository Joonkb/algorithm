/**
 * @author: ByeongJoon Kim
 * @Judge_site: programmers
 * @level: 1
 * @prob_name: 완주하지 못한선수
 * @prob_url: https://programmers.co.kr/learn/courses/30/lessons/42576
 *
 */

/*
    hash를 사용해서 푸는 문제
    동명이인에 대한 처리와 등 확인후 어떻게 처리할 것인가?
*/

#include <string>
#include <vector>
#include <map>
using namespace std;

string solution(vector<string> participant, vector<string> completion) {
    string answer = "";
    map<string, int> ma;
    for (int i = 0; i < participant.size(); i++) {
        ma[participant[i]]++;
    }
    for (string people : completion) {
        ma[people]--;
    }
    for (int i = 0; i < participant.size(); i++) {
        if (ma[participant[i]] == 1) answer = participant[i];
    }
    return answer;
}
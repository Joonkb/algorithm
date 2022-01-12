/**
 * @author: ByeongJoon Kim
 * @Judge_site: programmers
 * @level: 1
 * @prob_name: 모의고사
 * @prob_url: https://programmers.co.kr/learn/courses/30/lessons/42840?language=cpp
 *
 */

 /*
 * 간단한 구현 문제
 * s1과 관련된 변수들을 2차원 배열로 구성하면 
 * 코드의 길이를 조금 더 줄일 수 있을거 같음
 */

#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;

int s1_pick[] = { 1, 2, 3, 4, 5 };
int s2_pick[] = { 2, 1, 2, 3, 2, 4, 2, 5 };
int s3_pick[] = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

vector<int> calc(vector<int> answers) {
    vector<int> answer;
    int s1_count = 0, s2_count = 0, s3_count = 0;
    int s1_index = 0, s2_index = 0, s3_index = 0;
    for (int i = 0; i < answers.size(); i++) {
        if (s1_pick[i%5] == answers[i]) s1_count++;
        if (s2_pick[i%8] == answers[i]) s2_count++;
        if (s3_pick[i%10] == answers[i]) s3_count++;
        cout << s1_count << '\n';
    }
    int max_cnt =  max(max(s1_count, s2_count), s3_count);
    cout <<"max = "<< max_cnt << '\n';
    if (max_cnt == s1_count) answer.push_back(1);
    if (max_cnt == s2_count) answer.push_back(2);
    if (max_cnt == s3_count) answer.push_back(3);
    cout << answer.size() << '\n';
    return answer;
}

vector<int> solution(vector<int> answers) {
    vector<int> answer;
    answer = calc(answers);
    return answer;
}
/**
 * @author: ByeongJoon Kim
 * @Judge_site: programmers
 * @level: 1
 * @prob_name: �������� ���Ѽ���
 * @prob_url: https://programmers.co.kr/learn/courses/30/lessons/42576
 *
 */

/*
    hash�� ����ؼ� Ǫ�� ����
    �������ο� ���� ó���� �� Ȯ���� ��� ó���� ���ΰ�?
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
/**
 * @author: ByeongJoon Kim
 * @Judge_site: programmers
 * @level: 2
 * @prob_name: ū �� �����
 * @prob_url: https://programmers.co.kr/learn/courses/30/lessons/42883
 *
 */

 /*
 * @desc : ���Ʈ ���� ������ ���� ( ��� ����� ���� ����� ����) 
           -> 1,000,000 C 999,999 ������ ����Ǽ�
   10^6 : �̶�� ������ nlogn, n �� �ð����⵵�� Ǯ�̸� �����ؾ���
 
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
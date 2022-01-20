/**
 * @author: ByeongJoon Kim
 * @Judge_site: programmers
 * @level: 2
 * @prob_name: Ÿ�� �ѹ�
 * @prob_url: https://programmers.co.kr/learn/courses/30/lessons/43165?language=cpp
 *
 */

 /*
     ��Ʈ �����ڸ� �̿��� Ǯ��
     ������ ���������� Ǭ Ǯ��, +�����ڸ� : 1, - �����ڸ� 0���� ����
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
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
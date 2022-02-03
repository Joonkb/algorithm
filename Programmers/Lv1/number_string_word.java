/**
 * @author: ByeongJoon Kim
 * @Judge_site: programmers
 * @level: 1
 * @prob_name: 숫자 문자열과 영단어
 * @prob_url: https://programmers.co.kr/learn/courses/30/lessons/81301
 *
 * 문자열 처리 라이브러리를 이해하고 활용하는 문제
 *
 */

class Solution {
    static String[] mapping = { "zero", "one", "two", "three", "four",
            "five", "six", "seven", "eight", "nine"};
    public int solution(String s) {
        int answer = 0;
        for(int i= 0 ; i < mapping.length; i++){
            s = s.replaceAll(mapping[i], "" + i);
        }
        answer = Integer.parseInt(s);
        return answer;
    }
}
/**
 * @author: ByeongJoon Kim
 * @Judge_site: programmers
 * @level: 2
 * @prob_name: 짝지어 제거하기
 * @prob_url: https://programmers.co.kr/learn/courses/30/lessons/12973
 *
 *  스택 활용하기
 */

import java.util.Stack;

public class remove_pair {
    public int solution(String s) {
        int answer = 0;
        Stack<Character> stack = new Stack<Character>();
        for(char ch : s.toCharArray()) {
            if(stack.isEmpty() || stack.peek() != ch) stack.push(ch);
            else stack.pop();
        }
        if(stack.isEmpty()) answer = 1;
        return answer;
    }
}

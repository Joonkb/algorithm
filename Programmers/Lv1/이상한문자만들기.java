package W11;

public class 이상한문자만들기 {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        int idx = 0;
        for (Character ch : s.toCharArray()) {
            if(ch ==  ' ') {
                idx = 0;
                answer.append(' ');
                continue;
            }
            answer.append(processIfNotSpace(ch, idx++));
        }
        return answer.toString();
    }

    private String processIfNotSpace(Character ch, int idx) {
        if (idx % 2 == 0) {
            return (ch + "").toUpperCase();
        }
        return (ch + "").toLowerCase();
    }
}

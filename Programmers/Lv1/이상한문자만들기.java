package W11;

public class 이상한문자만들기 {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        for (String word : s.split(" ")) {
            for (int idx = 0; idx < word.length(); ++idx) {
                if(word.charAt(idx) == ' ') sb.append(" ");
                if (idx % 2 == 0) sb.append((word.charAt(idx)+"").toUpperCase());
                else sb.append((word.charAt(idx)+"").toLowerCase());
            }
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}

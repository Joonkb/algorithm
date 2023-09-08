package W11;

public class 시저암호 {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if(c == ' ') {
                sb.append(' ');
                continue;
            }
            if (isLowerCase(c)) {
                c -= 'a';
                c += n;
                sb.append("" + Character.toString('a' + (c%26)));
                continue;
            }
            c -= 'A';
            c += n;
            sb.append(""+  Character.toString('A' + (c%26)));
        }
        return sb.toString();
    }
    private boolean isLowerCase(char c) {
        return 'a' <= c && c <= 'z';
    }
}

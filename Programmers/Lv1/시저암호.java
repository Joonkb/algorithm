package W11;

public class 시저암호 {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (Character ch : s.toCharArray()) {
            sb.append(pushAlpha(ch, n));
        }
        return sb.toString();
    }

    private Character pushAlpha(Character s, int n) {
        if(!Character.isAlphabetic(s)) return ' ';

        // 시저암호 구현.
        char alpha = (Character.isLowerCase(s) ? 'a' : 'A');
        int offset = s - alpha;
        int pushedAlpha = (n + offset) % 26 + alpha;

        return (char)pushedAlpha;
    }
}

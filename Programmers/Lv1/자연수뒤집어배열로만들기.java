package W11;

public class 자연수뒤집어배열로만들기 {
    public int[] solution(long n) {
        int numberLength = String.valueOf(n).length();
        int[] answer = new int[numberLength];

        int idx = 0;
        while (n != 0) {
            answer[idx++] = (int) (n % 10);
            n /= 10;
        }
        return answer;
    }
}

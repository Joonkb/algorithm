import java.util.*;

public class p20436 {

    static int n, m;
    static Map<Character, Integer> map = new HashMap<>();
    static Set<Character> set = new HashSet<>();
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String keyboardInit = "qwertyuiopasdfghjkl zxcvbnm   ";
        int now = 0;
        for (char c : keyboardInit.toCharArray()) {
            map.put(c, now++);
        }
        String leftHandPress = "qwertasdfgzxcv";
        for (char c : leftHandPress.toCharArray()) {
            set.add(c);
        }

        String[] temp = sc.nextLine().split(" ");
        int left = map.get(temp[0].charAt(0)), right = map.get(temp[1].charAt(0));
        int lx = left / 10, ly = left % 10;
        int rx = right / 10, ry = right % 10;
        String line = sc.nextLine();
        int answer = 0;
        for (char c : line.toCharArray()) {
            answer += 1;
            if(set.contains(c)){
                // 왼손이 눌러야 하는 경우
                int cx = map.get(c) / 10, cy = map.get(c) % 10;
                int dist = Math.abs(lx - cx) + Math.abs(ly - cy);
                answer += dist;
                lx = cx;
                ly = cy;
            } 
            else{
                // 오른손이 눌러야 하는 경우
                int cx = map.get(c) / 10, cy = map.get(c) % 10;
                int dist = Math.abs(rx - cx) + Math.abs(ry - cy);
                answer += dist;
                rx = cx;
                ry = cy;
            }
//            System.out.println("answer = " + answer);
        }
        System.out.println(answer);
    }
}
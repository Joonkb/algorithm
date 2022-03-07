/**
 *
 * 추후 리팩토링 필요함
 * 더 간단한 코드는 이를 반으로 줄일 수 있음
 *
 */


import java.util.Scanner;

public class p3029 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int idx = 0;
        int[] now = new int[3];
        int[] target = new int[3];
        int[] result = new int[3];
        for(String time : sc.nextLine().split(":")){
            now[idx++] = Integer.parseInt(time);
        }
        idx = 0;
        for(String time : sc.nextLine().split(":")){
            target[idx++] = Integer.parseInt(time);
        }
        if(target[2] - now[2] < 0) {
            target[1]--;
            target[2] += 60;
        }
        result[2] = target[2] - now[2];
        StringBuilder ss = new StringBuilder();
        if(result[2] < 10) ss.append("0");
        ss.append(result[2]);
        if(target[1] - now[1] < 0) {
            target[0]--;
            target[1] += 60;
        }
        result[1] = target[1] - now[1];
        StringBuilder mm = new StringBuilder();
        if(result[1] < 10) mm.append("0");
        mm.append(result[1]);
        if(target[0] - now[0] < 0) {
            target[0] += 24;
        }
        result[0] = target[0] - now[0];
        StringBuilder hh = new StringBuilder();
        if(result[0] < 10) hh.append("0");
        hh.append(result[0]);

        boolean ok = true;
        for(int i = 0; i < 3; i++){
            if(result[i] != 0) ok = false;
        }
        String answer = hh.append(":").append(mm).append(":").append(ss).toString();
        if(ok) System.out.println("24:00:00");
        else System.out.println(answer);
    }
}

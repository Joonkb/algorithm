package W4;

import java.util.Scanner;

public class p5566 {

    static int[] move = new int[2001];
    static int[] dice = new int[2001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        for(int i = 1; i <= N; i++){
            move[i] = sc.nextInt();
        }
        for(int i = 1; i <= M; i++){
            dice[i] = sc.nextInt();
        }
        int cnt = 0, pos = 1;
        for(cnt = 1; cnt <= N; cnt++) {
            int num = dice[cnt];
            pos += num;
            if(pos >= N) break;
            pos += move[pos];
            if(pos >= N) break;
        }

        System.out.println(cnt);
    }
}

/**
 *  BOJ - 문제풀이
 *  집합
 *  https://www.acmicpc.net/problem/11723
 *  문제유형 : 집합 (구현-비트연산자)
 */

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class p11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int num = 0, x = 0;
        int M = Integer.parseInt(br.readLine());
        while(M-- > 0){
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            switch (cmd) {
                case "add":
                    x = Integer.parseInt(st.nextToken()); x--;
                    num = num | (1<<x);
                    break;
                case "remove":
                    x = Integer.parseInt(st.nextToken()); x--;
                    num = num & ~(1<<x);
                    break;
                case "check":
                    x = Integer.parseInt(st.nextToken()); x--;
                    int res = ((num & (1<<x)) > 0 ? 1 : 0);
                    bw.write(res+"\n");
                    break;
                case "toggle":
                    x = Integer.parseInt(st.nextToken()); x--;
                    num = num ^ (1<<x);
                    break;
                case "all":
                    num = (1 << 20) - 1;
                    break;
                case "empty":
                    num = 0;
                    break;
                default:
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
}
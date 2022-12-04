/**
 *  BOJ - 문제풀이
 *  골드바흐의 추측
 *  https://www.acmicpc.net/problem/6588
 *  문제유형 : 수학(소수) -(에라토스테네스의 체)
 */

import java.util.Scanner;

public class p6588 {

    final static int N = 1000000;
    static boolean isPrime[] = new boolean[N + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        eratosthenes();
        while(true){
            int num = sc.nextInt();
            if(num == 0) break;
            solution(num);
        }
    }

    private static void eratosthenes() {
        isPrime[1] = true; // 소수 X
        for(int start = 2; start <= N; start++) {
            if(isPrime[start]) continue;
            for(int step = start + start ; step <= N; step += start){
                if(!isPrime[step]) isPrime[step] = true;
            }
        }
    }
    private static void solution(int num){
        for(int i = 3; i <= N; i+= 2){
            if(!isPrime[i] && !isPrime[num - i]){
                System.out.println(num + " = " + i + " + " + (num - i));
                return;
            }
        }
        System.out.println("Goldbach's conjecture is wrong.");
    }
}

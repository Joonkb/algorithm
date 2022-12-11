/**
 *  BOJ - 부분수열의 합
 *  https://www.acmicpc.net/problem/1182
 *
 */

import java.util.Scanner;

public class p1182 {

    static int N, S;
    static int arr[] = new int[20];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int ans = 0;
        N = sc.nextInt();
        S = sc.nextInt();

        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }

        for(int i = 1; i < (1<<N); i++){
            int sum = 0;
            for(int j = 0; j < N; j++){
                if((i & (1<<j)) != 0) {
                    sum += arr[j];
                }
            }
            if(sum == S) ans++;
        }
        System.out.println(ans);
    }
}

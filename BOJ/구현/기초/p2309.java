/**
 * BOJ - 일곱 난쟁이
 * https://www.acmicpc.net/problem/2309
 */

import java.util.*;

public class p2309 {
    final static int N = 9;
    static int[] arr = new int[N];
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int sum = 0;

        for(int i = 0 ; i < N; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        Arrays.sort(arr);

        for(int i = 0; i < N; i++) {
            for(int j = i + 1; j < N; j++) {
                if((sum - arr[i] - arr[j]) == 100){
                    printArr(i, j);
                    return;
                }
            }
        }

    }

    private static void printArr(int e1, int e2) {
        for(int i = 0; i < N; i++) {
            if(i == e1 || i == e2) continue;
            System.out.println(arr[i]);
        }
    }
}
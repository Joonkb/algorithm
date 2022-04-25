package W4;

import java.util.Scanner;

public class p2023 {
    static final int MAX = 100000000;
    static boolean[] prime = new boolean[MAX];
    static int N;
    
    // false 인 경우 -> prime에 해당
    public static void eratosthenes(){
        prime[0] = prime[1] = true;
        for(int i = 2; i <= Math.sqrt(MAX); i += 1){
            if(prime[i]) continue;  // 지워진 경우 넘김

            for(int j = i + i; j <= Math.sqrt(MAX); j+= i){
                prime[j] = true;
            }
        }

    }

    public static boolean validate(int n){
        while(true){
            if(prime[n]) return false;
            n /= 10;
            if(n == 0) break;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        eratosthenes();

        int answer = 0;
        for(int num = (int)Math.pow(10, N-1); num < Math.pow(10, N); num++){
            if(validate(num)) System.out.println(num);
        }
        System.out.println(answer);
    }
}

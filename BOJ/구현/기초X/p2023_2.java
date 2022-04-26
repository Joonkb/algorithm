package W4;

import java.util.*;

public class p2023 {
    static int N;

    public static boolean isPrime(int num){
        if(num == 0 || num == 1) return false;
        if(num == 2 || num == 3) return true;

        for(int div = 2; div <= Math.sqrt(num); ++div){
            if(num % div == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        Deque<Integer> nums = new ArrayDeque<>();
        nums.add(0);
        for(int cnt = 1; cnt <= N; ++cnt) {
            int size = nums.size();
            for(int i = 0; i < size; i++){
                int num = nums.pollFirst();
                for(int j = 1; j <= 9; j++){
                    int nextNum = num * 10 + j;
                    if(isPrime(nextNum)) nums.addLast(nextNum);
                }
            }
        }
        for(Integer num : nums){
            System.out.println(num);
        }
    }
}

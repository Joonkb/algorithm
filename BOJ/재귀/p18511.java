package W3;

import java.util.Scanner;

public class p18511 {

    static int nums[];

    public static int go(int target, int sum, int depth, int size) {
        if(sum > target) return sum/10;
        if(depth == size && target >= sum) return sum;
        int cnt = 0;
        for(int i = 0; i < nums.length; i++){
            cnt = Math.max(go(target, sum * 10 + nums[i], depth + 1, size), cnt);
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N = sc.next();
        int size = N.length();
        int k = sc.nextInt();
        nums = new int[k];
        for(int i = 0;  i < k; i++){
            nums[i] = sc.nextInt();
        }
        System.out.println(go(Integer.parseInt(N), 0, 0, N.length()));
    }
}
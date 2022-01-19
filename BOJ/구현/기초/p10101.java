import java.util.Scanner;

public class p10101 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        if(A == 60 && B == 60 && C == 60){
            System.out.println("Equilateral");
        } else if(A + B + C == 180){
            if(A == B || B == C || A == C) System.out.println("Isosceles");
            else System.out.println("Scalene");
        } else{
            System.out.println("Error");
        }
    }
}

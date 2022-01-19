import java.util.Scanner;

public class p2935 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String op = sc.next();
        String B = sc.next();
        if(op.equals("+")){
            if (A.length() == B.length()) {
                System.out.print(2);
                for(int i = 0; i < A.length()-1; i++) {
                    System.out.print("0");
                }
            } else{
                StringBuilder sb1 = A.length() > B.length() ? new StringBuilder(A) : new StringBuilder(B);
                StringBuilder sb2 = A.length() < B.length() ? new StringBuilder(A) : new StringBuilder(B);
                sb1.setCharAt(sb1.length()-sb2.length(), '1');
                System.out.println(sb1.toString());
            }
        }else{
            System.out.print(1);
            for(int i = 0; i < ( A.length() + B.length() - 2); i++){
                System.out.print(0);
            }
        }
    }
}
import java.util.Scanner;

public class p4435 {

    static int[] Gandalf = {1, 2, 3, 3, 4, 10};
    static int[] Sauron = {1, 2, 2, 2, 3, 5, 10};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int number = 1; number <= T; number++){
            int res1 = 0, res2 = 0;
            for (int i = 0; i < 6; i++) {
                int a = sc.nextInt();
                res1 += a * Gandalf[i];
            }
            for (int i = 0; i < 7; i++) {
                int a = sc.nextInt();
                res2 += a * Sauron[i];
            }
            System.out.print("Battle " + number);
            if(res1 > res2){
                System.out.println(": Good triumphs over Evil");
            } else if (res1 == res2) {
                System.out.println(": No victor on this battle field");
            } else{
                System.out.println(": Evil eradicates all trace of Good");
            }
        }
    }
}

/**
 *  π κΈ°μ μ λ§€λ§€λ² π
 *  (κ΅¬νλ¬Έμ  )
 *  3μΌκ°μ κ°κ²©μ΄ νλ½, μ¦κ° νλμ§ νλ¨νλ λΆλΆλ§ μ μ νκ² κ΅¬ννλ©΄ λ¨
 */


import java.util.Scanner;

public class p20546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sMoney = sc.nextInt();
        int jMoney = sMoney;
        int sStock = 0, jStock = 0;
        int days[] = new int[14];
        for (int i = 0; i < 14; i++) {
            days[i] = sc.nextInt();
        }
        for (int i = 0; i < 14; i++) {
            if (jMoney >= days[i]) {
                int buy = (jMoney / days[i]);
                jStock += buy;
                jMoney -= (days[i] * buy);
            }
            // 3μΌ μ°μ κ°κ²©μ΄ μ μΌ λλΉ νλ½ -> μ λ λ§€μ
            boolean ok = true;
            for (int cnt = i; cnt >= i - 2 && i >= 3; cnt--) {
                if (days[cnt] >= days[cnt - 1]) {
                    ok = false;
                    break;
                }
            }
            // μ£Όμ  ν λ§€μ
            if (ok && sMoney >= days[i]) {
                int buy = (sMoney / days[i]);
                sStock += buy;
                sMoney -= (days[i] * buy);
            }
            ok = true;
            // 3μΌ μ°μ κ°κ²©μ΄ μ μΌ λλΉ μμΉ -> μ λ λ§€λ
            for (int cnt = i; cnt >= i - 2 && i >= 3; cnt--) {
                if (days[cnt] <= days[cnt - 1]) {
                    ok = false;
                    break;
                }
            }
            if (ok && sStock >= 1) {
                sMoney += (days[i] * sStock);
                sStock = 0;
            }
        }
        int jProperty = jMoney + jStock * days[13];
        int sProperty = sMoney + sStock * days[13];
        if (jProperty > sProperty) System.out.println("BNP");
        else if (jProperty == sProperty) System.out.println("SAMESAME");
        else System.out.println("TIMING");
    }
}

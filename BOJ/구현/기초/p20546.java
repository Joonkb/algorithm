/**
 *  🐜 기적의 매매법 🐜
 *  (구현문제 )
 *  3일간의 가격이 하락, 증가 했는지 판단하는 부분만 적절하게 구현하면 됨
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
            // 3일 연속 가격이 전일 대비 하락 -> 전량 매수
            boolean ok = true;
            for (int cnt = i; cnt >= i - 2 && i >= 3; cnt--) {
                if (days[cnt] >= days[cnt - 1]) {
                    ok = false;
                    break;
                }
            }
            // 주식  풀 매수
            if (ok && sMoney >= days[i]) {
                int buy = (sMoney / days[i]);
                sStock += buy;
                sMoney -= (days[i] * buy);
            }
            ok = true;
            // 3일 연속 가격이 전일 대비 상승 -> 전량 매도
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

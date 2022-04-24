package W4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p15684 {

    static int N, M, H;
    static List<int[]> picks = new ArrayList<>();
    static boolean[][] Sadari = new boolean[301][301];
    static boolean[][] link;

    // 세로줄에서 아래방향으로 진행했을 때, 몇 번 세로줄로 나오는가?
    public static int seroResult(int sero) {
        for(int garo = 1; garo <= 300; garo++){
            if(Sadari[garo][sero]) sero += 1;
            if(Sadari[garo][sero-1]) sero -= 1;
        }
        return sero;
    }

    // 검증 ( 같은 번호로 출력 ? )
    public static boolean validate(){
        // 사다리 타기 진행
        for(int sero = 1; sero <= N; sero++){
            int result = seroResult(sero);
            if(result != sero) return false;
        }
        return true;
    }
    
    // 정확히 R개를 뽑는 재귀
    public static boolean go(int index, int pick, int r){
        if(pick == r) {
            return validate();
        }
        for(int i = index; i < M; i++){
            boolean ret = false;
            int[] what = picks.get(i);
            int garo = what[0], sero = what[1];
            link[garo][sero] = true;   // 뽑 O
            ret =  go(i + 1, pick + 1, r);
            link[garo][sero] = false;  // 뽑 X
            ret |= go(i + 1, pick , r);
            if(ret) return true;
        }
        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        H = sc.nextInt();

        for(int i = 0; i < M; i++){
            int garo = sc.nextInt();
            int sero = sc.nextInt();
            Sadari[garo][sero] = true;
        }
        for(int garo = 1; garo <= 300; garo++){
            for(int sero = 1; sero < N; sero++){
                if(!Sadari[garo][sero]) picks.add(new int[]{garo, sero});
            }
        }
        int cnt = 0, size = picks.size();
        for(cnt = 0; cnt <= size; cnt++){
            link = new boolean[301][301];
            for(int i = 0; i < 301; i++) System.arraycopy(Sadari, 0, link, 0, Sadari.length);
            if(go(0, 0, cnt)) break;
        }
        System.out.println(cnt);
    }
}
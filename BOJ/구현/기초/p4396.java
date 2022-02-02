/**
 *  지뢰찾기
 *  (구현문제 )
 *  문제에 조건에 따른 구현문제
 *  채점 18% 에서 지속적으로 "틀렸습니다."가 나와 한참 해맸던.. 문제
 *  주어진 문제의 조건을 잘 살피고 정확히 동작이 되는지 살펴야 함!
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p4396 {

    static int dx[] = {-1, 0, 1, 0, -1, -1, 1, 1};
    static int dy[] = {0, 1, 0, -1, -1, 1, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] mine = new String[N];
        String[] map = new String[N];
        int[][] answer = new int[N][N];

        for (int i = 0; i < N; i++) {
            mine[i] = br.readLine();
        }
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine();
        }
        boolean ok = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i].charAt(j) != 'x') continue;
                if (map[i].charAt(j) == 'x' && mine[i].charAt(j) == '*') ok = true;   // 지뢰가 있는 칸이 열린 경우
                int cnt = 0;
                for (int dir = 0; dir < 8; ++dir) {
                    int x = i + dx[dir], y = j + dy[dir];
                    if (0 <= x && x < N && 0 <= y && y < N && mine[x].charAt(y) == '*') cnt++;
                }
                answer[i][j] = cnt;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(mine[i].charAt(j) == '*' && ok) System.out.print("*");
                else if(map[i].charAt(j) == 'x') System.out.print(answer[i][j]);
                else System.out.print(".");
            }
            System.out.println();
        }
    }
}

/**
 *  상어 초등학교
 *  (구현문제 )
 *  추후, 리팩토링 필요
 *  단순하게 주어진 조건에 맞게 반복문과 조건문만을 사용하여 해결함
 */


import java.util.Scanner;

public class p21608 {

    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};
    static int point[] = {0, 1, 10, 100, 1000};
    static int mapper[];

    static boolean isInRange(int x, int y, int N) {
        if (x < 0 || x >= N || y < 0 || y >= N) return false;
        return true;
    }
    static void debug(int[][] arr) {
        int N = arr.length;
        for (int n = 0; n < N; n++) {
            for (int m = 0; m < N; m++) {
                System.out.print(arr[n][m] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int size = N * N;
        int likes[][] = new int[size][5];
        mapper = new int[size + 1];
        for (int i = 0; i < N * N; i++) {
            for (int j = 0; j < 5; j++) {
                likes[i][j] = sc.nextInt();
            }
            mapper[likes[i][0]] = i;
        }
        int[][] position = new int[N][N];
//        debug(position);
        for (int i = 0; i < size; i++) {
            int now = likes[i][0];
            int maxEmpty = 0, maxLike = 0;
            int ax = 22, ay = 22;
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < N; m++) {
                    int empty = 0, like = 0;
                    // 인접한 칸을 검사한다.
                    if (position[n][m] != 0) continue;
                    for (int dir = 0; dir < 4; ++dir) {
                        int nx = n + dx[dir], ny = m + dy[dir];
                        if (isInRange(nx, ny, N)) {
                            if ((position[nx][ny] == likes[i][1] || position[nx][ny] == likes[i][2] ||
                                    position[nx][ny] == likes[i][3] || position[nx][ny] == likes[i][4])) like++;
                            else if (position[nx][ny] == 0) empty++;
                        }
//                        System.out.println("(n, m) : like, empty = " + "( " + n + ", " + m + " ) " + like + " " + empty);
                    }
                    if (maxLike < like) {
                        maxLike = like;
                        maxEmpty = empty;
                        ax = n;
                        ay = m;
                    }else if(like == 0 && empty == 0){
                        if(n <= ax && m <= ay)  {
                            ax = n;
                            ay = m;
                        }
                    }
                    else if (maxLike == like) {
                        if (maxEmpty < empty) {
                            maxEmpty = empty;
                            ax = n;
                            ay = m;
                        }
                    }
                }
            }
            position[ax][ay] = now;
//            debug(position);
        }
        int answer = 0;
        for (int n = 0; n < N; n++) {
            for (int m = 0; m < N; m++) {
                int p = 0;
                for (int dir = 0; dir < 4; ++dir) {
                    int nx = n + dx[dir], ny = m + dy[dir];
                    int i = mapper[position[n][m]];
                    if (isInRange(nx, ny, N) && (position[nx][ny] == likes[i][1] ||
                            position[nx][ny] == likes[i][2] ||
                            position[nx][ny] == likes[i][3] ||
                            position[nx][ny] == likes[i][4]))
                        p++;
                }
                answer += point[p];
            }
        }
        System.out.println(answer);
    }
}
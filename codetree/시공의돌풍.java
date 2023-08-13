package W10;

import java.util.Scanner;

public class 시공의돌풍 {

    private static int N, M, T;
    private static int sigongX1 = -1, sigongX2 = -1;    // 시공의 돌풍이 (x좌표)
    private static int board[][];
    private static final int dx[] = {0,  1,  0, -1};
    private static final int dy[] = {1, 0, -1,  0};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        T = sc.nextInt();

        board = new int[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                board[i][j] = sc.nextInt();
                if(board[i][j] == -1) {
                    if(sigongX1 == -1) sigongX1 = i;
                    else sigongX2 = i;
                }
            }
        }

        while (T-- > 0) {
            // 1. 먼지의 확산
            board = spreadDust();

            // 2.1 반시계 방향으로 청소
            rotateCounterClockWise();

//            printBoard();

            // 2.2 시계 방향으로 청소.
            rotateClockWise();

            printBoard();
        }
        // 3. 먼지의 양 계산하기.
        System.out.println(getAmountDust());
    }

    // 1. 먼지의 확산을 일으킨다.
    private static int[][] spreadDust() {
        int[][] afterSpreadBoard = new int[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(board[i][j] == -1) continue;
                int div = board[i][j] / 5;
                for (int dir = 0; dir < 4; ++dir) {
                    int nx = i + dx[dir];
                    int ny = j + dy[dir];
                    if(!isInRange(nx, ny)) continue;
                    afterSpreadBoard[nx][ny] += div;
                    board[i][j] -= div;
                }
            }
        }
        // 남은 먼지의 양을 옮긴다.
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(board[i][j] == -1) continue;
                afterSpreadBoard[i][j] += board[i][j];
            }
        }
        return afterSpreadBoard;
    }

    // 현재 칸의 상하좌우의 좌표가 범위내의 값인지 판단한다.
    private static boolean isInRange(int x, int y) {
        if (0 > x || x >= N || 0 > y || y >= M || board[x][y] == -1) return false;
        return true;
    }

    // 시계 방향으로 회전
    private static void rotateClockWise() {
        int sx = sigongX2, sy = 0;

        // 0 -> 1 -> 2 -> 3
        int sDx = 0;
        for (int dir = 0; dir < 4; ++dir) {
            int d = (sDx + dir) % 4;
            int nx = sx + dx[d];
            int ny = sy + dy[d];
            while (!isInRange(nx, ny) || board[nx][ny] != -1) {
                if(board[sx][sy] == -1)  break;
                board[sx][sy] = board[nx][ny];
                sx = nx; sy = ny;
                nx += dx[d]; ny += dy[d];
            }
        }
    }
    
    // 반시계 방향으로 회전
    private static void rotateCounterClockWise() {
        int sx = sigongX1, sy = 0;
        // 3 -> 0 -> 1 -> 2
        int sDx = 3;
        for (int dir = 0; dir < 4; ++dir) {
            int d = (sDx + dir) % 4;
            int nx = sx + dx[d];
            int ny = sy + dy[d];
            while (isInRange(nx, ny) && board[nx][ny] != -1) {
//                System.out.println("sx, sy  = "  + sx + " " + sy);
//                System.out.println("nx, ny  = "  + nx + " " + ny);
                if(board[sx][sy] == -1)  break;
                board[sx][sy] = board[nx][ny];
                sx += dx[d]; sy += dy[d];
                nx += dx[d]; ny += dy[d];
            }
        }
    }

    // 3. 보드내의 먼지의 총량을 계산한다.
    private static int getAmountDust() {
        int sum = 0;
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == -1) continue;
                sum += board[i][j];
            }
        }
        return sum;
    }

    private static void printBoard() {
        System.out.println("!@# printBoard START #@!");
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(board[i][j]+ " ");
            }
            System.out.println();
        }
        System.out.println("!@# printBoard END  #@!");
    }
}
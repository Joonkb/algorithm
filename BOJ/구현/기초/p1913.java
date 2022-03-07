import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class p1913 {

    static int N, what;
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1};

    public static boolean isInRange(int x, int y) {
        if (0 > x || x >= N || 0 > y || y >= N) return false;
        return true;
    }

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = sc.nextInt();
        what = sc.nextInt();
        int[][] board = new int[N][N];

        int x = 0, y = 0, num = N * N, dir = 0;
        int cx = 0, cy = 0;
        while (isInRange(x, y) && board[x][y] == 0) {
            board[x][y] = num--;
            int nx = x + dx[dir], ny = y + dy[dir];
            while (isInRange(nx, ny) && board[nx][ny] == 0) {
                x = nx;
                y = ny;
                board[nx][ny] = num--;
                nx += dx[dir];
                ny += dy[dir];
            }
            dir = (dir + 1) % 4;
            x += dx[dir];
            y += dy[dir];
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                bw.write(board[i][j] +" ");
                if(board[i][j] == what){
                    cx = i + 1;
                    cy = j + 1;
                }
            }
            bw.write("\n");
        }
        bw.write(cx + " " + cy + "\n");
        bw.flush();
    }
}
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p7562 {

    static int N;
    static int board[][] = new int[300][300];
    static int dx[] = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int dy[] = {1, 2, 2, 1, -1, -2, -2, -1};

    public static boolean isInRange(int x, int y) {
        if(0 > x || x >= N || 0 > y || y >= N) return false;
        return true;
    }

    public static void init(){
        for(int i = 0; i < 300; i++){
            for(int j = 0; j < 300; j++){
                board[i][j] = -1;
            }
        }
    }

    public static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        board[x][y] = 0;
        while(!q.isEmpty()) {
            int cx = q.peek()[0], cy = q.peek()[1];
            q.poll();
            for(int dir = 0; dir < 8; ++dir) {
                int nx = cx + dx[dir], ny = cy + dy[dir];
                if(isInRange(nx, ny) && board[nx][ny] == -1){
                    q.offer(new int[]{nx, ny});
                    board[nx][ny] = board[cx][cy] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 0; t < T; t++){
            N = sc.nextInt();
            int sx = sc.nextInt();
            int sy = sc.nextInt();
            int ex = sc.nextInt();
            int ey = sc.nextInt();
            init();
            bfs(sx, sy);
            System.out.println(board[ex][ey]);
        }
    }
}
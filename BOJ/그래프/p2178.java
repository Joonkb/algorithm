import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair{
    Integer x, y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class p2178 {
    static int n, m;
    static int[][] dist;
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};
    static String[] board;

    static boolean isInRange(int x, int y){
        if(0 > x || x >= n || 0 > y || y >= m) return false;
        return true;
    }

    static void calc() {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, 0));
        dist[0][0] = 1;
        while (!queue.isEmpty()) {
            int x = queue.peek().x, y = queue.peek().y;
            queue.remove();
            for(int dir = 0; dir < 4; ++dir){
                int nx = x + dx[dir], ny = y + dy[dir];
                if(isInRange(nx, ny) && board[nx].charAt(ny) == '1' && dist[nx][ny] == -1){
                    dist[nx][ny] = dist[x][y] + 1;
                    queue.add(new Pair(nx, ny));
                }
            }

        }
    }

    static void init(){
        board = new String[n];
        dist = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                dist[i][j] = -1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        init();
        for(int i = 0; i < n; i++) {
            board[i] = sc.next();
        }
        calc();
        System.out.println(dist[n - 1][m - 1]);
    }
}
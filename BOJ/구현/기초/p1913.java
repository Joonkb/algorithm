import java.util.Scanner;

public class p1913 {

    static int[] dx = {0, 1,  0,  -1};
    static int[] dy = {1, 0, -1,   0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int findNum = sc.nextInt();

        int arr[][] = new int[N][N];
        int cx = (N - 1) / 2,  ax = 0;
        int cy = (N - 1) / 2,  ay = 0;
        int num = 1;
        arr[cx][cy] = num;
        cx--;

        for (int cnt = 1; cnt <= N / 2; ++cnt) {
            for (int dir = 0; dir < 4; ++dir) {
                for (int w = 0; w < cnt * 2; w++) {
                    System.out.println("cx,  cy = " + cx+ " " + cy);
                    arr[cx][cy] = ++num;
                    if (num == findNum) {
                        ax = cx + 1;
                        ay = cy + 1;
                    }
                    cx += dx[dir];
                    cy += dy[dir];
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.println(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(ax + " " + ay);
    }
}
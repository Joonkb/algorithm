import java.util.Scanner;

public class p10994 {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (N == 1) {
            System.out.println("*");
        } else {
            int cx = 2 * (N - 1), cy = 2 * (N - 1);
            int r = 4 * (N - 1) + 1;
            char[][] stars = new char[r][r];
            stars[cx][cy] = '*';
            for (int i = 2; i <= N; i++) {
                cx -= 2;
                cy -= 2;
                for (int dir = 0; dir < 4; ++dir) {
                    for (int star = 1; star <= 4 * (i - 1); ++star) {
                        stars[cx][cy] = '*';
                        cx += dx[dir];
                        cy += dy[dir];
                    }
                }
            }
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < r; j++) {
                    if (stars[i][j] != '*') System.out.print(' ');
                    else System.out.print(stars[i][j]);
                }
                System.out.println();
            }
        }
    }
}

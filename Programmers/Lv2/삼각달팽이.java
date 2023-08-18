package W11;

public class 삼각달팽이 {

    private static int N;
    private static int dx[] = {1, 0, -1};
    private static int dy[] = {0, 1, -1};

    public static int[] solution(int n) {

        int[][] tempArr = new int[n][n];
        int num = 1, sx = 0, sy = 0, dir = 0;
        int lastNum = n * (n + 1) / 2;

        while (num != lastNum) {
            while (isInRange(sx, sy, n, tempArr)) {
                tempArr[sx][sy] = num++;
                sx += dx[dir]; sy += dy[dir];
            }
            sx -= dx[dir]; sy -= dy[dir];
            dir += 1; dir %= 3;
        }
        return getAnswerArr(tempArr, n);
    }

    // false를 return 하는 경우 방향을 전환.
    private static boolean isInRange(int x, int y, int n, int[][] board) {
        if( 0 > x || x >= n || 0 > y || y >= n || board[x][y] != 0) return false;
        return true;
    }

    // result[] 배열을 생성하여 반환.
    private static int[] getAnswerArr(int[][] source, int n) {
        int cnt = 0;
        int[] result = new int[n * (n + 1) / 2];
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                result[cnt++] = source[i][j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int cnt[] = solution(3);
        for (int num : cnt) {
            System.out.print(num + " ");
        }
    }
}

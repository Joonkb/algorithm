package W11;

public class 삼각달팽이 {

    private static int N;
    private static int dx[] = {1, 0, -1};
    private static int dy[] = {0, 1, -1};

    public static int[] solution(int n) {

        int[][] tempArr = new int[n][n];
        int num = 1, sx = -1, sy = 0, dir = 0;
        int lastNum = n * (n + 1) / 2;

        System.out.println("!@#$ n = " + n);
        System.out.println("!@#$ lastNum = " + lastNum);

        while (num != (lastNum + 1)) {
            System.out.println("!@#$ num = " + num);
            printArr(tempArr, n);
            sx += dx[dir]; sy += dy[dir];
            while (isInRange(sx, sy, n, tempArr)) {
                tempArr[sx][sy] = num++;
                printArr(tempArr, n);
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
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i + 1; j++) {
                result[cnt++] = source[i][j];
            }
        }
        return result;
    }

    private static void printArr(int[][] temp, int n) {
        System.out.println();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(temp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // TestCase # (n=4)
        int cnt[] = solution(4);
        for (int num : cnt) {
            System.out.print(num + " ");
        }
    }
}

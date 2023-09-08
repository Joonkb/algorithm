package W11;

public class 행렬의곱셈 {
    public static int[][] solution(int[][] arr1, int[][] arr2) {

        // 행렬1의 세로, 가로 길이
        int a1H = arr1.length;
        int a1W = arr1[0].length;

        // 행렬2의 세로, 가로 길이
        int a2H = arr2.length;
        int a2W = arr2[0].length;

        int[][] answer = new int[a1H][a2W];

        for (int x = 0; x < a1H; x++) {
            for (int y = 0; y < a2W; y++) {
                int sum = 0;
                for (int k = 0; k < a1W; k++) {
                    sum += (arr1[x][k] * arr2[k][y]);
                }
                answer[x][y] = sum;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        int arr1[][] = new int[][]{{1, 4}, {3, 2}, {4,1}};
        int arr2[][] = new int[][] {{3, 3}, {3, 3}};
        int answer[][] = solution(arr1, arr2);
    }
}

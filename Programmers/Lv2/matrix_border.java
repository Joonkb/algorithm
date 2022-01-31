/**
 * @author: ByeongJoon Kim
 * @Judge_site: programmers
 * @level: 2
 * @prob_name: 행렬 테두기 회전하기
 * @prob_url: https://programmers.co.kr/learn/courses/30/lessons/77485
 *
 *  배열의 회전 구현하기
 */

class Solution {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int ans = 0;

    public void debug(int[][] arr){
        int rows = arr.length;
        int cols = arr[0].length;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] rotate(int[] query, int[][] arr) {
        int lowNum = Integer.MAX_VALUE;
        int x1 = query[0]-1;
        int y1 = query[1]-1;
        int x2 = query[2]-1;
        int y2 = query[3]-1;
        int n = x2 - x1;
        int m = y2 - y1;

        int[][] copyArr = new int[arr.length][arr[0].length];
        for(int i=0; i<copyArr.length; i++){
            System.arraycopy(arr[i], 0, copyArr[i], 0, arr[0].length);
        }
        for(int dir = 0; dir < 4; ++dir) {
            int how = dir%2 == 0 ? m : n;
            for(int go = 0; go < how; ++go) {
                lowNum = Math.min(lowNum, arr[x1][y1]);
                copyArr[x1 + dx[dir]][y1 + dy[dir]] = arr[x1][y1];
                x1 += dx[dir];
                y1 += dy[dir];
            }
        }
        // debug(arr);
        ans = lowNum;
        return copyArr;
    }

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int cnt = 0;
        int arr[][] = new int[rows][columns];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                arr[i][j] = ++cnt;
            }
        }
        for(int query = 0; query < queries.length; ++query){
            arr = rotate(queries[query], arr);
            answer[query] = ans;
        }
        return answer;
    }
}
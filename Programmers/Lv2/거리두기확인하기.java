package W11;

public class 거리두기확인하기 {

    private static final int dx[] = {-1, 0, 1, 0};
    private static final int dy[] = {0, 1, 0, -1};
    
    // 대각선용 방향벡터
    private static final int dDx[] = {-1, 1, 1 , -1};
    private static final int dDy[] = {1, 1 , -1, -1};

    public static int[] solution(String[][] places) {

        places = new String[][]
                  {{"POOOP", "OXXOX", "OPXPX", "PXXOX", "XPXXP"},
                  {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                  {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                  {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                  {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};

        int answer[] = new int[5];
        for (int i = 0; i < 5; i++) {
            System.out.println("waiting Number = " + (i + 1));
            answer[i] = checkWaitingRoom(places[i]);
            System.out.println("answer[i] = " + i  + " "+ answer[i]);
        }
        return answer;
    }

    // 하나의 대기실을 입력받아 거리두기를 지키는지 여부를 판단한다.
    // return = 1 : 모든 응시자가 거리두기를 지키고 있음.
    private static int checkWaitingRoom(String[] room) {

        // String[] --> int[][] 변환하여 계산
        int[][] waitingRoom = convertStrArrToIntArr(room);
        printArr(waitingRoom);

        // 각각의 응시자 위치에서 거리두기 판단.
        for(int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (waitingRoom[i][j] != 2) continue;

                // 맨해튼거리=1 사람이 있는지 판단.
                if(!hasPeopleWithinOneDist(waitingRoom, i, j)) return 0;

                // 직선거리=2 파티션없이 사람이 있는지 판단
                if(!hasPeopleStraightDistTwo(waitingRoom, i, j)) return 0;

                // 맨해튼거리=2 파티션없이 사람이 있는지 판단
                if(!hasPeopleManhattanDistThree(waitingRoom, i, j)) return 0;
            }
        }
        return 1;
    }

    // 1. 인접한(맨해튼거리=1) 위치의 사람을 확인한다. check
    // false -> 응시자가 인접해 있음, true --> 응시자가 없음
    private static boolean hasPeopleWithinOneDist(int[][] places, int x, int y) {

        for (int dir = 0; dir < 4; ++dir) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (isInRange(nx, ny) && places[nx][ny] == 2) {
                System.out.println("거리두기확인하기.hasPeopleWithinOneDist START");
                System.out.println("(nx, ny) = ( " + nx + ", " + ny + " )");
                return false;
            }
        }
        return true;
    }

    // 2. 직선거리=2에 파티션없이 위치의 사람을 확인한다.
    private static boolean hasPeopleStraightDistTwo(int[][] places, int x, int y) {

        for (int dir = 0; dir < 4; ++dir) {
            int nx = x + 2 * dx[dir];
            int ny = y + 2 * dy[dir];
            if (isInRange(nx, ny)
                    && places[nx][ny] == 2
                    && places[x + dx[dir]][(y + dy[dir])] != 0) {
                System.out.println("거리두기확인하기.hasPeopleStraightDistTwo START");
                System.out.println("(nx, ny) = ( " + nx + ", " + ny + " )");
                return false;
            }
        }
        return true;
    }

    // 3. 맨해튼거리=2, 파티션없이 응시자가 존재하는지 판단.
    private static boolean hasPeopleManhattanDistThree(int[][] places, int x, int y) {

        for (int dir = 0; dir < 4; ++dir) {
            int nx = x + dDx[dir];
            int ny = y + dDy[dir];

            if(isInRange(nx, ny)
                && places[nx][ny] == 2
                && places[x + dx[dir]][y + dy[dir]] != 0
                && places[x + dx[(dir + 1) % 4]][y + dy[ (dir + 1) % 4 ]] != 0) {
                System.out.println("거리두기확인하기.hasPeopleManhattanDistThree Point");
                System.out.println("(nx, ny) = ( " + nx + ", " + ny + " )");
                return false;
            }
        }
        return true;
    }

    // 범위내인지 확인한다.
    private static boolean isInRange(int x, int y) {
        if (0 > x || x >= 5 || 0 > y || y >= 5) {
            return false;
        }
        return true;
    }

    /**
     * 문자열 배열(String[])을 계산에 용이하도록 int[][] 배열로 반환.
     * P  = 2, O  = 1, X  = 0
     * @param strArr
     * @return int[][]
     */
    private static int[][] convertStrArrToIntArr(String[] strArr) {
        int[][] arr = new int[5][5];
        for(int i = 0; i < 5; i++) {
            String line = strArr[i];
            for(int j = 0; j < 5; j++){
                if (line.charAt(j) == 'P') {
                    arr[i][j] = 2;
                } else if (line.charAt(j) == 'O') {
                    arr[i][j] = 1;
                }
            }
        }
        return arr;
    }

    private static void printArr(int[][] arr) {
        System.out.println();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        solution(null);
    }
}
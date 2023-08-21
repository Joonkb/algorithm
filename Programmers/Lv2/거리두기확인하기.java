package W11;

public class 거리두기확인하기 {

    private static final int dx[] = {-1, 0, 1, 0};
    private static final int dy[] = {0, 1, 0, -1};

    public static int[] solution(String[][] places) {

        int answer[] = new int[places.length];
        for (String[] place : places) {
            boolean isOk = false;

        }
        return answer;
    }

    private int checkWaitingRoom(String[] room) {
        int n = room.length;

        for (String line : room) {
            for (char what : line.toCharArray()) {
                // x, y 를 쓰도록 수정필요
            }
        }
        return 0;
    }

    // 1. 인접한(맨해튼거리=1) 위치의 사람을 확인한다.
    // false -> 응시자가 인접해 있음, true --> 응시자가 없음
    private boolean withinOneDistCheck(String[] places, int x, int y) {
        for (int dir = 0; dir < 4; ++dir) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (!isInRange(nx, ny, places.length) && places[nx].indexOf(ny) == 'P') {
                return false;
            }
        }
        return true;
    }

    // 2. 직선거리=2 위치의 사람을 확인한다.
    private boolean withinTwoStraightDistCheck(String[] places, int x, int y) {
        for (int dir = 0; dir < 4; ++dir) {
            int nx = x + 2 * dx[dir];
            int ny = y + 2 * dy[dir];
            if (!isInRange(nx, ny, places.length)
                    && places[nx].indexOf(ny) == 'P'
                    && places[x + dx[dir]].indexOf(y + dy[dir]) != 'X') {
                return false;
            }
        }
        return true;
    }

    // 범위내인지 확인한다.
    private boolean isInRange(int x, int y, int n) {
        if (0 > x || x >= n || 0 > y || y >= n) {
            return false;
        }
        return true;
    }
}

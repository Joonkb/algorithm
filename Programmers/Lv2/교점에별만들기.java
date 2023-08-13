package W10;

import java.util.HashSet;
import java.util.Set;

class Point {
    long x, y;
    Point(long x, long y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Point)) return false;
        Point p = (Point) o;
        return (y == p.y && x == p.x);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

class Line {
    long A, B, C;
    public Line(long a, long b, long c) {
        this.A = a;
        this.B = b;
        this.C = c;
    }

    // 두 직선이 평행 혹은 일치하는 직선인지 판단하는 메서드
    private boolean isSameOrParallelLine(Line other) {
        long res = A * other.B - B * other.A;
        return res == 0;
    }

    // 두 직선사이의 교점을 찾아 반환하는 메서드
    public Point findInterSectionWithLines(Line other) {
        if(isSameOrParallelLine(other)) return null; // 교점이 존재하지 않음

        long div = A * other.B - B * other.A;
        double x = (double) (B * other.C - C * other.B) / (double) div;
        double y = (double) (C * other.A - A * other.C) / (double) div;

        if(y % 1 != 0 || x % 1 != 0) return null;

        return new Point((int) x, (int) y);
    }
}

public class 교점에별만들기 {

    public static String[] solution(int[][] lin0) {

        int[][] line = {{2, -1, 4},
                        {-2, -1, 4},
                        {0, -1, 1},
                        {5, -8, -12},
                        {5, 8, 12}};

        long maxX = Long.MIN_VALUE, maxY = Long.MIN_VALUE;
        long minX = Long.MAX_VALUE, minY = Long.MAX_VALUE;

        Set<Point> set = new HashSet<>();

        for(int i = 0; i < line.length; i++) {
            for(int j = 0; j < line.length; j++) {
                Line line1 = new Line(line[i][0], line[i][1], line[i][2]);
                Line line2 = new Line(line[j][0], line[j][1], line[j][2]);
                Point intersection = line1.findInterSectionWithLines(line2);
                if (intersection != null) {
                    set.add(intersection);
                    maxX = Math.max(maxX, intersection.x);
                    maxY = Math.max(maxY, intersection.y);
                    minX = Math.min(minX, intersection.x);
                    minY = Math.min(minY, intersection.y);
                    System.out.println("intersection = " + intersection);
                }
            }
        }
        // 모든 별을 포함하는 최소한의 크기로 표현할 것.
        int width  = (int)(maxX - minX + 1);
        int height = (int)(maxY - minY + 1);
        char board[][] = initBoard((int)height, (int)width);

        System.out.println("width = " + width);
        System.out.println("height = " + height);

        String[] answer = new String[height];

        // 가로 세로 높이를 계산한다.
        for (Point p : set) {
            System.out.println("p = " + p);
            long x = p.x;
            long y = p.y;
            System.out.println("x - minY = " + (x - minX));
            System.out.println("y - minY = " + (y - minY));
            board[(int)(y - minY)][(int)(x - minX)] = '*';
        }
        int cnt = 0;
        for(int i = height - 1; i >= 0 ; i--){
            answer[cnt++] = String.valueOf(board[i]);
        }
        return answer;
    }

    private static char[][] initBoard(int width, int height) {
        char[][] board = new char[width][height];
        for(int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                board[i][j] = '.';
            }
        }
        return board;
    }
    public static void main(String[] args) {
        solution(new int[][]{{3, 2}});
    }
}
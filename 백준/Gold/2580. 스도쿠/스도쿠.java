import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        int i;
        int j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    static int[][] sudoku;
    static List<Point> emptyPoint = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sudoku = new int[9][9];

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = Integer.parseInt(st.nextToken());
                if (sudoku[i][j] == 0) emptyPoint.add(new Point(i, j));
            }
        }

        setSudoku(0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(sudoku[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static boolean setSudoku(int cnt) {
        if (cnt == emptyPoint.size()) {
            return true;
        } else {
            Point p = emptyPoint.get(cnt);
            int i = p.i;
            int j = p.j;
            for (int k = 1; k < 10; k++) {
                if (canRemove(i, j, k)) {
                    sudoku[i][j] = k;
                    if (setSudoku(cnt + 1)) return true;
                    else sudoku[i][j] = 0;
                }
            }
        }
        return false;
    }

    private static boolean canRemove(int i, int j, int value) {
        // check 가로줄
        for (int k = 0; k < 9; k++) {
            if (sudoku[i][k] == value) return false;
        }

        // check 세로줄
        for (int k = 0; k < 9; k++) {
            if (sudoku[k][j] == value) return false;
        }

        //check 3x3
        int sI = (i / 3) * 3, sJ = (j / 3) * 3;
        for (int k = sI; k < sI + 3; k++) {
            for (int l = sJ; l < sJ + 3; l++) {
                if (sudoku[k][l] == value) return false;
            }
        }
        return true;
    }
}
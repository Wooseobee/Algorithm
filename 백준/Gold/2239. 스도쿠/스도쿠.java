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

    static int[][] sudoku = new int[9][9];
    static List<Point> emptyPoint = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = Integer.parseInt(input[j]);
                if (sudoku[i][j] == 0) emptyPoint.add(new Point(i, j));
            }
        }

        setSudoku(0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(sudoku[i][j]);
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
            for (int k = 1; k <= 9; k++) {
                if (canSetNum(i, j, k)) {
                    sudoku[i][j] = k;
                    if (setSudoku(cnt + 1)) {
                        return true;
                    } else {
                        sudoku[i][j] = 0;
                    }
                }
            }
        }
        return false;
    }

    private static boolean canSetNum(int i, int j, int num) {
        for (int k = 0; k < 9; k++) {
            if (sudoku[i][k] == num) return false;
        }
        for (int k = 0; k < 9; k++) {
            if (sudoku[k][j] == num) return false;
        }

        i = i / 3 * 3;
        j = j / 3 * 3;
        for (int k = i; k < i + 3; k++) {
            for (int l = j; l < j + 3; l++) {
                if (sudoku[k][l]==num) return false;
            }
        }

        return true;
    }
}
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        char[][] puzzle = new char[r][c];

        for (int i = 0; i < r; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < c; j++) {
                puzzle[i][j] = input[j].charAt(0);
            }
        }

        System.out.println(search(r, c, puzzle));

        br.close();
    }

    private static String search(int r, int c, char[][] puzzle) {
        String min = "zzzzzzzzzzzzzzzzzzzz";
        for (int i = 0; i < r; i++) {
            String word = "";
            for (int j = 0; j < c; j++) {
                if (puzzle[i][j] != '#') {
                    word += String.valueOf(puzzle[i][j]);
                } else {
                    if (word.length() >= 2 && word.compareTo(min) < 0) {
                        min = word;
                    }
                    word = "";
                }
            }
            if (word.length() >= 2 && word.compareTo(min) < 0) {
                min = word;
            }
        }
        for (int i = 0; i < c; i++) {
            String word = "";
            for (int j = 0; j < r; j++) {
                if (puzzle[j][i] != '#') {
                    word += String.valueOf(puzzle[j][i]);
                } else {
                    if (word.length() >= 2 && word.compareTo(min) < 0) {
                        min = word;
                    }
                    word = "";
                }
            }
            if (word.length() >= 2 && word.compareTo(min) < 0) {
                min = word;
            }
        }
        return min;
    }
}
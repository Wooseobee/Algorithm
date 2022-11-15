import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String board = br.readLine();

        int cnt = board.length();

        board = board.replace("XXXX", "AAAA");
        board = board.replace("XX", "BB");
        if (board.contains("X")) {
            System.out.println(-1);
        } else {
            System.out.println(board);
        }

        br.close();
    }
}
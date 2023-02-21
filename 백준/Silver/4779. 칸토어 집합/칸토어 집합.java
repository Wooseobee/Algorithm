import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static char[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s;
        while ((s = br.readLine()) != null && !s.isEmpty()) {
            int n = Integer.parseInt(s);
            arr = new char[(int) Math.pow(3, n)];

            Arrays.fill(arr, ' ');

            Cantor(0, (int) Math.pow(3, n), (int) Math.pow(3, n));
            printCantor(arr);
        }
        System.out.println(sb);
        br.close();
    }

    private static void printCantor(char[] arr) {
        for (char c : arr) {
            sb.append(c);
        }
        sb.append("\n");
    }

    static void Cantor(int i, int j, int size) {
        if (size == 1) {
            arr[i] = '-';
            return;
        }
        Cantor(i, i + size / 3, size / 3);
        Cantor(j - size / 3, j, size / 3);
    }
}
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        String[] num = input.replaceAll("[-+]", " ").split(" ");
        String[] op = input.replaceAll("[0-9]", "").split("");

        int min = Integer.parseInt(num[0]);
        int sum = 0;
        boolean minus = false;
        for (int i = 1; i < num.length; i++) {
            if (minus) {
                if (op[i - 1].equals("-")) {
                    min -= sum;
                    sum = Integer.parseInt(num[i]);
                } else {
                    sum += Integer.parseInt(num[i]);
                }
            } else {
                if (op[i - 1].equals("-")) {
                    sum += Integer.parseInt(num[i]);
                    minus = true;
                } else {
                    min += Integer.parseInt(num[i]);
                }
            }
        }
        if (minus) {
            min -= sum;
        }

        System.out.println(min);
        br.close();
    }
}
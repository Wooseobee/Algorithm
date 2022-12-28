import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int[] arr = new int[26];
        int max = Integer.MIN_VALUE;
        char ch = '?';

        for (int i = 0; i < s.length(); i++) {
            if ('a' <= s.charAt(i) && s.charAt(i) <= 'z') {
                arr[s.charAt(i) - 'a']++;
            } else {
                arr[s.charAt(i) - 'A']++;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (arr[i] > max) {
                max = arr[i];
                ch = (char) ('A' + i);
            } else if (arr[i] == max) {
                ch = '?';
            }
        }
        System.out.println(ch);
        br.close();
    }
}
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] people = new int[n];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            people[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(people);

        int sum = 0;
        int time = 0;
        for (int i = 0; i < n; i++) {
            sum += (time + people[i]);
            time += people[i];
        }

        System.out.println(sum);
        br.close();
    }
}
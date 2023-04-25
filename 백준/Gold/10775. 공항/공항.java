import java.io.*;
import java.util.*;

public class Main {
    static int G,P;
    static boolean[] airplane;
    static int[] gate = new int[100_001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        G = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine());
        airplane = new boolean[G + 1];
        int max = 0;
        boolean finished = false;
        Arrays.fill(gate, -1);

        for (int i = 1; i <= P; i++) {
            int g = Integer.parseInt(br.readLine());
            if (finished) continue;
            int tmp = gate[g];
            if (tmp == -1) {
                tmp = g;
            }
            while (airplane[tmp]){
                tmp--;
            }
            if (tmp > 0) {
                airplane[tmp] = true;
                gate[g] = tmp - 1;
            } else {
                finished = true;
            }
            if (finished) {
                max = i - 1;
            } else {
                max = i;
            }
        }
        System.out.println(max);
        br.close();
    }
}
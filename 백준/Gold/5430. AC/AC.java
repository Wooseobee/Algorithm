import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static Queue<Character> funcQueue = new LinkedList<>();
    static List<Integer> arrList = new ArrayList<>();
    static boolean isFront;

    public static void main(String[] args) throws IOException {

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String p = br.readLine();
            isFront = true;

            for (int j = 0; j < p.length(); j++) {
                funcQueue.add(p.charAt(j));
            }

            int n = Integer.parseInt(br.readLine());

            String[] input = br.readLine().replace("[", "").replace("]", "").split(",");
            for (int j = 0; j < n; j++) {
                arrList.add(Integer.parseInt(input[j]));
            }

            function();

            funcQueue.clear();
            arrList.clear();
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void function() throws IOException {
        while (!funcQueue.isEmpty()) {
            char func = funcQueue.poll();
            switch (func) {
                case 'R':
                    isFront = !isFront;
                    break;
                case 'D':
                    if (arrList.isEmpty()) {
                        bw.write("error\n");
                        return;
                    }
                    if (isFront) {
                        arrList.remove(0);
                    } else {
                        arrList.remove(arrList.size() - 1);
                    }
                    break;
            }
        }

        if (!isFront) {
            Collections.reverse(arrList);
        }
        bw.write(arrList.toString().replace(", ", ",") + "\n");
    }
}
import java.io.*;
import java.util.*;

public class Main {
    private static class Point {
        int i;
        int j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Point> keyboard = new HashMap<>();
        setKeyboard(keyboard);

        StringTokenizer st = new StringTokenizer(br.readLine());
        String sl = st.nextToken();
        String sr = st.nextToken();

        String[] str = br.readLine().split("");

        int time = 0;
        for (String s : str) {
            Point left = keyboard.get(sl);
            Point right = keyboard.get(sr);
            Point target = keyboard.get(s);

            int leftTime = Math.abs(left.i - target.i) + Math.abs(left.j - target.j);
            int rightTime = Math.abs(right.i - target.i) + Math.abs(right.j - target.j);

            switch (target.i){
                case 0:
                case 1:
                    if (target.j <= 4) {
                        time += leftTime;
                        sl = s;
                    } else {
                        time += rightTime;
                        sr = s;
                    }
                    break;
                case 2:
                    if (target.j <= 3) {
                        time += leftTime;
                        sl = s;
                    } else {
                        time += rightTime;
                        sr = s;
                    }
                    break;
            }
            time++;
        }

        System.out.println(time);
        br.close();
    }

    private static void setKeyboard(HashMap<String, Point> keyboard) {
        keyboard.put("q", new Point(0, 0));
        keyboard.put("w", new Point(0, 1));
        keyboard.put("e", new Point(0, 2));
        keyboard.put("r", new Point(0, 3));
        keyboard.put("t", new Point(0, 4));
        keyboard.put("y", new Point(0, 5));
        keyboard.put("u", new Point(0, 6));
        keyboard.put("i", new Point(0, 7));
        keyboard.put("o", new Point(0, 8));
        keyboard.put("p", new Point(0, 9));
        keyboard.put("a", new Point(1, 0));
        keyboard.put("s", new Point(1, 1));
        keyboard.put("d", new Point(1, 2));
        keyboard.put("f", new Point(1, 3));
        keyboard.put("g", new Point(1, 4));
        keyboard.put("h", new Point(1, 5));
        keyboard.put("j", new Point(1, 6));
        keyboard.put("k", new Point(1, 7));
        keyboard.put("l", new Point(1, 8));
        keyboard.put("z", new Point(2, 0));
        keyboard.put("x", new Point(2, 1));
        keyboard.put("c", new Point(2, 2));
        keyboard.put("v", new Point(2, 3));
        keyboard.put("b", new Point(2, 4));
        keyboard.put("n", new Point(2, 5));
        keyboard.put("m", new Point(2, 6));
    }
}
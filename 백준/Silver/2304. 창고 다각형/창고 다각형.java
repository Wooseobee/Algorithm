import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Pillar {
        int x;
        int y;

        public Pillar(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Pillar> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");

            int l = Integer.parseInt(s[0]);
            int h = Integer.parseInt(s[1]);

            list.add(new Pillar(l, h));
        }

        Collections.sort(list, new Comparator<Pillar>() {
            @Override
            public int compare(Pillar o1, Pillar o2) {
                return o1.x - o2.x;
            }
        });

        int sum = 0;
        int maxX = 0;

        Pillar maxPillar = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            Pillar curPillar = list.get(i);

            if (curPillar.y >= maxPillar.y) {
                sum += (curPillar.x - maxPillar.x) * maxPillar.y;
                maxPillar = curPillar;
                maxX = i;
            }
        }

        maxPillar = list.get(list.size() - 1);
        for (int i = list.size() - 1; i >= maxX; i--) {
            Pillar curPillar = list.get(i);

            if (curPillar.y >= maxPillar.y) {
                sum += (maxPillar.x - curPillar.x) * maxPillar.y;
                maxPillar = curPillar;
            }
        }

        sum += list.get(maxX).y;
        System.out.println(sum);
    }
}
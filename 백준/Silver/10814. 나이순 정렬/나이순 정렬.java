import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    static class Member {
        int age;
        String name;
        int idx;

        public Member(int age, String name, int idx) {
            this.age = age;
            this.name = name;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Member> pq = new PriorityQueue<>(new Comparator<Member>() {
            @Override
            public int compare(Member o1, Member o2) {
                if (o1.age == o2.age) {
                    return o1.idx - o2.idx;
                }
                return o1.age - o2.age;
            }
        });

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");

            pq.add(new Member(Integer.parseInt(input[0]), input[1], i));
        }

        for (int i = 0; i < n; i++) {
            Member member = pq.poll();
            bw.write(member.age + " " + member.name + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
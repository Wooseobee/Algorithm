import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static ArrayList<Integer>[] list;
    static boolean visit[];
    static String flag[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        list = new ArrayList[N];
        visit = new boolean[N+1];
        flag = new String[N+1];

        for (int i = 0; i < N; i++) {
            String s[] = br.readLine().split(" ");

            String s1 = s[0];
            String s2 = s[1];
            String s3 = s[2];

            int index = s1.charAt(0) - 65;
            int left = s2.charAt(0) - 65;
            int right = s3.charAt(0) - 65;

            list[index] = new ArrayList<>();
            flag[index] = "no";

            if (!s2.equals(".")) {
                list[index].add(left);
                flag[index] = "left";
            }
            if (!s3.equals(".")) {
                list[index].add(right);
                if (flag[index].equals("left")) {
                    flag[index] = "both";
                } else{
                    flag[index] = "right";
                }
            }
        }

        br.close();

        preorder(sb, 0);
        System.out.println(sb);
        sb.setLength(0);

        inorder(sb, 0);
        System.out.println(sb);
        sb.setLength(0);

        postorder(sb, 0);
        System.out.println(sb);
    }

    private static void preorder(StringBuilder sb, int index) {
        sb.append((char)(index+65));
        visit[index] = true;
        for (int i : list[index]) {
            if (!visit[i]) {
                preorder(sb, i);
            }
        }
    }
    private static void inorder(StringBuilder sb, int index) {
        if (flag[index].equals("left")||flag[index].equals("both")) {
            inorder(sb, list[index].get(0));
        }
        sb.append((char) (index + 65));
        if (flag[index].equals("both")) {
            inorder(sb, list[index].get(1));
        } else if (flag[index].equals("right")) {
            inorder(sb, list[index].get(0));
        }
    }
    private static void postorder(StringBuilder sb, int index) {
        for (int i: list[index]) {
            postorder(sb, i);
        }
        sb.append((char) (index + 65));
    }
}
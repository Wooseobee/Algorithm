import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//1. 루트에서 가장 멀리 있는 노드 찾기
//2. 가장 멀리 있는 노드에서 또 가장 멀리 있는 노드 찾기
//3. 두 노드 사이의 거리(=트리의 지름) 구하기
public class Main {
    static class Node {
        int num;
        int weight;

        Node(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }
    }

    static List<Node> list[];
    static int n, max = 0, max_num = 0;
    static boolean isVisited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        list = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            String s[] = br.readLine().split(" ");
            list[Integer.parseInt(s[0])].add(new Node(Integer.parseInt(s[1]), Integer.parseInt(s[2])));
            list[Integer.parseInt(s[1])].add(new Node(Integer.parseInt(s[0]), Integer.parseInt(s[2])));
        }

        isVisited = new boolean[n + 1];
        isVisited[1] = true;
        dfs(1, 0);

        isVisited = new boolean[n + 1];
        isVisited[max_num] = true;
        dfs(max_num, 0);
        System.out.println(max);

        br.close();
    }

    public static void dfs(int num, int weight) {
        if (max < weight) {
            max = weight;
            max_num = num;
        }
        for (Node node : list[num]) {
            if (!isVisited[node.num]) {
                isVisited[node.num] = true;
                dfs(node.num, node.weight + weight);
            }
        }
    }
}
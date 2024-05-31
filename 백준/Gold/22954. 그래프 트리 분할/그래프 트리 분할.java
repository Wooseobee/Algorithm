import java.io.*;
import java.util.*;

public class Main {
    private static int n, m, treeNum;
    private static boolean[] visited;
    private static boolean[] isLeaf;
    private static List<int[]>[] edges;
    private static List<Integer>[] treeNodes;
    private static List<Integer>[] treeEdges;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        n = Integer.parseInt(in[0]);
        m = Integer.parseInt(in[1]);
        
        if (n<=2){
            System.out.println(-1);
            return;
        }

        edges = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        isLeaf = new boolean[n + 1];
        treeNodes = new ArrayList[2];
        treeEdges = new ArrayList[2];

        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < 2; i++) {
            treeNodes[i] = new ArrayList<>();
            treeEdges[i] = new ArrayList<>();
        }

        for (int i = 1; i <= m; i++) {
            in = br.readLine().split(" ");
            int u = Integer.parseInt(in[0]);
            int v = Integer.parseInt(in[1]);
            edges[u].add(new int[]{v, i});
            edges[v].add(new int[]{u, i});
        }

        // 최적화된 DFS 탐색으로 각 컴포넌트 탐색
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i, treeNum);
                treeNum++;
            }
        }

        // 트리 개수가 2개보다 많으면 분할 불가
        if (treeNum > 2) {
            System.out.println("-1");
            return;
        }

        int startV = 0, selected = 0;

        // 트리 개수가 1개일 경우 분할 시도
        if (treeNum < 2) {
            for (int x : treeNodes[0]) {
                if (isLeaf[x]) {
                    selected = x;
                } else {
                    startV = x;
                }
            }

            treeNodes[0].clear();
            treeEdges[0].clear();
            Arrays.fill(visited, false);
            visited[selected] = true;
            dfs(startV, 0);

            treeNodes[1].add(selected);
        }

        // 두 트리의 크기가 같으면 분할 불가
        if (treeNodes[0].size() == treeNodes[1].size()) {
            System.out.println("-1");
            return;
        }

        // 결과 출력 최적화
        sb.append(treeNodes[0].size()).append(" ").append(treeNodes[1].size()).append("\n");
        printList(treeNodes[0]);
        printList(treeEdges[0]);
        printList(treeNodes[1]);
        printList(treeEdges[1]);

        System.out.println(sb);
    }

    private static void dfs(int now, int idx) {
        if (idx >= treeNodes.length || idx >= treeEdges.length) {
            return;
        }
        visited[now] = true;
        treeNodes[idx].add(now);
        boolean leaf = true;
        for (int[] e : edges[now]) {
            int next = e[0];
            int edgeNum = e[1];
            if (next >= visited.length) {
                continue;
            }
            if (!visited[next]) {
                treeEdges[idx].add(edgeNum);
                leaf = false;
                dfs(next, idx);
            }
        }
        if (leaf) {
            isLeaf[now] = true;
        }
    }

    private static void printList(List<Integer> list) {
        Collections.sort(list); // 정렬
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) sb.append(" ");
            sb.append(list.get(i));
        }
        sb.append("\n");
    }
}

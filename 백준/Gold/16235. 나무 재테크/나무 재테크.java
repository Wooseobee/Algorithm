import java.io.*;
import java.util.*;

public class Main {
    static class Tree {
        int i;
        int j;
        int age;

        public Tree(int i, int j, int age) {
            this.i = i;
            this.j = j;
            this.age = age;
        }
    }

    static int n, m, k;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int[][] a, map;
    static List<Tree> treeList = new ArrayList<>();
    static Deque<Tree> trees = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n + 1][n + 1];
        a = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
                map[i][j] = 5;
            }
        }

        for (int k = 0; k < m; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());

            treeList.add(new Tree(i,j,age));
        }

        treeList.sort((o1, o2) -> o1.age - o2.age);
        trees.addAll(treeList);

        for (int i = 0; i < k; i++) {
            spring();
            fall();
            winter();
        }

        System.out.println(trees.size());
        br.close();
    }

    private static void winter() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                map[i][j] += a[i][j];
            }
        }
    }

    private static void fall() {
        int size = trees.size();
        List<Tree> addList = new LinkedList<>();
        for (int k = 0; k < size; k++) {
            Tree tree = trees.removeFirst();
            int i = tree.i;
            int j = tree.j;
            int age = tree.age;
            if (age % 5 == 0) {
                for (int l = 0; l < 8; l++) {
                    int newI = i + dy[l];
                    int newJ = j + dx[l];
                    if (newI >= 1 && newJ >= 1 && newI <= n && newJ <= n) {
                        addList.add(new Tree(newI, newJ, 1));
                    }
                }
            }
            trees.addLast(tree);
        }
        for (Tree tree : addList) {
            trees.addFirst(tree);
        }
    }

    private static void summer(int i, int j, int nutrient) {
        map[i][j] += nutrient;
    }

    private static void spring() {
        int size = trees.size();
        List<Tree> dieTrees = new LinkedList<>();
        for (int k = 0; k < size; k++) {
            Tree tree = trees.removeFirst();
            int i = tree.i;
            int j = tree.j;
            int age = tree.age;

            if (map[i][j] >= age) {
                map[i][j] -= age;
                trees.addLast(new Tree(i, j, age + 1));
            } else {
                dieTrees.add(new Tree(i, j, age / 2));
            }
        }
        for (Tree dieTree : dieTrees) {
            int i = dieTree.i;
            int j = dieTree.j;
            int age = dieTree.age;

            summer(i, j, age);
        }
    }
}
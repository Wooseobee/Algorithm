import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
    static List<Integer> list[];
    static int N;
    static int cnt = 0;
    static int parents[];
    static boolean leaf[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        list = new LinkedList[N];
        leaf = new boolean[N];
        parents = new int[N];

        for (int i = 0; i < N; i++) {
            list[i] = new LinkedList<Integer>();
            leaf[i] = true;
        }

        String s[] = br.readLine().split(" ");
        for (int i = 0; i < N ; i++) {
            parents[i] = Integer.parseInt(s[i]);
            if(!s[i].equals("-1")) {
                list[Integer.parseInt(s[i])].add(i);
                leaf[Integer.parseInt(s[i])] = false;
            }
        }

        int deleteNum = Integer.parseInt(br.readLine());

        removeLeaf(deleteNum);
        if (parents[deleteNum] != -1 && list[parents[deleteNum]].size() == 1) {
            leaf[deleteNum] = true;
        }

        for (int i = 0; i < N; i++) {
            if (leaf[i] == true) {
                cnt++;
            }
        }
        System.out.println(cnt);
        br.close();
    }
    public static void removeLeaf(int deleteNum){
        leaf[deleteNum] = false;
        for (int i = 0; i < list[deleteNum].size(); i++) {
            removeLeaf(list[deleteNum].get(i));
        }
    }
}
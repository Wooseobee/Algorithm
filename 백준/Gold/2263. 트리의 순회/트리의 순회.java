import java.io.*;

public class Main {
    static int inOrder[];
    static int postOrder[];
    static int preOrder[];
    static int idx = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        inOrder = new int[n];
        postOrder = new int[n];
        preOrder = new int[n];
        String s[] = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            inOrder[i] = Integer.parseInt(s[i]);
        }
        s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            postOrder[i] = Integer.parseInt(s[i]);
        }

        makePreOrder(0, n - 1, 0, n - 1);

        for (int i = 0; i < n; i++) {
            bw.write(preOrder[i]+ " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    public static void makePreOrder(int inStart, int inEnd, int poStart, int poEnd) {
        if (inStart <= inEnd && poStart <= poEnd) {
            preOrder[idx++] = postOrder[poEnd];
            int root = inStart;
            for (int i = inStart; i <= inEnd; i++) {
                if (inOrder[i] == postOrder[poEnd]) {
                    root = i;
                    break;
                }
            }
            makePreOrder(inStart, root - 1, poStart, poStart + root - inStart - 1);
            makePreOrder(root + 1, inEnd, poStart + root - inStart, poEnd - 1);
        }
    }
}
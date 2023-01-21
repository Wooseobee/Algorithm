import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        long[] triangles = new long[101];
        triangles[1] = triangles[2] = triangles[3] = 1;
        triangles[4] = triangles[5] = 2;
        for (int i = 6; i < 101; i++) {
            triangles[i] = triangles[i - 5] + triangles[i - 1];
        }

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            bw.write(triangles[n] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
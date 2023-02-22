import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        int[] wine = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }
        
        dp[0]=0;
        dp[1]=wine[1];
        if(n>1){
            dp[2]=wine[1]+wine[2];
        }
        for (int i = 3; i <= n; i++){
            dp[i] = Math.max(dp[i-1],Math.max(dp[i-2],dp[i-3]+wine[i-1])+wine[i]);
        }
        
        System.out.println(dp[n]);
        br.close();
    }
}
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int[] stage = new int[n];
        for(int i=0;i<n;i++){
            stage[i] = Integer.parseInt(br.readLine());
        }
        
        int cnt = 0;
        int max = stage[n-1];
        for(int i=n-2;i>=0;i--){
            if(max<=stage[i]){
                max--;
                cnt+=stage[i]-max;
            } else {
                max = stage[i];
            }
        }
        
        System.out.println(cnt);
        br.close();
    }
}
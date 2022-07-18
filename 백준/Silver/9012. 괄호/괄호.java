import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            int flag = 0;
            String s = br.readLine();
            String[] arr = s.split("");
            for (int j = 0; j < arr.length; j++) {
                switch (arr[j]){
                    case "(":
                        stack.push("(");
                        break;
                    case ")":
                        if(!stack.isEmpty())
                            stack.pop();
                        else
                            flag=1;
                        break;
                    default:
                        break;
                }
                if(flag==1) break;
            }
            if(flag==1||!stack.isEmpty()){
                bw.write("NO\n");
                bw.flush();
            }
            else{
                bw.write("YES\n");
                bw.flush();
            }
            stack.clear();
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
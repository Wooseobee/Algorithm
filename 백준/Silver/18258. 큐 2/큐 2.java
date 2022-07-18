import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Queue<Integer> queue = new LinkedList<>();

        Integer N = Integer.parseInt(br.readLine());
        Integer last = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String s = st.nextToken();
            switch (s){
                case "push":
                    Integer x = Integer.parseInt(st.nextToken());
                    queue.offer(x);
                    last = x;
                    break;
                case "pop":
                    if(queue.isEmpty())
                        sb.append("-1\n");
                    else
                        sb.append(queue.poll() + "\n");
                    break;
                case "size":
                    sb.append(queue.size() + "\n");
                    break;
                case "empty":
                    if (queue.isEmpty())
                        sb.append("1\n");
                    else
                        sb.append("0\n");
                    break;
                case "front":
                    if(queue.isEmpty())
                        sb.append("-1\n");
                    else
                        sb.append(queue.peek() + "\n");
                    break;
                case "back":
                    if(queue.isEmpty())
                        sb.append("-1\n");
                    else {
                        sb.append(last + "\n");
                    }
                    break;
                default:
                    break;
            }
        }
        System.out.println(sb);

        br.close();
    }
}
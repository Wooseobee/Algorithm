import java.util.*;
import java.io.*;

public class Main {
    static Deque<Integer> deque = new ArrayDeque<>();
    static Queue<Integer> idxQueue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int total = 0;
        int firstNum = 0;

        for (int i = 0; i < n; i++) {
            deque.add(i);
        }

        input = br.readLine().split(" ");

        for (int i = 0; i < m; i++) {
            idxQueue.add(Integer.parseInt(input[i]) - 1);
        }

        while (!idxQueue.isEmpty()) {
            int idx = idxQueue.poll();
            int num1 = 0;
            int num2 = 0;
            
            while (idx != firstNum) {
                firstNum = pushLeft();
                num1++;
            }
            for (int i = num1; i > 0 ; i--) {
                firstNum = pushRight();
            }
            while (idx != firstNum) {
                firstNum = pushRight();
                num2++;
            }
            
            if (num1 > num2) {
                total += num2;
            } else {
                total += num1;
            }
            
            deque.poll();
            if (!deque.isEmpty()) {
                firstNum = deque.peek();
            }
        }

        System.out.println(total);
        br.close();
    }

    public static int pushLeft() {
        deque.addLast(deque.poll());
        return deque.peek();
    }

    public static int pushRight() {
        deque.addFirst(deque.pollLast());
        return deque.peek();
    }
}
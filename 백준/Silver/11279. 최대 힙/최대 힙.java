import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> heap = new ArrayList<>();
        heap.add(0);

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            int size = heap.size();
            if (x == 0) {
                if (size == 1) {
                    sb.append(0 + "\n");
                } else {
                    sb.append(heap.remove(1) + "\n");
                    size--;
                    if (size > 2) {
                        heap.add(1, heap.get(size-1));
                        heap.remove(size);
                        size--;
                    }
                    int top = 1, left, right, tmp;
                    while (true) {
                        left = top * 2;
                        right = top * 2 + 1;

                        if (left >= heap.size()) {
                            break;
                        } else if (right >= heap.size()) {
                            if (heap.get(top) < heap.get(left)) {
                                tmp = heap.get(top);
                                heap.set(top, heap.get(left));
                                heap.set(left, tmp);
                                top = left;
                            } else {
                                break;
                            }
                        } else {
                            if (heap.get(left) > heap.get(right)) {
                                if (heap.get(top) < heap.get(left)) {
                                    tmp = heap.get(top);
                                    heap.set(top, heap.get(left));
                                    heap.set(left, tmp);
                                    top = left;
                                } else {
                                    break;
                                }
                            } else {
                                if (heap.get(top) < heap.get(right)) {
                                    tmp = heap.get(top);
                                    heap.set(top, heap.get(right));
                                    heap.set(right, tmp);
                                    top = right;
                                } else {
                                    break;
                                }
                            }
                        }
                    }
                }
            } else {
                if (size == 1) {
                    heap.add(x);
                } else {
                    heap.add(x);
                    while (size > 1 && heap.get(size / 2) < x) {
                        heap.set(size, heap.get(size / 2));
                        heap.set(size / 2, x);
                        size /= 2;
                    }
                }
            }
        }
        br.close();
        System.out.println(sb);
    }
}
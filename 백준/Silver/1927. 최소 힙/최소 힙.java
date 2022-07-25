import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> heap = new ArrayList<>();
        heap.add(0);

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                if (heap.size() == 1) {
                    sb.append(0 + "\n");
                } else {
                    sb.append(heap.remove(1) + "\n");
                    if (heap.size() > 2) {
                        heap.add(1, heap.get(heap.size() - 1));
                        heap.remove(heap.size() - 1);
                    }
                    int top = 1, left, right, tmp;
                    while (true) {
                        left = top * 2;
                        right = top * 2 + 1;
                        if (left >= heap.size()) {
                            break;
                        } else if (right >= heap.size()) {
                            if (heap.get(top) > heap.get(left)) {
                                tmp = heap.get(left);
                                heap.set(left, heap.get(top));
                                heap.set(top, tmp);
                                top = left;
                            } else {
                                break;
                            }
                        } else {
                            if (heap.get(left) < heap.get(right)) {
                                if (heap.get(top) > heap.get(left)) {
                                    tmp = heap.get(left);
                                    heap.set(left, heap.get(top));
                                    heap.set(top, tmp);
                                    top = left;
                                } else {
                                    break;
                                }
                            } else {
                                if (heap.get(top) > heap.get(right)) {
                                    tmp = heap.get(right);
                                    heap.set(right, heap.get(top));
                                    heap.set(top, tmp);
                                    top = right;
                                } else {
                                    break;
                                }
                            }
                        }
                    }
                }
            } else {
                if (heap.size() == 1) {
                    heap.add(x);
                } else {
                    heap.add(x);
                    int index = heap.size() - 1;
                    int tmp;
                    while (index > 1 && heap.get(index) < heap.get(index / 2)) {
                        tmp = heap.get(index);
                        heap.set(index, heap.get(index / 2));
                        heap.set(index / 2, tmp);
                        index /= 2;
                    }
                }
            }
        }
        br.close();
        System.out.println(sb);
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Integer> arr = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");

        for (String s : input) {
            binarySearch(Integer.parseInt(s));
        }

        System.out.println(arr.size());
        br.close();
    }

    private static void binarySearch(int v) {
        int l = 0;
        int r = arr.size();
        while (l < r) {
            int mid = (l + r) / 2;
            int now = arr.get(mid);
            if (now == v) {
                return;
            } else if (now > v){
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (l == arr.size()) {
            arr.add(v);
        } else {
            arr.set(l, v);
        }
    }
}
class Solution {
    static int n, m;
    static int sell = 0, max = 0;
    static int[] price, rate;

    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];

        n = users.length;
        m = emoticons.length;

        price = new int[m];
        rate = new int[m];

        for (int i = 0; i < m; i++) {
            price[i] = emoticons[i] * 90 / 100;
            rate[i] = 10;
        }

        dfs(0, users, emoticons);

        answer[0] = max;
        answer[1] = sell;
        System.out.println(max + " " + sell);
        return answer;
    }

    static void search(int[][] users) {
        int total = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < m; j++) {
                if (rate[j] >= users[i][0]) {
                    sum += price[j];
                }
            }
            if (sum >= users[i][1]) {
                cnt++;
            } else {
                total += sum;
            }
        }
        if (max < cnt) {
            max = cnt;
            sell = total;
        } else if (max == cnt) {
            sell = Math.max(sell, total);
        }
    }

    static void dfs(int idx, int[][] users, int[] emoticons) {
        if (idx == m) {
            return;
        }
        for (int i = idx; i < m; i++) {
            for (int j = 10; j <= 40; j += 10) {
                int beforeRate = rate[i];
                int beforePrice = price[i];
                price[i] = emoticons[i] * (100 - j) / 100;
                rate[i] = j;

                search(users);
                dfs(i + 1, users, emoticons);

                price[i] = beforePrice;
                rate[i] = beforeRate;
            }
        }
    }
}
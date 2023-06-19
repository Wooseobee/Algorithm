class Solution {
    char[][] map;
    int[] answer = new int[2];

    public int[] solution(String[] park, String[] routes) {
        map = new char[park.length][park[0].length()];
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                map[i][j] = park[i].charAt(j);
                if (map[i][j] == 'S') {
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }
        for (int i = 0; i < routes.length; i++) {
            char[] c = routes[i].toCharArray();
            char op = c[0];
            int n = Character.getNumericValue(c[2]);
            checkRoute(op, n);
        }
        return answer;
    }

    public void checkRoute(char op, int n) {
        int i = answer[0];
        int j = answer[1];
        switch (op) {
            case 'N':
                if (i - n < 0) return;
                for (int k = 0; k <= n; k++) {
                    if (map[i - k][j] == 'X') return;
                }
                answer[0] = i - n;
                break;
            case 'S':
                if (i + n >= map.length) return;
                for (int k = 0; k <= n; k++) {
                    if (map[i + k][j] == 'X') return;
                }
                answer[0] = i + n;
                break;
            case 'W':
                if (j - n < 0) return;
                for (int k = 0; k <= n; k++) {
                    if (map[i][j - k] == 'X') return;
                }
                answer[1] = j - n;
                break;
            case 'E':
                if (j + n >= map[0].length) return;
                for (int k = 0; k <= n; k++) {
                    if (map[i][j + k] == 'X') return;
                }
                answer[1] = j + n;
                break;
        }
    }
}
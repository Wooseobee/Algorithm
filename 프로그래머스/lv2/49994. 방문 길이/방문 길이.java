import java.util.*;

class Solution {
    static class Edge {
        int x1;
        int y1;
        int x2;
        int y2;

        public Edge(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        @Override
        public boolean equals(Object o) {
            Edge obj = (Edge) o;
            return this.x1 == obj.x1 && this.y1 == obj.y1 && this.x2 == obj.x2 && this.y2 == obj.y2 ||
                    this.x1 == obj.x2 && this.y1 == obj.y2 && this.x2 == obj.x1 && this.y2 == obj.y1;
        }

        @Override
        public int hashCode() {
            int minX = Math.min(x1, x2);
            int maxX = Math.max(x1, x2);
            int minY = Math.min(y1, y2);
            int maxY = Math.max(y1, y2);
            return Objects.hash(minX, minY, maxX, maxY);
        }
    }

    static Set<Edge> ways = new HashSet<>();
    static int x = 0, y = 0;

    public int solution(String dirs) {
        int answer = 0;

        for (int i = 0; i < dirs.length(); i++) {
            char dir = dirs.charAt(i);
            move(dir);
        }

        return ways.size();
    }

    private static void move(char dir) {
        switch (dir) {
            case 'U':
                if (y == 5) break;
                ways.add(new Edge(x, y, x, y + 1));
                y++;
                break;
            case 'D':
                if (y == -5) break;
                ways.add(new Edge(x, y, x, y - 1));
                y--;
                break;
            case 'L':
                if (x == -5) break;
                ways.add(new Edge(x, y, x - 1, y));
                x--;
                break;
            case 'R':
                if (x == 5) break;
                ways.add(new Edge(x, y, x + 1, y));
                x++;
                break;
        }
    }
}
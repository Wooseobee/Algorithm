class Solution {
    public int solution(int n, long l, long r) {
        int answer = 0;
        long len = (long) Math.pow(5, n);
        for(long i = l; i <= r; i++) {
            boolean flag = true;
            long v = dfs(i, len);
            answer+=v;
        }
        return answer;
    }

	public long dfs(long i, long len) {
		if (i > len * 2 && i <= len * 3) {
			return 0;
		}
		if (len == 5) {
			if (i % 5 == 3)
				return 0;
			else
				return 1;
		}
		return dfs(i % len, len / 5);
	}
}
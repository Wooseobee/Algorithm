class Solution {
	static int n, m, mapLen;
	static int[][] key1, key2, key3, map;

	public boolean solution(int[][] key, int[][] lock) {
		n = key.length;
		m = lock.length;
		mapLen = m + (n * 2) - 2;
		key1 = new int[n][n];
		key2 = new int[n][n];
		key3 = new int[n][n];

		setKey(key);

		map = new int[mapLen][mapLen];

		setLock(map, lock, n, m);

		for (int i = 0; i <= mapLen - n; i++) {
			for (int j = 0; j <= mapLen - n; j++) {
				if (checkMap(key, i, j))
					return true;
				if (checkMap(key1, i, j))
					return true;
				if (checkMap(key2, i, j))
					return true;
				if (checkMap(key3, i, j))
					return true;
			}
		}

		return false;
	}

	private boolean checkMap(int[][] key, int i, int j) {
		for (int k = 0; k < n; k++) {
			for (int l = 0; l < n; l++) {
				map[i + k][j + l] += key[k][l];
			}
		}

		boolean found = true;
		for (int i1 = n - 1, k = 0; i1 < n + m - 1; i1++, k++) {
			for (int j1 = n - 1, l = 0; j1 < n + m - 1; j1++, l++) {
				if (map[i1][j1] != 1) {
					found = false;
					break;
				}
			}
			if (!found)
				break;
		}
		if (found)
			return true;

		for (int k = 0; k < n; k++) {
			for (int l = 0; l < n; l++) {
				map[i + k][j + l] -= key[k][l];
			}
		}

		return false;
	}

	private void setLock(int[][] map, int[][] lock, int n, int m) {
		for (int i = n - 1, k = 0; i < n + m - 1; i++, k++) {
			for (int j = n - 1, l = 0; j < n + m - 1; j++, l++) {
				map[i][j] = lock[k][l];
			}
		}
	}

	private void setKey(int[][] key) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				key1[i][j] = key[n - j - 1][i];
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				key2[i][j] = key1[n - j - 1][i];
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				key3[i][j] = key2[n - j - 1][i];
			}
		}
	}
}
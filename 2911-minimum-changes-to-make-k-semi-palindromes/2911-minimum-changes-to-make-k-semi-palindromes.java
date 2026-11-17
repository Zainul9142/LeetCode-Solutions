import java.util.Arrays;

class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();
        int[][] cost = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                cost[i][j] = getSemiPalindromeCost(s, i, j);
            }
        }

        int INF = 1_000_000;
        int[][] dp = new int[n + 1][k + 1];
        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }
        dp[0][0] = 0;

        for (int j = 1; j <= k; j++) {
            for (int i = 2 * j; i <= n; i++) {
                for (int p = 2 * (j - 1); p <= i - 2; p++) {
                    dp[i][j] = Math.min(dp[i][j], dp[p][j - 1] + cost[p][i - 1]);
                }
            }
        }

        return dp[n][k];
    }

    private int getSemiPalindromeCost(String s, int start, int end) {
        int len = end - start + 1;
        int minChanges = len;

        for (int d = 1; d < len; d++) {
            if (len % d == 0) {
                int changes = 0;
                for (int rem = 0; rem < d; rem++) {
                    int left = start + rem;
                    int right = end - d + 1 + rem;
                    while (left < right) {
                        if (s.charAt(left) != s.charAt(right)) {
                            changes++;
                        }
                        left += d;
                        right -= d;
                    }
                }
                minChanges = Math.min(minChanges, changes);
            }
        }

        return minChanges;
    }
}
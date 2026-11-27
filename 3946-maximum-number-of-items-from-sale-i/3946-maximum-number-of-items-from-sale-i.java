class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int maxFactor = 0;
        for (int[] item : items) {
            maxFactor = Math.max(maxFactor, item[0]);
        }

        int[] freq = new int[maxFactor + 1];
        for (int[] item : items) {
            freq[item[0]]++;
        }

        int[] divCount = new int[maxFactor + 1];
        for (int f = 1; f <= maxFactor; f++) {
            if (freq[f] == 0) continue;
            for (int multiple = f; multiple <= maxFactor; multiple += f) {
                divCount[f] += freq[multiple];
            }
        }

        int[] dp = new int[budget + 1];
        int minPrice = Integer.MAX_VALUE;

        for (int[] item : items) {
            int factor = item[0];
            int price = item[1];
            minPrice = Math.min(minPrice, price);
            int firstBuyValue = divCount[factor];

            for (int b = budget; b >= price; b--) {
                dp[b] = Math.max(dp[b], dp[b - price] + firstBuyValue);
            }
        }

        int ans = 0;
        for (int b = 0; b <= budget; b++) {
            int remaining = budget - b;
            ans = Math.max(ans, dp[b] + remaining / minPrice);
        }

        return ans;
    }
}
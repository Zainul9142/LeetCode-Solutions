import java.util.Arrays;

class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] freq = new int[n + 1];
        for (int[] item : items) {
            freq[item[0]]++;
        }

        int[] divCount = new int[n + 1];
        for (int f = 1; f <= n; f++) {
            if (freq[f] == 0) continue;
            for (int m = f; m <= n; m += f) {
                divCount[f] += freq[m];
            }
        }

        long[][] sortedItems = new long[n][2];
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int f = items[i][0];
            int p = items[i][1];
            sortedItems[i][0] = p;
            sortedItems[i][1] = divCount[f] - 1;
            minPrice = Math.min(minPrice, p);
        }

        Arrays.sort(sortedItems, (a, b) -> Long.compare(a[0], b[0]));

        long totalItems = 0;
        long remBudget = budget;

        for (long[] item : sortedItems) {
            long price = item[0];
            long gain = item[1];

            if (price >= 2L * minPrice || gain <= 0) {
                continue;
            }

            long canBuy = Math.min(gain, remBudget / price);
            totalItems += canBuy * 2;
            remBudget -= canBuy * price;
        }

        totalItems += remBudget / minPrice;

        return (int) totalItems;
    }
}
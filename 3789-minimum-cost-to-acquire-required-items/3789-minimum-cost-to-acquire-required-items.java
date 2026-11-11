class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long c1 = cost1;
        long c2 = cost2;
        long cb = costBoth;
        long n1 = need1;
        long n2 = need2;

        long shared = Math.min(n1, n2);
        long commonCost = Math.min(cb, c1 + c2);
        long totalCost = shared * commonCost;

        long rem1 = n1 - shared;
        long rem2 = n2 - shared;

        if (rem1 > 0) {
            totalCost += rem1 * Math.min(c1, cb);
        } else if (rem2 > 0) {
            totalCost += rem2 * Math.min(c2, cb);
        }

        return totalCost;
    }
}
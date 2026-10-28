class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total = 0, maxCurrent = 0, minCurrent = 0;
        int maxGlobal = nums[0], minGlobal = nums[0];
        for (int x : nums) {
            total += x;
            maxCurrent = Math.max(x, maxCurrent + x);
            maxGlobal = Math.max(maxGlobal, maxCurrent);
            minCurrent = Math.min(x, minCurrent + x);
            minGlobal = Math.min(minGlobal, minCurrent);
        }
        return maxGlobal < 0 ? maxGlobal : Math.max(maxGlobal, total - minGlobal);
    }
}
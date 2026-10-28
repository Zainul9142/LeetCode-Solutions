class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        long sum = 0, maxSum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (i >= k) {
                int out = nums[i - k];
                sum -= out;
                if (map.get(out) == 1) map.remove(out);
                else map.put(out, map.get(out) - 1);
            }
            if (i >= k - 1 && map.size() == k) {
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
}
import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;
        long ans = 0;
        long cost = 0;
        Deque<int[]> dq = new ArrayDeque<>();
        int r = n - 1;

        for (int l = n - 1; l >= 0; l--) {
            int count = 1;
            while (!dq.isEmpty() && dq.peekFirst()[0] <= nums[l]) {
                int[] top = dq.pollFirst();
                cost += (long) (nums[l] - top[0]) * top[1];
                count += top[1];
            }
            dq.offerFirst(new int[]{nums[l], count});

            while (cost > k) {
                int[] last = dq.peekLast();
                cost -= (long) (last[0] - nums[r]);
                last[1]--;
                if (last[1] == 0) {
                    dq.pollLast();
                }
                r--;
            }

            ans += (r - l + 1);
        }

        return ans;
    }
}
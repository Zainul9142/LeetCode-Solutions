class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] modGroups = new int[k];
        modGroups[0] = 1;
        int runningSum = 0, result = 0;
        for (int num : nums) {
            runningSum = (runningSum + num) % k;
            if (runningSum < 0) runningSum += k;
            result += modGroups[runningSum];
            modGroups[runningSum]++;
        }
        return result;
    }
}

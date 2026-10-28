class Solution {
    public int[] leftRightDifference(int[] nums) {
        int rightSum = 0, leftSum = 0;
        for (int num : nums) rightSum += num;
        int[] answer = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            rightSum -= nums[i];
            answer[i] = Math.abs(leftSum - rightSum);
            leftSum += nums[i];
        }
        return answer;
    }
}
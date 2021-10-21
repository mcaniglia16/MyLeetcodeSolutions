class Solution {
    public int maxSubArray(int[] nums) {
        Solution 1: Brute force O(n^2) time 
        int max = Integer.MIN_VALUE;
        for (int i=0; i<nums.length; i++) {
            int currSum = nums[i];
            max = Math.max(max, currSum);
            for (int j=i+1; j<nums.length; j++) { 
                currSum+=nums[j];
                max = Math.max(max, currSum);
            }
        }
        return max;
        
        //////////////////////////////////////////////////
        
        //Solution 2: DP (Kadane's algo) O(n) time
        int max = nums[0];
        int currSum = max;
        for (int i=1; i<nums.length; i++) {
            currSum = Math.max(currSum+nums[i], nums[i]);
            max = Math.max(max, currSum);
        }
        return max;
    }
}
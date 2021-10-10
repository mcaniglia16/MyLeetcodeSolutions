class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int res = nums[0] + nums[1] + nums[nums.length-1];
        Arrays.sort(nums);
        
        
        for (int i=0; i<nums.length-2; i++) {
            int left = i+1;
            int right = nums.length-1;
            while (left < right) {
                int num = nums[i]+nums[left]+nums[right];
                if (num > target) {
                    right--;
                } else { //(num <= target)
                    left++;
                } 
                
                if (Math.abs(target-num) < Math.abs(target - res)) {
                    res = num;
                }
            }
        }
        return res;
    }
}
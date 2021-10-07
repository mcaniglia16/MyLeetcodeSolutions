class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
       
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        
        for (int i=0; i<nums.length; i++) {
            int curr = nums[i];
            
            if (i == 0 || (i>0 && nums[i]!=nums[i-1])) {
                int sum = 0-curr;
                int left = i+1;
                int right = nums.length-1;
        
                while (left < right) {
                    if (nums[left] + nums[right] > sum){
                        right--;
                    } else if (nums[left] + nums[right] < sum) {
                        left++;
                    } else {
                        res.add(Arrays.asList(curr, nums[left], nums[right]));
                        while (left<right && nums[left]==nums[left+1]) left++;
                        while (left<right && nums[right]==nums[right-1]) right--;
                        right--;
                        left++;
                    }
                } 
            }
        }
        return res;
    }
}
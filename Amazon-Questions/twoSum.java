class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> vals = new HashMap<>(); 
        for (int i=0; i < nums.length; i++) {
            int diff = target - nums[i];
            if ( !vals.containsKey(diff) ) {
                vals.put(nums[i], i);
            } else {
                return new int[]{i, vals.get(diff)};
            }
        }

        return new int[1];
    }
}
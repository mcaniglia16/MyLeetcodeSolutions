class Solution {
    public int missingNumber(int[] nums) {
        //O(n) time O(n) space
//         HashSet<Integer> n = new HashSet<Integer>();
        
//         for (int i=0; i<nums.length; i++) {
//             n.add(nums[i]);
//         }
        
//         for(int i=0; i<=nums.length; i++) {
//             if(!n.contains(i)) {
//                 return i;
//             }
//         }
//         return -1;
        
        Arrays.sort(nums);
        if (nums[0] != 0) return 0;
        if (nums[nums.length-1] != nums.length) return nums.length;
        
        for (int i=1; i<nums.length; i++) {
            int expectedNum = nums[i-1] + 1;
            if (nums[i] != expectedNum) return i;
            
        }
        return -1;
    }
}
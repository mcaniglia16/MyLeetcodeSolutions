class Solution {
    /*
        Modified binary search
        Time complexity : O(logN).
        Space complexity : O(1).
    */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length==0) return -1;
        
        int left =0; 
        int right = nums.length-1;
        while(left<right) {
            int mid = left + (right-left) / 2;
            if(nums[mid] > nums[right]) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        //this loop will break when left pointer is at the smallest number in the array
        
        int start = left;
        left = 0;
        right = nums.length-1;
        
        // [start, right] and [left, start] are sorted arrays, we just need to figure out which one to search in
        if(target >= nums[start] && target <= nums[right]) left = start;
        else right = start; //if (target <= nums[start] && target >= nums[left])
        
        while(left <= right) {
            int midpoint = left + (right-left)/2;
            if(nums[midpoint] == target) {
                return midpoint;
            } else if (nums[midpoint] > target) {
                right = midpoint-1;
            } else {
                left = midpoint+1;
            }
        }
        return -1;
    }
}
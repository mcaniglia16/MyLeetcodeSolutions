class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int max = 0;
        
        while (left < right) {
            if ( height[right] > height[left] ) {
                max = Math.max(max, (height[left]*(right - left)));
                left++;
            } else { //height[right] <= height[left] 
                max = Math.max(max, (height[right]*(right - left)));
                right--;
            } 
        }
        return max;
    }
}
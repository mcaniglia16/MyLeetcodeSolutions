public class KthLargestElement {
    //Solution 1: sorting
    // Time: O(n log n) 
    // Space: O*(k)
    public int findKthLargest(int[] nums, int k) {
        final int N = nums.length;
        Arrays.sort(nums);
        return nums[N - k];
    }


    //////////////////////////////////////////////////////////////


    //Solution 2: min oriented priority queue
    // Time: O(n) best case | O(n^2) worst case
    // Space: O(1)
    public int findKthLargest(int[] nums, int k) {

        final PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int val : nums) {
            pq.offer(val);
    
            if(pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}

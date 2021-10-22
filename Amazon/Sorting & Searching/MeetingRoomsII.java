class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals==null || intervals.length==0) return 0;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        //creating the heap: the root of the min-heap will always contain the meeting that ends the earliest
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        minHeap.add(intervals[0]);

        for (int i=1; i<intervals.length; i++) {
            //want to get the current meeting, and want to compare it to the root of the min-heap
            int[] curr = intervals[i];
            int[] earliest = minHeap.remove();
            if (curr[0] >= earliest[1]) {
                //we want to change the 'earliest' end time to be the current end time
                //because we can book the meetings back to back without adding a new room
                earliest[1] = curr[1];
            } else {
                //we have a conflict
                minHeap.add(curr);
            }
            minHeap.add(earliest);
        }
        //we have the number of meeting rooms needed just with the number of elements in the heap.
        //similar to 'merge Intervals'
        return minHeap.size();
    }
}
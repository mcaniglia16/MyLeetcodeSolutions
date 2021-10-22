class Solution {
    public int[][] merge(int[][] intervals) {
        /*
            Idea: you can change the interval in the output array just by referencing the variable in the loop  
            
            Time: O(n*log n)
            Space: O(log n) OR O(n)
        */
        if (intervals.length <= 1) return intervals;
        
        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));
        
        List<int[]> res = new ArrayList<>();
        int[] curr = intervals[0];
        res.add(curr);
        
        for(int[] interval : intervals) {
            int curr_start = curr[0];
            int curr_end = curr[1];
            int next_start = interval[0];
            int next_end = interval[1];
            
            if(curr_end >= next_start) {
                curr[1] = Math.max(curr_end, next_end);
                //this updates the 'res' arraylist, we dont have to remove and add
            } else {
                curr = interval;
                res.add(curr);
            }
        } 
        return res.toArray(new int[res.size()][]);
    }
}
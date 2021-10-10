class Solution {
    public int lengthOfLongestSubstring(String s) {

        //SLIDING WINDOW
        int left=0;
        int right=0;
        int max=0;
        
        HashSet<Character> chars = new HashSet<>();
        while (right < s.length() ) {
            if( !chars.contains(s.charAt(right)) ) {
                chars.add(s.charAt(right));
                max = Math.max(chars.size(), max);
                right++;
            } else {
                chars.remove(s.charAt(left));
                left++;
            }
        }
        return max;
    }
}
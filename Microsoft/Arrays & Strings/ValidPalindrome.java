class Solution {
    public boolean isPalindrome(String s) {
        //gotta remember this regex expression yikes
        String s2 = s.replaceAll("[^a-zA-Z0-9]", "");
        s2 = s2.toLowerCase();
        
        int left = 0;
        int right = s2.length()-1;
        while(left <= right) {
            if (s2.charAt(left) == s2.charAt(right)) {
                right--;
                left++;
            } else {
                return false;
            }
        }
        return true;
    }
}
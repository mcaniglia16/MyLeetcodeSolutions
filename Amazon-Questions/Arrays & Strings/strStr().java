class Solution {
    public int strStr(String haystack, String needle) {
        //Solution 1 (uses String.equals which is not ideal)
        int l1 = haystack.length();
        int l2 = needle.length();
        if (l1 < l2) {
            return -1;
        } else if (l2 == 0) {
            return 0;
        }
        int threshold = l1 - l2;
        for (int i = 0; i <= threshold; ++i) {
            if (haystack.substring(i,i+l2).equals(needle)) {
                return i;
            }
        }
        return -1;
        
        // //Solution 2
        // int l1 = haystack.length()
        // int l2 = needle.length();
        // if (l1 < l2) {
        //     return -1;
        // } else if (l2 == 0) {
        //     return 0;
        // }
        // for (int i=0; i<l1; i++) {
        //     int j;
        //     for (j=0; j<l2; j++) {
        //         if (haystack.charAt(i+j) != needle.chatAt(j)) {
        //             break;
        //         }
        //     }
        //     if (j == l2) {
        //         return i;
        //     }
        // }
        // return -1;
    }
}
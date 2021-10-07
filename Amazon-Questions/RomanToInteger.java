class Solution {
    public int romanToInt(String s) {
        // int[] nums = new int[]{900, 400, 90, 40, 9, 4};
        // String[] edges = new String[]{"CM", "CD", "XC",  "XL", "IX", "IV"};
        // int[] nums2 = new int[]{1000, 500, 100, 50, 10, 5, 1};
        // String[] romans = new String[]{"M", "D", "C",  "L", "X", "V", "I"};

        Map<Character, Integer> romans = new HashMap<Character, Integer>();
            romans.put('M', 1000);
            romans.put('D', 500);
            romans.put('C', 100);
            romans.put('L', 50);
            romans.put('X', 10);
            romans.put('V', 5);
            romans.put('I', 1);
        
        int num = 0;
        for (int i=0; i<s.length(); i++) {
            char curr = s.charAt(i);
            if (i+1 < s.length()) {
                char next = s.charAt(i+1);
                if (romans.get(curr) < romans.get(next)) {
                    num -= romans.get(curr);
                } else {
                    num += romans.get(curr);
                }
            } else {
                num += romans.get(curr);
            }
        }
        return num;
    }
}
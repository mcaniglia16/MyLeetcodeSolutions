class Solution {
    public String intToRoman(int num) {
        // int[] nums = new int[]{1000, 500, 100, 50, 10, 5, 1};
        // char[] roman = new char[]{'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        
        //edge cases:
        // 4 = IV
        // 9 = IX
        // 40 = XL
        // 90 = XC
        // 400 = CD
        // 900 = CM
        
        int[] nums = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        String toRoman = "";
        while (num > 0) {
            for (int i=0; i < nums.length; i++) {
                if (num / nums[i] >= 0) {
                    int n = num / nums[i];
                    num = num % (nums[i]);
                    toRoman = toRoman + roman[i].repeat(n);
                }
            }
        }
        return toRoman;
    }
}
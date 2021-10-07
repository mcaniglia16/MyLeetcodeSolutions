class Solution {
    public int myAtoi(String s) {
        boolean isPositive = true;
        s = s.trim();

        int i = 0;
        int num = 0;
        
        while(i < s.length() ) {
            char curr = s.charAt(i);

            if(curr == '-' && i==0 ) {
                System.out.println("negative");
                isPositive = false;
            } else if (curr =='+' && i==0) {
                i++;
                continue;
            } else if ( Character.isDigit(curr) ) {
                int tempCurr = Integer.parseInt(String.valueOf(curr));
                if(num > Integer.MAX_VALUE/10 || (num == Integer.MAX_VALUE/10 && tempCurr > 7) ){
                    return isPositive? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                num = (num*10) + Integer.parseInt(String.valueOf(curr));
            } else {
                return isPositive ? num : -num;
            }
            i++;
        } 
        num = isPositive ? num : -num;
        
        return num;
        
    }

}
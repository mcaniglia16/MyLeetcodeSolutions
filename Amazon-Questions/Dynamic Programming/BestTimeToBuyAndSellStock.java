class Solution {
    //Not really dynamic programming, but ok...
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for(int i=0; i<prices.length; i++) {
            if (prices[i] < min) min = prices[i];
            maxProfit = Math.max(maxProfit, (prices[i]-min));
        }
        return maxProfit;
    }
}
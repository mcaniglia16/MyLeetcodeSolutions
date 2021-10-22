class Solution {
    /*
        SOLUTION 1: iterative
            Time: O(3^N x 4^N)      some digits map to 3 letters, other to 4
            Space: O(3^N x 4^N) 
    */
    public List<String> letterCombinations(String digits) {
        LinkedList<String> res = new LinkedList<>();
        if (digits.length() == 0) return res;
        res.add("");
        
        String[] char_map = new String[] {"0", "1","abc","def","ghi","jlk","mno","pqrs","tuv","wxyz"};
        
        for(int i=0; i<digits.length(); i++){
            int index = Character.getNumericValue(digits.charAt(i));
            while(res.peek().length() == i) {
                String permutation = res.remove();
                for(char c : char_map[index].toCharArray()) {
                    res.add(permutation + c);
                }
            }
        }
        return res;
    }
}
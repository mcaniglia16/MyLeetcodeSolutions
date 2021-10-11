class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        
        HashMap<String, List<String>> anagrams = new HashMap<>();
        for (int i=0; i<strs.length; i++) {
            
            char[] curr = strs[i].toCharArray();
            Arrays.sort(curr);
            String sorted = new String(curr);
            
            if (!anagrams.containsKey(sorted)) {
                anagrams.put(sorted, new ArrayList<>());  
            }
            anagrams.get(sorted).add(strs[i]);
        }
        res.addAll(anagrams.values());
        return res;
    }
}
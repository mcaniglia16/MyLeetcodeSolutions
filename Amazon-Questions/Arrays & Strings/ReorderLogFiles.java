class Solution {
    public String[] reorderLogFiles(String[] logs) {
        //pass in lambda function to overwrite the base compare() method
        Arrays.sort(logs, (log1, log2) -> {
            //log1 < log2 => -1
            //log1 == log2 => 0
            //log1 > log2 => 1
            
            //log = dig1 8 1 5 1","let1 art can
            //the first occurence of a space is to separate the log id and log main
            int index1 = log1.indexOf(" ");
            String id1 = log1.substring(0, index1);
            String main1 = log1.substring(index1+1);
            
            int index2 = log2.indexOf(" ");
            String id2 = log2.substring(0, index2);
            String main2 = log2.substring(index2+1);
            
            boolean isDigit1 = Character.isDigit(main1.charAt(0));
            boolean isDigit2 = Character.isDigit(main2.charAt(0));
            
            //CASE 1
            if (!isDigit1 && !isDigit2) { 
                int value = main1.compareTo(main2);
                
                //if they have the same contents, order by id (lexicographically)
                if (value == 0) {
                    return id1.compareTo(id2);
                }
                return value;
            }
            
            //CASE2: there must be at least 1 digit log at this point: we want to keep the order of digit logs identical
            //if digit1 && digist2 are true, we want to leave them in the same order: 0
            //if digit1 true && digit1 false, return 1 (letter comes before digit)
            //if digit1 false && digit1 true, return -1 (letter comes before digit)
            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
        });
        return logs;
    }
}

// Time: O(N*logN) -> java uses a dual pivot quick sort algo under the hood specific to primitives
// Space: O(logN) -> recursive calls in the sort method are put onto the stack
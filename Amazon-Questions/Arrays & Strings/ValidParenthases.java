class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> st = new Stack();
        for(char c : s.toCharArray()) {
            // switch(c) {
            //     case ')': if (st.isEmpty() || st.pop() != '(') return false; break;
            //     case '}': if (st.isEmpty() || st.pop() != '{') return false; break;
            //     case ']': if (st.isEmpty() || st.pop() != '[') return false; break;
            //     default: st.push(c);
            // }
            if (c == ')' && !st.isEmpty() && st.peek() == '(') st.pop();
            else if (c == '}' && !st.isEmpty() && st.peek() == '{') st.pop();
            else if (c == ']' && !st.isEmpty() && st.peek() == '[') st.pop();
            else st.push(c);
            
        }
        return st.isEmpty();
    }
}
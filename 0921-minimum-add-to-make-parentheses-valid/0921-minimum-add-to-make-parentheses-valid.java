class Solution {
    public int minAddToMakeValid(String s) {
        int openCount = 0;
        int closeCount = 0;
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                openCount++;
            } else {
                // If there's an open parenthesis to pair with, pair them
                if (openCount > 0) {
                    openCount--;
                } else {
                    closeCount++;
                }
            }
        }
        
        return openCount + closeCount;
    }
}

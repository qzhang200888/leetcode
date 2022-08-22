class Solution {
    public String smallestNumber(String pattern) {
        StringBuilder sb = new StringBuilder();
        int smallest = 1;
        for (int i = 0; i < pattern.length(); ++i) {
            if (pattern.charAt(i) == 'I') {
                sb.append(smallest);
                ++smallest;
            } else {
                int count = 1;
                while (i + count < pattern.length() && pattern.charAt(i + count) == 'D') {
                    ++count;
                }

                int nextSmallest = smallest + count + 1;
                i += count;
                while (count >= 0) {
                    sb.append(smallest + count);
                    --count;
                }
                
                smallest = nextSmallest;
            }
        }
        
        if (pattern.charAt(pattern.length() - 1) == 'I') {
           sb.append(smallest); 
        }

        return sb.toString();
    }
}

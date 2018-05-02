class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<String>();
        if (words == null)
            return res;
        int firstWord = 0;
        int len = 0;
        
        for (int i = 0; i < words.length; ++i) {
            int newLen = len + words[i].length();
            if (len > 0)
                ++newLen;
            
            if (newLen > maxWidth) {
                int spaces = maxWidth - len + i - firstWord - 1;
                String s = words[firstWord++];
                if (i - firstWord == 0) {
                    for (int j = s.length(); j < maxWidth; ++j)
                        s += " ";                    
                } else {
                    int avg = spaces / (i - firstWord);
                    int offset = spaces - avg * (i - firstWord);
                
                    for ( ; firstWord < i; ++firstWord) {
                        for (int j = 0; j < avg; ++j)
                            s += " ";
                        if (offset > 0) {
                            s += " ";
                            --offset;
                        }
                        s += words[firstWord];
                    }
                }
                res.add(s);
                firstWord = i;
                len = words[i].length();
            } else if (i == words.length - 1) {
                String s = words[firstWord++];
                for ( ; firstWord < words.length; ++firstWord) {
                    s += " " + words[firstWord];
                }
                
                for (int j = s.length(); j < maxWidth; ++j)
                    s += " ";

                res.add(s);
            } else {
                len = newLen;
            }
        }
        
        if (firstWord < words.length) {
            String s = words[firstWord++];
            for ( ; firstWord < words.length; ++firstWord) {
                s += " " + words[firstWord];
            }
                
            for (int j = s.length(); j < maxWidth; ++j)
                s += " ";
                
            res.add(s);
        }
        
        return res;
    }
}

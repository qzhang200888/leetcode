
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int i = 0;
        List<String> lst = new ArrayList<>();
        while (i < words.length) {
            int length = 0;
            
            int j = i;
            length += words[i].length();
            while ((j + 1)< words.length) {
                if (length + words[j + 1].length() + 1 > maxWidth)
                    break;
                length += words[j+1].length() + 1;
                ++j;
            }
            
            int spaces = j - i;
            if (j < words.length - 1)
                spaces += maxWidth - length;
            
            int remainder = 0;
            int num = 0;
            
            StringBuilder sb = new StringBuilder();
            sb.append(words[i]);
            
            if (j > i) {
                remainder = spaces % (j - i);
                num = spaces / (j - i);
            } else if (j < words.length) {
                for (int k = 0; k < spaces; ++k)
                    sb.append(' ');
            }
            
            ++i;
            while (i <= j) {
                for (int k = 0; k < num; ++k)
                    sb.append(' ');
                if (remainder > 0) {
                    sb.append(' ');
                    --remainder;
                }
                
                sb.append(words[i]);
                
                ++i;
            }

            if (i == words.length) {
                for (int k = 0; k < maxWidth - length; ++k)
                    sb.append(' ');
            }
            
            lst.add(sb.toString());
        }
        
        return lst;
    }
}

========================================================================

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

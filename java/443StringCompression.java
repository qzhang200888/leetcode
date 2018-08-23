class Solution {
    int addNum(char[] chars, int start, int num) {
        int pos = start;
        while (num > 0) {
            chars[pos++] = (char)('0' + (num % 10));
            num /= 10;
        }
        
        int i = start, j = pos - 1;
        while (i < j) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
            
            ++i;
            --j;
        }
        
        return pos - start;
    }
    
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0)
            return 0;
        
        int curCount = 0;
        char curChar = '\0';
        int curPos = 0;
        
        for (int i = 0; i < chars.length; ++i) {
            if (chars[i] != curChar) {
                if (curCount > 0) {
                    chars[curPos++] = curChar;
                    if (curCount > 1) {
                        curPos += addNum(chars, curPos, curCount);
                    }
                }
                curCount = 1;
                curChar = chars[i];
            } else {
                ++curCount;
            } 
        }
        
        chars[curPos++] = curChar;
        if (curCount > 1) {
            curPos += addNum(chars, curPos, curCount);
        }
        
        return curPos;
    }
}

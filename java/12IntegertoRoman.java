class Solution {
    void intToRoman(StringBuilder s, char[] charList, int num) {
        if (num == 0)
            return;
        
        if (num < 4) {
            for (int i = 0; i < num; ++i)
                s.append(charList[0]);
        } else if (num == 4) {
            s.append(charList[0]);
            s.append(charList[1]);
        } else if (num <= 8) {
            s.append(charList[1]);
            intToRoman(s, charList, num - 5);
        } else {
            s.append(charList[0]);
            s.append(charList[2]);                
        }
    }
    
    public String intToRoman(int num) {
        char[][] chars = new char[][] {{'I', 'V', 'X'},
                                       {'X', 'L', 'C'},
                                       {'C', 'D', 'M'},
                                       {'M'}};
        
        StringBuilder s = new StringBuilder();
        
        intToRoman(s, chars[3], num / 1000);
        num %= 1000;

        intToRoman(s, chars[2], num / 100);
        num %= 100;

        intToRoman(s, chars[1], num / 10);
        num %= 10;
        
        intToRoman(s, chars[0], num);
        
        return s.toString(); 
        
    }
}

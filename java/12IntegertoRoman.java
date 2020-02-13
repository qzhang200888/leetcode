class Solution {
    /**
       The helper functiom

       here 0 < num < 10
     */
    void intToRoman(StringBuilder s, char[] charList, int num) {
        if (num == 0)
            return;
        
        if (num < 4) {
            // num = 1, 2, 3
            // I, II, III for ones
            // X, XX, XXX for tens
            // C, CC, CCC for hundreds
            for (int i = 0; i < num; ++i)
                s.append(charList[0]);
        } else if (num == 4) {
            // num = 4
            // IV for ones
            // XL foe tens
            // CD for hundreds
            s.append(charList[0]);
            s.append(charList[1]);
        } else if (num == 5) {
            // V for ones
            // L foe tens
            // D for hundreds
            s.append(charList[1]);
        } else if (num <= 8) {
            // num = 6, 7, 8
            // VI, VII, VIII for ones
            // LX, LXX, LXX for tens
            // DC, DCC, DCC for hundreds
            s.append(charList[1]);
            intToRoman(s, charList, num - 5);
        } else {
            // num = 9
            // IX for ones 9
            // XC for tens 90
            // CM for hundreds 900
            s.append(charList[0]);
            s.append(charList[2]);                
        }
    }
    /**
       We assume num < 4000
    */
    public String intToRoman(int num) {
        char[][] chars = new char[][] {{'I', 'V', 'X'},
                                       {'X', 'L', 'C'},
                                       {'C', 'D', 'M'},
                                       {'M'}};
        
        // use StringBuilder to append chars one by one
        // and convert to string at the end. It is more efficient.
        StringBuilder s = new StringBuilder();
        
        // only use {'M'} since num < 4000 so num / 1000 < 4
        // for digit at thousand
        intToRoman(s, chars[3], num / 1000);
        num %= 1000;

        // only use {'C', 'D', 'M'}
        // for digits at hundreds
        intToRoman(s, chars[2], num / 100);
        num %= 100;

        // only use {'X', 'L', 'C'}
        // for digits at tens
        intToRoman(s, chars[1], num / 10);
        num %= 10;
        
        // only use {'I', 'V', 'X'}
        // for digits at ones
        intToRoman(s, chars[0], num);
 
        // convert to string at the end       
        return s.toString(); 
        
    }
}

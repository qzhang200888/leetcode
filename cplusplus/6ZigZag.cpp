}ss Solution {
public:
    string convert(string s, int numRows) {
        if (numRows <= 1)
            return s;
        
        string *list = new string[numRows];
        for (int i = 0; i < numRows; ++i)
            list[i] = "";
        
        int row = 0;
        bool up = true;
        for (int i = 0; i < s.length(); ++i) {
            list[row] += s.at(i);
            if (row == numRows - 1) {
                --row;
                up = false;
            } else if (row == 0) {
                ++row;
                up = true;              
            } else if (up) {
                ++row;
            } else {
                --row;
            }
        }
        
        string res = "";
        for (int i = 0; i < numRows; ++i)
            res += list[i];
        
        delete[] list;
        
        return res;
    }
};

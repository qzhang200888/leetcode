class Solution {
public:
    int totalFruit(vector<int>& tree) {
        int num1 = 0, num2 = 0, count1 = 0, count2 = 0;
        int last1 = 0, last2 = 0;
        int max = 0;
        int k = 0;
        for (int i: tree) {
            if (count1 == 0) {
                num1 = i;
                count1 = 1;
                last1 = k; 
            } else if (i == num1) {
                ++count1;
                last1 = k; 
            } else if (count2 == 0) {
                num2 = i;
                count2 = 1;
                last2 = k; 
            } else if (i == num2) {
                ++count2;
                last2 = k; 
            } else {
                if (max < count1 + count2)
                    max = count1 + count2;
                if (last1 < last2) {
                    num1 = num2;
                    count1 = k - last1 - 1;
                    last1 = last2;
                } else {
                    count1 = k - last2 - 1;
                }
                
                num2 = i;
                count2 = 1;
                last2 = k;
            }
            
            ++k;
        }
        
        return max < count1 + count2 ? count1 + count2 : max;
    }
};

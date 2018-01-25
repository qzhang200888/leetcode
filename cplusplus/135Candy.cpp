class Solution {
public:
    int candy(vector<int>& ratings) {
        if (ratings.size() == 0)
            return 0;
        
        vector<int> candies;
        candies.push_back(1);
        for (int  i = 1; i < ratings.size(); ++i) {
            if (ratings[i] > ratings[i-1])
                candies.push_back(candies[i-1] + 1);
            else {
                candies.push_back(1);
            }
        }
        
        for (int  i = candies.size() - 1; i > 0; --i) {
            if (ratings[i-1] > ratings[i] && candies[i-1] < candies[i] + 1)
                candies[i-1] = candies[i] + 1;
        }
            
        int sum = 0;
        for (int  i = 0; i < candies.size(); ++i)
            sum += candies[i];
        
        return sum;
    }
};

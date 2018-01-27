class Solution {
public:
    vector<pair<int, int>> getSkyline(vector<vector<int>>& buildings) {
        vector<pair<int, int>> heights;
        for (int i = 0; i < buildings.size(); ++i) {
            heights.push_back(make_pair(buildings[i][0], buildings[i][2]));
            heights.push_back(make_pair(buildings[i][1], -buildings[i][2]));
        }
        
        sort(heights.begin(), heights.end());
        
        vector<pair<int, int>> res;
        map<int, int> m;
            
        int max = 0;
        for (int i = 0; i < heights.size(); ++i) {
            if (heights[i].second > 0) {
                if (heights[i].second > max) {
                    max = heights[i].second;
                    
                    if (res.size() > 0 && res.back().first == heights[i].first) {
                        res.back().second = max;
                        if (res.size() > 1 && res[res.size()-2].second == max)
                            res.pop_back();
                    } else res.push_back(make_pair(heights[i].first, max));
                }
                
                ++m[heights[i].second];
                
            } else {
                --m[-heights[i].second];
                if (m[-heights[i].second] == 0)
                    m.erase(-heights[i].second);
                
                if (max == -heights[i].second) {
                    int new_max = 0;
                    if (m.size() > 0)
                        new_max = (--m.end())->first;
                        
                    if (new_max < max) {
                        max = new_max;
                        if (res.size() > 0 && res.back().first == heights[i].first) {
                            if (res.size() > 1 && res[res.size()-2].second > res[res.size()-1].second)
                                res[res.size()-1].second = new_max;
                        } else
                            res.push_back(make_pair(heights[i].first, max));
                    }
                }    
            }
        }
        
        return res;
    }
};

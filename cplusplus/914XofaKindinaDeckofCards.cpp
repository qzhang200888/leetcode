class Solution {
    int gcd(int a, int b){
        if(b==0) return a;
        else return gcd(b, a%b);
    }
public:
    bool hasGroupsSizeX(vector<int>& deck) {
        if (deck.size() == 1)
            return false;
        
        unordered_map<int, int> map;
        for (int i: deck) {
            auto it = map.find(i);
            if (it != map.end()) {
                it->second += 1;
            } else {
                map.insert({i, 1});
            }
        }
        
        int x = map.find(deck.at(0))->second;
        for (auto it = map.begin(); it != map.end(); ++it ) {
            x = gcd(x, it->second);
            if (x < 2)
                return false;
        }
        
        return true;
    }
};

class Solution {
public:
    string reorganizeString(string S) {
        unordered_map<char, int> map;
        for (int i = 0; i < S.length(); ++i) {
            ++map[S.at(i)];
        }

        priority_queue<pair<int, char> > q;
        for (unordered_map<char, int>::iterator it = map.begin(); it != map.end(); ++it) {
            make_pair(it->second, it->first);
            q.push(make_pair(it->second, it->first));
        }

        char *chs = new char[S.length() + 1];
        chs[S.length()] = '\0';
        
        int indexOdd = 1;
        int indexEven = 0;

        while (q.size() > 0) {
            pair<int, char> v = q.top();
            q.pop();
            for (int i = 0; i < v.first; ++i) {
                if (indexEven < S.length()) {
                    chs[indexEven] = v.second;
                    indexEven += 2;
                } else {
                    chs[indexOdd] = v.second;
                    indexOdd += 2;
                }
            }
        }

        for (int i = 0; i < S.length() - 1; ++i) {
            if (chs[i] == chs[i+1])
                return "";
        }

        string res = string(chs);
        delete[] chs;

        return res;
    }
};
